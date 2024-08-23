package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.AnsweredQuestion;
import com.emo.matrix.lms.models.StudentAssignment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnsweredQuestionRepository extends JpaRepository<AnsweredQuestion, Long> {
    List<AnsweredQuestion> findByStudentAssignmentId(StudentAssignment studentAssignment);

	List<AnsweredQuestion> findByStudentId(Long studentId);

	List<AnsweredQuestion> findByQuizId(Long quizId);
}
