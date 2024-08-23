package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class FeedbackQuestionDTO {

    private Long id; // ID of the feedback question
    private String question; // The feedback question text
    private String feedback; // The associated feedback
    private String createdBy; // The Admin who created this question
    private LocalDateTime createdAt; // Timestamp when the question was created
    private Set<FeedbackAnswerDTO> feedbackAnswers; // Set of FeedbackAnswerDTOs

    // Default constructor
    public FeedbackQuestionDTO() {
    }

    // Constructor with fields
    public FeedbackQuestionDTO(Long id, String question, String feedback, String createdBy, LocalDateTime createdAt, Set<FeedbackAnswerDTO> feedbackAnswers) {
        this.id = id;
        this.question = question;
        this.feedback = feedback;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.feedbackAnswers = feedbackAnswers;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<FeedbackAnswerDTO> getFeedbackAnswers() {
        return feedbackAnswers;
    }

    public void setFeedbackAnswers(Set<FeedbackAnswerDTO> feedbackAnswers) {
        this.feedbackAnswers = feedbackAnswers;
    }
}
