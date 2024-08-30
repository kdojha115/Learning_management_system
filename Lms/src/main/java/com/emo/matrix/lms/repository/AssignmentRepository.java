package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByCourseId(Long courseId);

	Set<Assignment> findAllByIdIn(Set<String> assignments);

	Set<Assignment> findAllByTitleIn(Set<String> assignments);
}
