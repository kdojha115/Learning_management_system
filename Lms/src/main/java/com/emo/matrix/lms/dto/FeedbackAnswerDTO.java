package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class FeedbackAnswerDTO {

    private Long id;
    private String feedbackQuestion; // ID of the FeedbackQuestion
    private String student; // ID of the Student who answered the question
    private String answerText; // The actual answer text
    private int rating; // Rating given by the student
    private String createdBy; // ID of the Admin who created this answer
    private LocalDateTime createdAt; // Timestamp when the answer was created
    private String updatedBy; // ID of the Admin who last updated this answer
    private LocalDateTime updatedAt; // Timestamp when the answer was last updated

    // Default constructor
    public FeedbackAnswerDTO() {
    }

    // Constructor with fields
    public FeedbackAnswerDTO(Long id, String feedbackQuestion, String student, String answerText, int rating,
                             String createdBy, LocalDateTime createdAt, String updatedBy, LocalDateTime updatedAt) {
        this.id = id;
        this.feedbackQuestion = feedbackQuestion;
        this.student = student;
        this.answerText = answerText;
        this.rating = rating;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackQuestion() {
        return feedbackQuestion;
    }

    public void setFeedbackQuestion(String feedbackQuestion) {
        this.feedbackQuestion = feedbackQuestion;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
