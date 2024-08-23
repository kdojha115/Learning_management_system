package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.FeedbackQuestion;
import com.emo.matrix.lms.service.FeedbackQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback-questions")
public class FeedbackQuestionController {

    @Autowired
    private FeedbackQuestionService feedbackQuestionService;

    // Create a new FeedbackQuestion
    @PostMapping("/")
    public ResponseEntity<FeedbackQuestion> createFeedbackQuestion(@RequestBody FeedbackQuestion feedbackQuestion) {
        FeedbackQuestion createdFeedbackQuestion = feedbackQuestionService.createFeedbackQuestion(feedbackQuestion);
        return ResponseEntity.ok(createdFeedbackQuestion);
    }

    // Get all FeedbackQuestions
    @GetMapping("/")
    public ResponseEntity<List<FeedbackQuestion>> getAllFeedbackQuestions() {
        List<FeedbackQuestion> feedbackQuestions = feedbackQuestionService.getAllFeedbackQuestions();
        return ResponseEntity.ok(feedbackQuestions);
    }

    // Get FeedbackQuestion by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackQuestion> getFeedbackQuestionById(@PathVariable Long id) {
        Optional<FeedbackQuestion> feedbackQuestion = feedbackQuestionService.getFeedbackQuestionById(id);
        return feedbackQuestion.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get FeedbackQuestions by Feedback ID
    @GetMapping("/feedback/{feedbackId}")
    public ResponseEntity<List<FeedbackQuestion>> getFeedbackQuestionsByFeedbackId(@PathVariable Long feedbackId) {
        List<FeedbackQuestion> feedbackQuestions = feedbackQuestionService.getFeedbackQuestionsByFeedbackId(feedbackId);
        return ResponseEntity.ok(feedbackQuestions);
    }

    // Update an existing FeedbackQuestion
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackQuestion> updateFeedbackQuestion(@PathVariable Long id, @RequestBody FeedbackQuestion updatedFeedbackQuestion) {
        try {
            FeedbackQuestion feedbackQuestion = feedbackQuestionService.updateFeedbackQuestion(id, updatedFeedbackQuestion);
            return ResponseEntity.ok(feedbackQuestion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a FeedbackQuestion by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedbackQuestion(@PathVariable Long id) {
        feedbackQuestionService.deleteFeedbackQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
