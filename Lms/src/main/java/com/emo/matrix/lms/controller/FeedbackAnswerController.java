package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.FeedbackAnswer;
import com.emo.matrix.lms.service.FeedbackAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback-answers")
public class FeedbackAnswerController {

    @Autowired
    private FeedbackAnswerService feedbackAnswerService;

    // Create a new FeedbackAnswer
    @PostMapping("/")
    public ResponseEntity<FeedbackAnswer> createFeedbackAnswer(@RequestBody FeedbackAnswer feedbackAnswer) {
        FeedbackAnswer createdFeedbackAnswer = feedbackAnswerService.createFeedbackAnswer(feedbackAnswer);
        return ResponseEntity.ok(createdFeedbackAnswer);
    }

    // Get all FeedbackAnswers
    @GetMapping("/")
    public ResponseEntity<List<FeedbackAnswer>> getAllFeedbackAnswers() {
        List<FeedbackAnswer> feedbackAnswers = feedbackAnswerService.getAllFeedbackAnswers();
        return ResponseEntity.ok(feedbackAnswers);
    }

    // Get FeedbackAnswer by ID
    @GetMapping("/{id}")
    public ResponseEntity<FeedbackAnswer> getFeedbackAnswerById(@PathVariable Long id) {
        Optional<FeedbackAnswer> feedbackAnswer = feedbackAnswerService.getFeedbackAnswerById(id);
        return feedbackAnswer.map(ResponseEntity::ok)
                             .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get FeedbackAnswers by FeedbackQuestion ID
    @GetMapping("/feedback-question/{feedbackQuestionId}")
    public ResponseEntity<List<FeedbackAnswer>> getFeedbackAnswersByFeedbackQuestionId(@PathVariable Long feedbackQuestionId) {
        List<FeedbackAnswer> feedbackAnswers = feedbackAnswerService.getFeedbackAnswersByFeedbackQuestionId(feedbackQuestionId);
        return ResponseEntity.ok(feedbackAnswers);
    }

    // Update an existing FeedbackAnswer
    @PutMapping("/{id}")
    public ResponseEntity<FeedbackAnswer> updateFeedbackAnswer(@PathVariable Long id, @RequestBody FeedbackAnswer updatedFeedbackAnswer) {
        try {
            FeedbackAnswer feedbackAnswer = feedbackAnswerService.updateFeedbackAnswer(id, updatedFeedbackAnswer);
            return ResponseEntity.ok(feedbackAnswer);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a FeedbackAnswer by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedbackAnswer(@PathVariable Long id) {
        feedbackAnswerService.deleteFeedbackAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
