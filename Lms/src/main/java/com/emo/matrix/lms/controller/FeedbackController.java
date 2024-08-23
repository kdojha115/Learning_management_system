package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Feedback;
import com.emo.matrix.lms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Create a new Feedback
    @PostMapping("/")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.ok(createdFeedback);
    }

    // Get all Feedbacks
    @GetMapping("/")
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    // Get Feedback by ID
    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.getFeedbackById(id);
        return feedback.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Feedbacks by Course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByCourseId(@PathVariable Long courseId) {
        List<Feedback> feedbacks = feedbackService.getFeedbacksByCourseId(courseId);
        return ResponseEntity.ok(feedbacks);
    }

    // Get Feedbacks by Teacher ID
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByTeacherId(@PathVariable Long teacherId) {
        List<Feedback> feedbacks = feedbackService.getFeedbacksByTeacherId(teacherId);
        return ResponseEntity.ok(feedbacks);
    }

    // Get Feedbacks by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Feedback>> getFeedbacksByStudentId(@PathVariable Long studentId) {
        List<Feedback> feedbacks = feedbackService.getFeedbacksByStudentId(studentId);
        return ResponseEntity.ok(feedbacks);
    }

    // Update an existing Feedback
    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        try {
            Feedback feedback = feedbackService.updateFeedback(id, updatedFeedback);
            return ResponseEntity.ok(feedback);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Feedback by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
