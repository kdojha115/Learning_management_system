package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.TeacherRepository;
import com.emo.matrix.lms.service.TeacherService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    
    
    @Autowired
    private TeacherRepository teacherRepository;

    
    @GetMapping("/")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllAdmins();
        return ResponseEntity.ok(teachers);
    }
    
    // Create a new Teacher
    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
    	
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    // Get Teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        try {
            Teacher teacher = teacherService.findTeacherById(id);
            return ResponseEntity.ok(teacher);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Update a Teacher
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacherDetails) {
        try {
            Teacher updatedTeacher = teacherService.updateTeacher(id, teacherDetails);
            return ResponseEntity.ok(updatedTeacher);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        try {
        	if(teacherRepository.existsById(id)) {
        		teacherService.deleteTeacher(id);
        		return ResponseEntity.ok("Teacher account with id " + id + " deleted successfully!.");
        	}
        	else {
        		String errorMessage = "Teacher not found with id " + id;
                return ResponseEntity.badRequest().body(errorMessage);
        	}
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Assign a course to a teacher
    @PostMapping("/{teacherId}/assign-course/{courseId}")
    public ResponseEntity<Void> assignCourseToTeacher(@PathVariable Long teacherId, @PathVariable Long courseId) {
        try {
        	
            teacherService.assignCourseToTeacher(teacherId, courseId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
