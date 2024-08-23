package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.FeedbackAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackAnswerRepository extends JpaRepository<FeedbackAnswer, Long> {
    List<FeedbackAnswer> findByStudentId(Long studentId);
    List<FeedbackAnswer> findByFeedbackQuestionId(Long feedbackQuestionId);
}
