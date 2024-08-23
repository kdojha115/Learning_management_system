package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Assignment;
import com.emo.matrix.lms.models.StudentAssignment;
import com.emo.matrix.lms.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    // Create a new Assignment
    @PostMapping("/create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment createdAssignment = assignmentService.createAssignment(assignment);
        return ResponseEntity.ok(createdAssignment);
    }

    // Get all Assignments
    @GetMapping("/")
    public ResponseEntity<List<Assignment>> getAllAssignments() {
        List<Assignment> assignments = assignmentService.getAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    // Get Assignments by Course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Assignment>> getAssignmentsByCourseId(@PathVariable Long courseId) {
        List<Assignment> assignments = assignmentService.getAssignmentsByCourseId(courseId);
        return ResponseEntity.ok(assignments);
    }

    // Get a specific Assignment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.getAssignmentById(id);
        return assignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing Assignment
    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignmentDetails) {
        try {
            Assignment updatedAssignment = assignmentService.updateAssignment(id, assignmentDetails);
            return ResponseEntity.ok(updatedAssignment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an Assignment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        try {
            assignmentService.deleteAssignment(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Assign an Assignment to a Student
    @PostMapping("/assign/{assignmentId}/student/{studentId}")
    public ResponseEntity<StudentAssignment> assignAssignmentToStudent(@PathVariable Long assignmentId, @PathVariable Long studentId) {
        StudentAssignment studentAssignment = assignmentService.assignAssignmentToStudent(assignmentId, studentId);
        return ResponseEntity.ok(studentAssignment);
    }

    // Get Assignments by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentAssignment>> getAssignmentsByStudentId(@PathVariable Long studentId) {
        List<StudentAssignment> studentAssignments = assignmentService.getAssignmentsByStudentId(studentId);
        return ResponseEntity.ok(studentAssignments);
    }

    // Grade an Assignment
    @PutMapping("/grade/{studentId}/assignment/{assignmentId}")
    public ResponseEntity<StudentAssignment> gradeAssignment(@PathVariable Long studentId, @PathVariable Long assignmentId, @RequestParam int grade) {
        try {
            StudentAssignment studentAssignment = assignmentService.gradeAssignment(studentId, assignmentId, grade);
            return ResponseEntity.ok(studentAssignment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
