package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findByCourseId(Long courseId);
}
