package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Feedback;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

	List<Feedback> findByStudentId(Long studentId);

	List<Feedback> findByTeacherId(Long teacherId);

	List<Feedback> findByCourseId(Long courseId);
}
