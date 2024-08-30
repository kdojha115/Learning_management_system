package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.dto.AdminDTO;
import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.service.AdminService;
import com.emo.matrix.lms.utils.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminUtil adminUtil;

    @GetMapping("/")
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        List<Admin> admins = adminService.getAllAdmins();
        List<AdminDTO> adminDTOs = admins.stream()
                .map(adminUtil::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(adminDTOs);
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDTO> createAdmin(@RequestBody Admin admin) {
//        Admin admin = adminUtil.toEntity(adminDTO);
        log.debug("Password received: {}", admin.getPassword()); 
        Admin createdAdmin = adminService.createAdmin(admin);
        AdminDTO createdAdminDTO = adminUtil.toDTO(createdAdmin);
        return ResponseEntity.ok(createdAdminDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDTO> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.findAdminById(id);
        if (admin.isPresent()) {
            AdminDTO adminDTO = adminUtil.toDTO(admin.get());
            return ResponseEntity.ok(adminDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDTO> updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        try {
//            Admin adminDetails = adminUtil.toEntity(admin);
            Admin updatedAdmin = adminService.updateAdmin(id, admin);
            AdminDTO updatedAdminDTO = adminUtil.toDTO(updatedAdmin);
            return ResponseEntity.ok(updatedAdminDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/approve/teacher/{teacherId}")
    public ResponseEntity<String> approveTeacher(@PathVariable Long id, @PathVariable Long teacherId) {
        try {
            adminService.approveTeacher(teacherId, id);
            return ResponseEntity.ok("Teacher account id " + teacherId + " approved by Admin Id " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable Long id) {
        try {
            if (adminService.existsById(id)) {
                adminService.deleteAdmin(id);
                return ResponseEntity.ok("Admin account with id " + id + " deleted successfully!");
            } else {
                return ResponseEntity.badRequest().body("Admin not found with id " + id);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
