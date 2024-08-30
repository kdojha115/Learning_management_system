package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Quiz;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findByCourseId(Long courseId);

	Set<Quiz> findAllByIdIn(Set<String> quizs);

	Set<Quiz> findAllByTitleIn(Set<String> quizs);
}
