package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Enrollment;
import com.emo.matrix.lms.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Enroll a student in a course
    @PostMapping("/enroll")
    public ResponseEntity<Enrollment> enrollStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
        try {
            Enrollment enrollment = enrollmentService.enrollStudentInCourse(studentId, courseId);
            return ResponseEntity.ok(enrollment);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // Get all enrollments
    @GetMapping("/")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    // Get enrollments by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByStudentId(@PathVariable Long studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudentId(studentId);
        return ResponseEntity.ok(enrollments);
    }

    // Get enrollments by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getEnrollmentsByCourseId(@PathVariable Long courseId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByCourseId(courseId);
        return ResponseEntity.ok(enrollments);
    }

    // Remove an enrollment by ID
    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> removeEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.removeEnrollment(enrollmentId);
        return ResponseEntity.noContent().build();
    }
}
