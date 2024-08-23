package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class QuizDTO {

    private Long id;
    private String title;
    private String description;
    private String teacher; // Reference to the teacher (as a String)
    private String course; // Reference to the course (as a String)
    private Set<String> questions; // References to questions (as Strings)
    private Set<String> quizMarks; // References to quiz marks (as Strings)
    private String createdBy; // Reference to the Admin or Teacher who created this Quiz (as a String)
    private String updatedBy; // Reference to the Admin or Teacher who last updated this Quiz (as a String)
    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    // Default Constructor
    public QuizDTO() {
    }

    // Constructor with fields
    public QuizDTO(Long id, String title, String description, String teacher, String course, Set<String> questions,
                   Set<String> quizMarks, String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacher = teacher;
        this.course = course;
        this.questions = questions;
        this.quizMarks = quizMarks;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Set<String> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<String> questions) {
        this.questions = questions;
    }

    public Set<String> getQuizMarks() {
        return quizMarks;
    }

    public void setQuizMarks(Set<String> quizMarks) {
        this.quizMarks = quizMarks;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
