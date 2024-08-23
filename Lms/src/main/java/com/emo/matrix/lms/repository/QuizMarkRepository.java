package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.QuizMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuizMarkRepository extends JpaRepository<QuizMark, Long> {
    Optional<QuizMark> findByStudentIdAndQuizId(Long studentId, Long quizId);

	List<QuizMark> findByQuizId(Long quizId);

	List<QuizMark> findByStudentId(Long studentId);
}
