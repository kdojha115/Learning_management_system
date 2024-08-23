package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Feedback;
import com.emo.matrix.lms.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Create a new Feedback
    public Feedback createFeedback(Feedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    // Get all Feedbacks
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    // Get Feedback by ID
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    // Get Feedbacks by Course ID
    public List<Feedback> getFeedbacksByCourseId(Long courseId) {
        return feedbackRepository.findByCourseId(courseId);
    }

    // Get Feedbacks by Teacher ID
    public List<Feedback> getFeedbacksByTeacherId(Long teacherId) {
        return feedbackRepository.findByTeacherId(teacherId);
    }

    // Get Feedbacks by Student ID
    public List<Feedback> getFeedbacksByStudentId(Long studentId) {
        return feedbackRepository.findByStudentId(studentId);
    }

    // Update an existing Feedback
    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        return feedbackRepository.findById(id).map(existingFeedback -> {
            existingFeedback.setCourse(updatedFeedback.getCourse());
            existingFeedback.setTeacher(updatedFeedback.getTeacher());
            existingFeedback.setStudent(updatedFeedback.getStudent());
            existingFeedback.setRating(updatedFeedback.getRating());
            existingFeedback.setFeedbackQuestions(updatedFeedback.getFeedbackQuestions());
            return feedbackRepository.save(existingFeedback);
        }).orElseThrow(() -> new RuntimeException("Feedback not found with id: " + id));
    }

    // Delete a Feedback by ID
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
