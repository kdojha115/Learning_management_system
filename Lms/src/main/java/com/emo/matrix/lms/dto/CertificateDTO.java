package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class CertificateDTO {

    private Long id;
    private String student; // ID of the student who received the certificate
    private String course;  // ID of the course for which the certificate is issued
    private LocalDateTime issueDate; // Date when the certificate was issued
    private String fileUrl; // URL to the certificate file
    private String createdBy; // ID of the Admin who created this certificate
    private LocalDateTime createdAt; // Timestamp when created

    // Default Constructor
    public CertificateDTO() {
    }

    // Constructor with fields
    public CertificateDTO(Long id, String student, String course, LocalDateTime issueDate, String fileUrl, String createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.issueDate = issueDate;
        this.fileUrl = fileUrl;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
}
