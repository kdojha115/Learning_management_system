package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.service.CourseService;
import com.emo.matrix.lms.utils.CourseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private CourseUtil courseUtil;

    // Create a new course
    @PostMapping("/adminId/{adminId}/create")
    public ResponseEntity<CourseDTO> createCourse(@RequestBody Course course, @PathVariable Long adminId) {
    	Course craetedCourse = courseService.createCourse(course, adminId);
        CourseDTO createdCourseDTO = courseUtil.toDTO(craetedCourse);
        return ResponseEntity.ok(createdCourseDTO);
    }

    @PostMapping(value = "/{id}/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, "video/mp4"})
    public ResponseEntity<String> uploadVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
//        try {
//            Course course = courseService.uploadVideo(id, file);
//            return ResponseEntity.ok("Video uploaded successfully!");
//        } catch (RuntimeException e) {
//            // Handle specific runtime exceptions
//            return ResponseEntity.status(404).body(e.getMessage());
//        } catch (Exception e) {
//            // Handle general exceptions
//            return ResponseEntity.status(500).body("Failed to upload video: " + e.getMessage());
//        }
    	System.out.println(file.getOriginalFilename());
    	System.out.println(file.getSize());
    	System.out.println(file.getContentType());
    	System.out.println(file.getName());

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
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id) {
        Optional<CourseDTO> course = courseService.getCourseById(id);
        return course.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a course by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get courses by a student's ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<CourseDTO>> getCoursesByStudentId(@PathVariable Long studentId) {
        try {
            List<CourseDTO> courses = courseService.getCoursesByStudentId(studentId);
            return ResponseEntity.ok(courses);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Enroll a student in a course
    @PostMapping("/{courseId}/enroll/{studentId}")
    public ResponseEntity<CourseDTO> enrollStudentInCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            CourseDTO course = courseService.enrollStudentInCourse(courseId, studentId);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove a student from a course
    @DeleteMapping("/{courseId}/remove/{studentId}")
    public ResponseEntity<CourseDTO> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            CourseDTO course = courseService.removeStudentFromCourse(courseId, studentId);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
