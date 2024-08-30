package com.emo.matrix.lms.dto;

import java.sql.Timestamp;
import java.util.Set;

public class AdminDTO {

    private Long id;
    private String name;
    private String email; // Optional
    private String phoneNumber;
    private boolean superAdmin;
    private Set<String> teachers; // List of teacher IDs associated with this admin
    private Set<String> students; // List of student IDs associated with this admin
    private Set<String> courses; // List of course IDs associated with this admin
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

    // Default Constructor
    public AdminDTO() {}

    // Parameterized Constructor
    public AdminDTO(Long id, String name, String email, String phoneNumber, boolean superAdmin, 
                    Set<String> teachers, Set<String> students, Set<String> courses, 
                    String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.superAdmin = superAdmin;
        this.teachers = teachers;
        this.students = students;
        this.courses = courses;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public Set<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<String> teachers) {
        this.teachers = teachers;
    }

    public Set<String> getStudents() {
        return students;
    }

    public void setStudents(Set<String> students) {
        this.students = students;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
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
