package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class FeedbackDTO {

    private Long id;
    private String course; // Reference to the course (as a String)
    private String teacher; // Reference to the teacher (as a String)
    private String student; // Reference to the student (as a String)
    private String createdBy; // Reference to the Admin who created this feedback (as a String)
    private LocalDateTime createdAt; // Timestamp when the feedback was created
    private Set<String> feedbackQuestions; // Mapping to FeedbackQuestion references as Strings
    private int rating; // Rating given by the student

    // Default Constructor
    public FeedbackDTO() {
    }

    // Constructor with fields
    public FeedbackDTO(Long id, String course, String teacher, String student, String createdBy, LocalDateTime createdAt, Set<String> feedbackQuestions, int rating) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.student = student;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.feedbackQuestions = feedbackQuestions;
        this.rating = rating;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
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

    public Set<String> getFeedbackQuestions() {
        return feedbackQuestions;
    }

    public void setFeedbackQuestions(Set<String> feedbackQuestions) {
        this.feedbackQuestions = feedbackQuestions;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
