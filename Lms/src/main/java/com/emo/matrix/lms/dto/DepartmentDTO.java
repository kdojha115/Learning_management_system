package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class DepartmentDTO {

    private Long id;
    private String name;
    private String createdBy; // Reference to the Admin who created this Department (as a String)
    private String updatedBy; // Reference to the Admin who last updated this Department (as a String)
    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated
    private Set<String> students; // Set of student IDs or names (as Strings)
    private Set<String> teachers; // Set of teacher IDs or names (as Strings)
    private Set<String> courses; // Set of course IDs or names (as Strings)

    // Default Constructor
    public DepartmentDTO() {
    }

    // Constructor with all fields
    public DepartmentDTO(Long id, String name, String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, Set<String> students, Set<String> teachers, Set<String> courses) {
        this.id = id;
        this.name = name;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.students = students;
        this.teachers = teachers;
        this.courses = courses;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<String> getStudents() {
        return students;
    }

    public void setStudents(Set<String> students) {
        this.students = students;
    }

    public Set<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<String> teachers) {
        this.teachers = teachers;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }
}
