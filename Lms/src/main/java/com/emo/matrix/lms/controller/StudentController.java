package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.dto.StudentDTO;
import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.StudentRepository;
import com.emo.matrix.lms.service.StudentService;
import com.emo.matrix.lms.utils.StudentUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	
	@Autowired StudentUtil studentUtil;

    @Autowired
    private StudentService studentService;
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private AdminRepository adminRepository;

    // Get all students
    @GetMapping("/")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentDTO> studentDTOs = students.stream()
        		.map(studentUtil::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(studentDTOs);
    }

    // Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.findStudentById(id);
        if (student.isPresent()) {
        	StudentDTO studentDTO = studentUtil.toDTO(student.get());
            return ResponseEntity.ok(studentDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new student
    @PostMapping("/create")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody Student student) {
    	log.debug("Password received: {}", student.getPassword()); 
    	Student createdStudent = studentService.createStudent(student);
    	StudentDTO createdStudentDTO = studentUtil.toDTO(createdStudent);
        return ResponseEntity.ok(createdStudentDTO);
    }
    
    
    @PostMapping("/create/admin/{adminId}")
    public ResponseEntity<StudentDTO> createdStudentByAdmin(@RequestBody Student student, @PathVariable Long adminId) {
    	log.debug("Password received: {}", student.getPassword()); 
    	Student createdStudent = studentService.createdStudentByAdmin(student, adminId);
    	StudentDTO createdStudentDTO = studentUtil.toDTO(createdStudent);
        return ResponseEntity.ok(createdStudentDTO);
    }

    // Update an existing student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody Student student) {
       try {
    	   Student updatedStudent = studentService.updateStudent(id, student);
    	   StudentDTO updatedStudentDTO = studentUtil.toDTO(updatedStudent);
           return ResponseEntity.ok(updatedStudentDTO);
           
       } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
    	}
    }
    
    @PutMapping("/{id}/admin/{adminId}")
    public ResponseEntity<StudentDTO> updateStudentByAdmin(@PathVariable Long id,@PathVariable Long adminId, @RequestBody Student student) {
       try {
    	   Student updatedStudent = studentService.updateStudentByAdmin(id, adminId, student);
    	   StudentDTO updatedStudentDTO = studentUtil.toDTO(updatedStudent);
    	   updatedStudentDTO.setUpdatedBy(adminRepository.findById(adminId).get().getName());
           return ResponseEntity.ok(updatedStudentDTO);
           
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
    public ResponseEntity<Set<CourseDTO>> getCoursesByStudentId(@PathVariable Long id) {
        Set<CourseDTO> courseDTOs = studentService.getCoursesByStudentId(id);
        if (courseDTOs != null) {
            return ResponseEntity.ok(courseDTOs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
