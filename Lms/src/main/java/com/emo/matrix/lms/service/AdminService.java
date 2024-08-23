package com.emo.matrix.lms.service;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public void approveTeacher(Long teacherId, Long id) {
        // Find the teacher by ID
        Optional<Teacher> teacherOpt = teacherRepository.findById(teacherId);
        Admin admin = adminRepository.findById(id).get();
        if (teacherOpt.isPresent()) {
            Teacher teacher = teacherOpt.get();
            // Set the teacher as approved
            teacher.setApproved(true);
            teacher.setUpdatedBy(admin.getName());
            // Save the updated teacher
            teacherRepository.save(teacher);
        } else {
            throw new RuntimeException("Teacher not found with ID: " + teacherId);
        }
    }
    
    public Admin updateAdmin(Long adminId, Admin adminDetails) {
        Optional<Admin> existingAdmin = adminRepository.findById(adminId);

        if (existingAdmin.isPresent()) {
            Admin admin = existingAdmin.get();

            // Update fields only if they are provided (non-null)
            if (adminDetails.getName() != null) {
                admin.setName(adminDetails.getName());
            }
            if (adminDetails.getEmail() != null) {
                admin.setEmail(adminDetails.getEmail());
            }
            if (adminDetails.getPhoneNumber() != null) {
                admin.setPhoneNumber(adminDetails.getPhoneNumber());
            }
            if (adminDetails.getPassword() != null) {
                admin.setPassword(adminDetails.getPassword());
            }
            

            // Update related collections only if provided
            if (adminDetails.getTeachers() != null) {
                admin.setTeachers(adminDetails.getTeachers());
            }
            if (adminDetails.getStudents() != null) {
                admin.setStudents(adminDetails.getStudents());
            }
            if (adminDetails.getCourses() != null) {
                admin.setCourses(adminDetails.getCourses());
            }

            // Update audit fields if provided
            
            if (adminDetails.getUpdatedBy() != null) {
                admin.setUpdatedBy(adminDetails.getUpdatedBy());
            }
            if (adminDetails.getUpdatedAt() != null) {
                admin.setUpdatedAt(adminDetails.getUpdatedAt());
            }

            return adminRepository.save(admin);
        } else {
            throw new ResourceNotFoundException("Admin not found with id " + adminId);
        }
    }


    public void assignRoleToUser(Long userId, String role) {
        // Find the user by ID (assuming Admin for simplicity)
        Optional<Admin> adminOpt = adminRepository.findById(userId);
        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            if ("SuperAdmin".equalsIgnoreCase(role)) {
                admin.setSuperAdmin(true);
            } else {
                admin.setSuperAdmin(false);
                // You might need to handle other roles if needed
            }
            // Save the updated admin
            adminRepository.save(admin);
        } else {
            throw new RuntimeException("Admin not found with ID: " + userId);
        }
    }

    public void deleteAdmin(Long adminId) {
    	
    	adminRepository.deleteById(adminId);
    }

    
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
}
