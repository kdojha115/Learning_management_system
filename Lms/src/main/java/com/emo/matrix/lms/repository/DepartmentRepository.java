package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Department;
import com.emo.matrix.lms.models.Teacher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Optional<String> findByName(String department);
}
