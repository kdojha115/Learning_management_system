package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class QuizMarkDTO {

    private Long id;
    private Double mark; // The mark obtained in the quiz
    private String quiz; // ID of the quiz that was attempted
    private String student; // ID of the student who took the quiz
    private String createdBy; // ID of the Admin or Teacher who created this QuizMark record
    private String updatedBy; // ID of the Admin or Teacher who last updated this QuizMark record
    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    // Default constructor
    public QuizMarkDTO() {
    }

    // Constructor with fields
    public QuizMarkDTO(Long id, Double mark, String quiz, String student, String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.mark = mark;
        this.quiz = quiz;
        this.student = student;
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

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
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
