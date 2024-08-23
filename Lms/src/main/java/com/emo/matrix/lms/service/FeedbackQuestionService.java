package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.FeedbackQuestion;
import com.emo.matrix.lms.repository.FeedbackQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackQuestionService {

    @Autowired
    private FeedbackQuestionRepository feedbackQuestionRepository;

    // Create a new FeedbackQuestion
    public FeedbackQuestion createFeedbackQuestion(FeedbackQuestion feedbackQuestion) {
        feedbackQuestion.setCreatedAt(LocalDateTime.now());
        return feedbackQuestionRepository.save(feedbackQuestion);
    }

    // Get all FeedbackQuestions
    public List<FeedbackQuestion> getAllFeedbackQuestions() {
        return feedbackQuestionRepository.findAll();
    }

    // Get FeedbackQuestion by ID
    public Optional<FeedbackQuestion> getFeedbackQuestionById(Long id) {
        return feedbackQuestionRepository.findById(id);
    }

    // Get FeedbackQuestions by Feedback ID
    public List<FeedbackQuestion> getFeedbackQuestionsByFeedbackId(Long feedbackId) {
        return feedbackQuestionRepository.findByFeedbackId(feedbackId);
    }

    // Update an existing FeedbackQuestion
    public FeedbackQuestion updateFeedbackQuestion(Long id, FeedbackQuestion updatedFeedbackQuestion) {
        return feedbackQuestionRepository.findById(id).map(existingFeedbackQuestion -> {
            existingFeedbackQuestion.setQuestion(updatedFeedbackQuestion.getQuestion());
            existingFeedbackQuestion.setFeedback(updatedFeedbackQuestion.getFeedback());
            existingFeedbackQuestion.setCreatedBy(updatedFeedbackQuestion.getCreatedBy());
            existingFeedbackQuestion.setFeedbackAnswers(updatedFeedbackQuestion.getFeedbackAnswers());
            return feedbackQuestionRepository.save(existingFeedbackQuestion);
        }).orElseThrow(() -> new RuntimeException("FeedbackQuestion not found with id: " + id));
    }

    // Delete a FeedbackQuestion by ID
    public void deleteFeedbackQuestion(Long id) {
        feedbackQuestionRepository.deleteById(id);
    }
}
