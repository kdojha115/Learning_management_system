package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.TeacherRepository;
import com.emo.matrix.lms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private AdminRepository adminRepository;
    
    @GetMapping("/")
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // Create a new Admin
    @PostMapping("/create")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.createAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    // Get Admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an Admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        try {
            Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
            return ResponseEntity.ok(updatedAdmin);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Approve a Teacher
    @PostMapping("/{id}/approve/teacher/{teacherId}")
    public ResponseEntity<Teacher> approveTeacher(@PathVariable Long teacherId, @PathVariable Long id) {
        try {
        	Admin admin = adminRepository.findById(id).get();
        	Teacher teacher = teacherRepository.findById(teacherId).get();
            adminService.approveTeacher(teacherId,id);
            return ResponseEntity.ok(teacher);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    

    // Delete an Admin
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        try {
        	if(adminRepository.existsById(id)  ) {
        		adminService.deleteAdmin(id);
        		return ResponseEntity.ok("Admin account with id " + id + " deleted successfully!.");
        	}
        	else {
        		String errorMessage = "Admin not found with id " + id;
                return ResponseEntity.badRequest().body(errorMessage);
        	}
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
