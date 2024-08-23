package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.StudentAssignment;
import com.emo.matrix.lms.models.StudentAssignmentPk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentAssignmentRepository extends JpaRepository<StudentAssignment, StudentAssignmentPk> {
    List<StudentAssignment> findByStudentId(Long studentId);
    List<StudentAssignment> findByAssignmentId(Long assignmentId);
	Optional<StudentAssignment> findByStudentIdAndAssignmentId(Long studentId, Long assignmentId);
//	List<StudentAssignment> findByStudentId(Long studentId);
}
