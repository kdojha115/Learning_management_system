package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "certificate")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student; // The student who received the certificate

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // The course for which the certificate is issued

    private LocalDateTime issueDate; // Date when the certificate was issued

    private String fileUrl; // URL to the certificate file

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin who created this certificate

    private LocalDateTime createdAt; // Timestamp when created

    // Getters and Setters

    // Constructor with fields
    public Certificate(Long id, Student student, Course course, LocalDateTime issueDate, String fileUrl, Admin createdBy, LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.issueDate = issueDate;
        this.fileUrl = fileUrl;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
    }

    // Default Constructor
    public Certificate() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
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
}
