package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class EnrollmentDTO {

    private Long id;
    private String student; // Reference to the student (as a String)
    private String course; // Reference to the course (as a String)
    private String createdBy; // Reference to the Admin or Teacher who created this enrollment record (as a String)
    private String updatedBy; // Reference to the Admin or Teacher who last updated this enrollment record (as a String)
    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated
    private boolean isActive; // Indicates whether the enrollment is active

    // Default Constructor
    public EnrollmentDTO() {
    }

    // Constructor with fields
    public EnrollmentDTO(Long id, String student, String course, String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
