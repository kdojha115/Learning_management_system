package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.helper.FileUploadHelper;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.repository.CourseRepository;
import com.emo.matrix.lms.service.CourseService;
import com.emo.matrix.lms.utils.CourseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CourseRepository courseRepository;
    
//    @Autowired
//    private CourseUtil courseUtil;
    
    @Autowired
    private FileUploadHelper fileUploadHelper; 

    // Create a new course
    @PostMapping("/adminId/{adminId}/create")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course, @PathVariable Long adminId) {
    	Course craetedCourse = courseService.createCourse(course, adminId);
        CourseDTO createdCourseDTO = CourseUtil.toDTO(craetedCourse);
        return ResponseEntity.ok(createdCourseDTO);
    }

    @PostMapping(value = "/{id}/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "video/mp4"})
    public ResponseEntity<String> uploadVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
    	
    	
    	try {
    		
    		if(file.isEmpty()) {
    			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
    		}
    		
    		boolean f = fileUploadHelper.uploadFile(file);
    		if(f) {
    			courseService.uploadVideo(id,file);
    			
//    			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/video/").path(file.getOriginalFilename()).toUriString());
    			return ResponseEntity.ok("File is successfully uploaded");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

      return ResponseEntity.ok("Video uploaded successfully!");
    }

//    
//    // Upload video file for a course
//    @PostMapping(value = "/{id}/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "video/mp4"})
//    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
//        try {
//            Course video = new Course();
//            video.setVideoFiles(file.getBytes()); // Store the video as a byte array
//
//            // Save video to the database using your service or repository
//            courseService.save(video);
//
//            return ResponseEntity.ok("Video uploaded successfully!");
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Failed to upload video: " + e.getMessage());
//        }
//    }

    // Update an existing course
//    @PutMapping("/{id}")
//    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseDTO updatedCourseDTO) {
//        try {
//            CourseDTO course = courseService.updateCourse(id, updatedCourseDTO);
//            return ResponseEntity.ok(course);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Get all courses
    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
    	List<Course> courses = courseService.getAllCourses();
        List<CourseDTO> courseDTOs = courses.stream().map(CourseUtil::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(courseDTOs);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        Optional<CourseDTO> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        try {
        	if(courseRepository.existsById(id)) {
        		courseService.deleteCourse(id);
        		return ResponseEntity.ok("Cours with id " + id + " deleted successfully!.");
        	}
        	else {
        		String errorMessage = "Course not found with id " + id;
                return ResponseEntity.badRequest().body(errorMessage);
        	}
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get courses by a student's ID
//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable Long studentId) {
//        try {
//            List<CourseDTO> courses = courseService.getCoursesByStudentId(studentId);
//            return ResponseEntity.ok(courses);
//        } catch (RuntimeException e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

    // Enroll a student in a course
    @PostMapping("/{courseId}/enroll-student/{studentId}")
    public ResponseEntity<CourseDTO> enrollStudentInCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            CourseDTO course = courseService.enrollStudentInCourse(courseId, studentId);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove a student from a course
    @DeleteMapping("/{courseId}/remove-student/{studentId}")
    public ResponseEntity<String> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
        	if(courseRepository.existsById(courseId)) {
        		CourseDTO course = courseService.removeStudentFromCourse(courseId, studentId);
        		return ResponseEntity.ok("Student account with id " + studentId + " removed from Course id "+ courseId +" successfully!.");
        	} else {
        		String errorMessage = "Course not found with id " + courseId;
                return ResponseEntity.badRequest().body(errorMessage);
        	}
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
