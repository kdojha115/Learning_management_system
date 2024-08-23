package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class AnsweredQuestionDTO {

    private Long id;
    private String answer;
    private Boolean isCorrect;
    private String question;
    private String student;
    private String studentAssignment;
    private String quiz;
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Constructor with fields

    public AnsweredQuestionDTO(Long id, String answer, Boolean isCorrect, String question, String student, String studentAssignment,
    		String quiz, String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.question = question;
        this.student = student;
        this.studentAssignment = studentAssignment;
        this.quiz = quiz;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default Constructor
    public AnsweredQuestionDTO() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStudentAssignment() {
        return studentAssignment;
    }

    public void setStudentAssignment(String studentAssignment) {
        this.studentAssignment = studentAssignment;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
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
