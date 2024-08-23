package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "feedback_answer")
public class FeedbackAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "feedback_question_id")
    private FeedbackQuestion feedbackQuestion; // The question this answer belongs to

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // The student who answered the question

    private String answerText; // The actual answer text

    private int rating; // Rating given by the student (optional, based on your system's needs)

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // The Admin who created this answer

    private LocalDateTime createdAt; // Timestamp when the answer was created

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // The Admin who last updated this answer

    private LocalDateTime updatedAt; // Timestamp when the answer was last updated

    // Constructors
    public FeedbackAnswer() {
    }

    public FeedbackAnswer(Long id, FeedbackQuestion feedbackQuestion, Student student, String answerText, int rating, Admin createdBy, LocalDateTime createdAt, Admin updatedBy, LocalDateTime updatedAt) {
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

    public FeedbackQuestion getFeedbackQuestion() {
        return feedbackQuestion;
    }

    public void setFeedbackQuestion(FeedbackQuestion feedbackQuestion) {
        this.feedbackQuestion = feedbackQuestion;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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

    public Admin getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Admin updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
