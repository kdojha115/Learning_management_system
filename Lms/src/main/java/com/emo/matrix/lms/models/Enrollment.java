package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student; // The student who is enrolled in the course

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // The course that the student is enrolled in

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin or Teacher who created this enrollment record

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // Admin or Teacher who last updated this enrollment record

    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    private boolean isActive; // Indicates whether the enrollment is active

    // Getters and Setters

    // Constructor with fields
    public Enrollment(Long id, Student student, Course course, Admin createdBy, Admin updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    // Default Constructor
    public Enrollment() {
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

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public Admin getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Admin updatedBy) {
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
