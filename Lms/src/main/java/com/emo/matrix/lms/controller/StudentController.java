package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.repository.StudentRepository;
import com.emo.matrix.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new student
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
       try {
    	   Student updatedStudent = studentService.updateStudent(id, studentDetails);
           return ResponseEntity.ok(updatedStudent);
       } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
    	}
    }
    

    // Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        
        try {
        	if(studentRepository.existsById(id)) {
        		studentService.deleteStudent(id);
        		return ResponseEntity.ok("Student account with id " + id + " deleted successfully!.");
        	}
        	else {
        		String errorMessage = "Student not found with id " + id;
                return ResponseEntity.badRequest().body(errorMessage);
        	}
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Get courses by student ID
    @GetMapping("/{id}/courses")
    public ResponseEntity<Set<Course>> getCoursesByStudentId(@PathVariable Long id) {
        Set<Course> courses = studentService.getCoursesByStudentId(id);
        if (courses != null) {
            return ResponseEntity.ok(courses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
