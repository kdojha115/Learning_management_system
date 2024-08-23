package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create a new course
    @PostMapping("/adminId/{adminId}/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course course, @PathVariable Long adminId) {
        Course createdCourse = courseService.createCourse(course,adminId);
        return ResponseEntity.ok(createdCourse);
    }
    
    @PostMapping(value = "/{id}/upload",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE, "video/mp4" })
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            Course video = new Course();
            video.setVideoFiles(file.getBytes()); // Store the video as byte array

            // Save video to the database using your service or repository
            courseService.save(video);

            return ResponseEntity.ok("Video uploaded successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to upload video: " + e.getMessage());
        }
    }


    // Update an existing course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        try {
            Course course = courseService.updateCourse(id, updatedCourse);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all courses
    @GetMapping("/")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Get a course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.getCourseById(id);
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
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long studentId) {
        try {
            List<Course> courses = courseService.getCoursesByStudentId(studentId);
            return ResponseEntity.ok(courses);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Enroll a student in a course
    @PostMapping("/{courseId}/enroll/{studentId}")
    public ResponseEntity<Course> enrollStudentInCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            Course course = courseService.enrollStudentInCourse(courseId, studentId);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Remove a student from a course
    @PostMapping("/{courseId}/remove/{studentId}")
    public ResponseEntity<Course> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        try {
            Course course = courseService.removeStudentFromCourse(courseId, studentId);
            return ResponseEntity.ok(course);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
