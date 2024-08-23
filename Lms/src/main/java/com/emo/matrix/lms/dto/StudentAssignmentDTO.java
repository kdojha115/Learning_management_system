package com.emo.matrix.lms.dto;

import java.sql.Timestamp;

public class StudentAssignmentDTO {

    private Long studentId;
    private Long assignmentId;
    private String fileSubmission; // Path or URL to the file submitted by the student
    private boolean isSubmitted; // Indicates if the assignment has been submitted
    private Timestamp submissionDate;
    private boolean graded; // Indicates if the assignment has been graded
    private double grade; // The grade assigned to the student for the assignment
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

    // Default constructor
    public StudentAssignmentDTO() {
    }

    // Constructor with fields
    public StudentAssignmentDTO(Long studentId, Long assignmentId, String fileSubmission, boolean isSubmitted,
                                Timestamp submissionDate, boolean graded, double grade, String createdBy,
                                Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
        this.fileSubmission = fileSubmission;
        this.isSubmitted = isSubmitted;
        this.submissionDate = submissionDate;
        this.graded = graded;
        this.grade = grade;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getFileSubmission() {
        return fileSubmission;
    }

    public void setFileSubmission(String fileSubmission) {
        this.fileSubmission = fileSubmission;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    public Timestamp getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Timestamp submissionDate) {
        this.submissionDate = submissionDate;
    }

    public boolean isGraded() {
        return graded;
    }

    public void setGraded(boolean graded) {
        this.graded = graded;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
