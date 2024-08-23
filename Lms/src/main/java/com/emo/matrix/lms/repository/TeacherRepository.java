package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);
    Optional<Teacher> findByPhoneNumber(String phoneNumber);
}
