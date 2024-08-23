package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.FeedbackAnswer;
import com.emo.matrix.lms.repository.FeedbackAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackAnswerService {

    @Autowired
    private FeedbackAnswerRepository feedbackAnswerRepository;

    // Create a new FeedbackAnswer
    public FeedbackAnswer createFeedbackAnswer(FeedbackAnswer feedbackAnswer) {
        feedbackAnswer.setCreatedAt(LocalDateTime.now());
        return feedbackAnswerRepository.save(feedbackAnswer);
    }

    // Get all FeedbackAnswers
    public List<FeedbackAnswer> getAllFeedbackAnswers() {
        return feedbackAnswerRepository.findAll();
    }

    // Get FeedbackAnswer by ID
    public Optional<FeedbackAnswer> getFeedbackAnswerById(Long id) {
        return feedbackAnswerRepository.findById(id);
    }

    // Get FeedbackAnswers by FeedbackQuestion ID
    public List<FeedbackAnswer> getFeedbackAnswersByFeedbackQuestionId(Long feedbackQuestionId) {
        return feedbackAnswerRepository.findByFeedbackQuestionId(feedbackQuestionId);
    }

    // Update an existing FeedbackAnswer
    public FeedbackAnswer updateFeedbackAnswer(Long id, FeedbackAnswer updatedFeedbackAnswer) {
        return feedbackAnswerRepository.findById(id).map(existingFeedbackAnswer -> {
            existingFeedbackAnswer.setAnswerText(updatedFeedbackAnswer.getAnswerText());
            existingFeedbackAnswer.setStudent(updatedFeedbackAnswer.getStudent());
            existingFeedbackAnswer.setRating(updatedFeedbackAnswer.getRating());
            existingFeedbackAnswer.setUpdatedBy(updatedFeedbackAnswer.getUpdatedBy());
            existingFeedbackAnswer.setUpdatedAt(LocalDateTime.now());
            return feedbackAnswerRepository.save(existingFeedbackAnswer);
        }).orElseThrow(() -> new RuntimeException("FeedbackAnswer not found with id: " + id));
    }

    // Delete a FeedbackAnswer by ID
    public void deleteFeedbackAnswer(Long id) {
        feedbackAnswerRepository.deleteById(id);
    }
}
