package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "feedback_question")
public class FeedbackQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question; // The feedback question text

    @ManyToOne
    @JoinColumn(name = "feedback_id")
    private Feedback feedback; // The feedback this question belongs to

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin who created this question

    private LocalDateTime createdAt; // Timestamp when the question was created

    @OneToMany(mappedBy = "feedbackQuestion")
    private Set<FeedbackAnswer> feedbackAnswers; // Mapping to FeedbackAnswer table

    // Constructor with fields
    public FeedbackQuestion(Long id, String question, Feedback feedback, Admin createdBy, LocalDateTime createdAt, Set<FeedbackAnswer> feedbackAnswers) {
        this.id = id;
        this.question = question;
        this.feedback = feedback;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.feedbackAnswers = feedbackAnswers;
    }

    // Default Constructor
    public FeedbackQuestion() {
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

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<FeedbackAnswer> getFeedbackAnswers() {
        return feedbackAnswers;
    }

    public void setFeedbackAnswers(Set<FeedbackAnswer> feedbackAnswers) {
        this.feedbackAnswers = feedbackAnswers;
    }
}
