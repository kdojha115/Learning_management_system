package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
