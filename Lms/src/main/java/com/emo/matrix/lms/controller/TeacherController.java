package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.dto.TeacherDTO;
import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.service.TeacherService;
import com.emo.matrix.lms.utils.TeacherUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {
	
	private static final Logger log = LoggerFactory.getLogger(TeacherController.class);


    @Autowired
    private TeacherService teacherService;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private TeacherUtil teacherUtil;

    @PostMapping("/create")
    public ResponseEntity<TeacherDTO> createTeacher(@RequestBody Teacher teacher) {

        log.debug("Password received: {}", teacher.getPassword()); 
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        TeacherDTO createdTeacherDTO = teacherUtil.toDTO(createdTeacher);
        return ResponseEntity.ok(createdTeacherDTO);
    }
    
    @PostMapping("/create/admin/{adminId}")
    public ResponseEntity<TeacherDTO> createdTeacherByAdmin(@RequestBody Teacher teacher, @PathVariable Long adminId) {

        log.debug("Password received: {}", teacher.getPassword()); 
        Teacher createdTeacher = teacherService.createdTeacherByAdmin(teacher,adminId);
        TeacherDTO createdTeacherDTO = teacherUtil.toDTO(createdTeacher);
        return ResponseEntity.ok(createdTeacherDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        try {
        	Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
            TeacherDTO updatedTeacherDTO = teacherUtil.toDTO(updatedTeacher);
            return ResponseEntity.ok(updatedTeacherDTO);
        }
        catch (ResourceNotFoundException e) {
        	return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{id}/admin/{adminId}")
    public ResponseEntity<TeacherDTO> updateTeacherByAdmin(@PathVariable Long id,@PathVariable Long adminId, @RequestBody Teacher teacher) {
        try {
        	Teacher updatedTeacher = teacherService.updateTeacherByAdmin(id,adminId, teacher);
            TeacherDTO updatedTeacherDTO = teacherUtil.toDTO(updatedTeacher);
            updatedTeacherDTO.setUpdatedBy(adminRepository.findById(adminId).get().getName());
            return ResponseEntity.ok(updatedTeacherDTO);
        }
        catch (ResourceNotFoundException e) {
        	return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getTeacherById(@PathVariable Long id) {
    	Optional<Teacher> teacher = teacherService.findTeacherById(id);
    	if(teacher.isPresent()) {
    		TeacherDTO teacherDTO = teacherUtil.toDTO(teacher.get());
    		return ResponseEntity.ok(teacherDTO);
    	} else {
    		return ResponseEntity.notFound().build();
    	}
    }

    @GetMapping("/")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
    	List<Teacher> teachers = teacherService.getAllTeachers();  
        List<TeacherDTO> teacherDTOs = teachers.stream()
                .map(teacherUtil::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(teacherDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Long id) {
        
        try {
            if (teacherService.existsById(id)) {
    
                teacherService.deleteTeacher(id);
                return ResponseEntity.ok("Teacher account with id " + id + " deleted successfully!");
            } else {
                return ResponseEntity.badRequest().body("Teacher not found with id " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{teacherId}/assign-course/{courseId}")
    public ResponseEntity<TeacherDTO> assignCourseToTeacher(@PathVariable Long teacherId, @PathVariable Long courseId) {
        try {
            Teacher teacher = teacherService.assignCourseToTeacher(teacherId, courseId);
            TeacherDTO teacherDTO = teacherUtil.toDTO(teacher);
            return ResponseEntity.ok(teacherDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
