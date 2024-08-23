package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    Optional<Student> findByPhoneNumber(String phoneNumber);
}
