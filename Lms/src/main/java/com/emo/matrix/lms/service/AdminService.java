package com.emo.matrix.lms.service;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin existingAdmin = adminRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Admin not found with id " + id)
        );

        // Update fields only if they are provided (non-null or non-empty)
        if (adminDetails.getName() != null) {
            existingAdmin.setName(adminDetails.getName());
        }
        if (adminDetails.getEmail() != null) {
            existingAdmin.setEmail(adminDetails.getEmail());
        }
        if (adminDetails.getPhoneNumber() != null) {
            existingAdmin.setPhoneNumber(adminDetails.getPhoneNumber());
        }
        if (adminDetails.getPassword() != null) {
            existingAdmin.setPassword(adminDetails.getPassword());
        }
        if (adminDetails.isSuperAdmin() ) { // Assuming superAdmin is a Boolean
            existingAdmin.setSuperAdmin(adminDetails.isSuperAdmin());
        }
        if (adminDetails.getTeachers() != null && !adminDetails.getTeachers().isEmpty()) {
            existingAdmin.setTeachers(adminDetails.getTeachers());
        }
        if (adminDetails.getStudents() != null && !adminDetails.getStudents().isEmpty()) {
            existingAdmin.setStudents(adminDetails.getStudents());
        }
        if (adminDetails.getCourses() != null && !adminDetails.getCourses().isEmpty()) {
            existingAdmin.setCourses(adminDetails.getCourses());
        }

        // Update other fields like createdBy, updatedAt, etc., if needed
        existingAdmin.setUpdatedBy(adminDetails.getUpdatedBy()); // Example
        existingAdmin.setUpdatedAt(adminDetails.getUpdatedAt()); // Example

        // Save and return the updated admin
        return adminRepository.save(existingAdmin);
    }


    public void approveTeacher(Long teacherId, Long adminId) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherId);
        Optional<Admin> admin = adminRepository.findById(adminId);
        if (teacher.isPresent()) {
            Teacher t = teacher.get();
            Admin a = admin.get();
            // Perform the approval operation
             t.setApproved(true);
             t.setIndependent(false);
             t.setUpdatedBy(a.getName());
             t.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
             teacherRepository.save(t);
        } else {
            throw new ResourceNotFoundException("Teacher not found with id " + teacherId);
        }
    }

    public boolean existsById(Long id) {
        return adminRepository.existsById(id);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
