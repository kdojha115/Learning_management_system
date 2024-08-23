package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.StudentAssignment;
import com.emo.matrix.lms.service.StudentAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student-assignment")
public class StudentAssignmentController {

    @Autowired
    private StudentAssignmentService studentAssignmentService;

    // Assign an Assignment to a Student
    @PostMapping("/assign")
    public ResponseEntity<StudentAssignment> assignAssignmentToStudent(@RequestParam Long studentId, @RequestParam Long assignmentId) {
        StudentAssignment studentAssignment = studentAssignmentService.assignAssignmentToStudent(studentId, assignmentId);
        return ResponseEntity.ok(studentAssignment);
    }

    // Get all Assignments for a specific Student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentAssignment>> getAssignmentsByStudentId(@PathVariable Long studentId) {
        List<StudentAssignment> studentAssignments = studentAssignmentService.getAssignmentsByStudentId(studentId);
        return ResponseEntity.ok(studentAssignments);
    }

    // Get a specific Assignment for a Student
    @GetMapping("/student/{studentId}/assignment/{assignmentId}")
    public ResponseEntity<StudentAssignment> getAssignmentByStudentIdAndAssignmentId(@PathVariable Long studentId, @PathVariable Long assignmentId) {
        Optional<StudentAssignment> studentAssignment = studentAssignmentService.getAssignmentByStudentIdAndAssignmentId(studentId, assignmentId);
        return studentAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update the Grade of an Assignment for a Student
    @PutMapping("/update-grade")
    public ResponseEntity<StudentAssignment> updateGrade(@RequestParam Long studentId, @RequestParam Long assignmentId, @RequestParam int grade) {
        Optional<StudentAssignment> updatedStudentAssignment = studentAssignmentService.updateGrade(studentId, assignmentId, grade);
        return updatedStudentAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a specific Assignment for a Student
    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAssignment(@RequestParam Long studentId, @RequestParam Long assignmentId) {
        studentAssignmentService.deleteAssignment(studentId, assignmentId);
        return ResponseEntity.noContent().build();
    }

    // Get all StudentAssignments
    @GetMapping("/")
    public ResponseEntity<List<StudentAssignment>> getAllStudentAssignments() {
        List<StudentAssignment> studentAssignments = studentAssignmentService.getAllStudentAssignments();
        return ResponseEntity.ok(studentAssignments);
    }
}
