package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByPhoneNumber(String phoneNumber);

    // Find the SuperAdmin
    Optional<Admin> findByIsSuperAdminTrue();

    // Check if a SuperAdmin exists
    boolean existsByIsSuperAdminTrue();
	Optional<Admin> findById(Admin admin);
    
    
}
