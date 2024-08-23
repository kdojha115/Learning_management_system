package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.FeedbackQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackQuestionRepository extends JpaRepository<FeedbackQuestion, Long> {
    List<FeedbackQuestion> findByFeedbackId(Long feedbackId);
}
