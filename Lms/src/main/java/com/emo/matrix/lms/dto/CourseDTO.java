package com.emo.matrix.lms.dto;

import java.sql.Timestamp;
import java.util.Set;

public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String teacher; // ID of the teacher (if applicable)
    private boolean isPrivate; // If true, only students under the admin of the teacher can access
    private boolean isPaid; // If true, the course requires payment
    private String admin; // ID of the admin (if applicable)
    private String department; // ID of the associated department
    private Set<String> vidsteps; // IDs of associated Vidsteps
    private Set<String> assignments; // IDs of associated Assignments
    private Set<String> quizs; // IDs of associated Quizzes
    private Set<Long> enrollments; // IDs of associated Enrollments
    private Set<String> students; // IDs of associated Students
    private byte[] videoFiles; // Byte array for video files
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

    // Default Constructor
    public CourseDTO() {
    }

    // Constructor with fields
    public CourseDTO(Long id, String title, String description, String teacher, boolean isPrivate, boolean isPaid,
    		String admin, String department, Set<String> vidsteps, Set<String> assignments,
                     Set<String> quizs, Set<Long> enrollments, Set<String> students, byte[] videoFiles,
                     String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teacher = teacher;
        this.isPrivate = isPrivate;
        this.isPaid = isPaid;
        this.admin = admin;
        this.department = department;
        this.vidsteps = vidsteps;
        this.assignments = assignments;
        this.quizs = quizs;
        this.enrollments = enrollments;
        this.students = students;
        this.videoFiles = videoFiles;
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

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartmentId(String department) {
        this.department = department;
    }

    public Set<String> getVidsteps() {
        return vidsteps;
    }

    public void setVidsteps(Set<String> vidsteps) {
        this.vidsteps = vidsteps;
    }

    public Set<String> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<String> assignments) {
        this.assignments = assignments;
    }

    public Set<String> getQuizs() {
        return quizs;
    }

    public void setQuizs(Set<String> quizs) {
        this.quizs = quizs;
    }

    public Set<Long> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Long> enrollments) {
        this.enrollments = enrollments;
    }

    public Set<String> getStudents() {
        return students;
    }

    public void setStudents(Set<String> students) {
        this.students = students;
    }

    public byte[] getVideoFiles() {
        return videoFiles;
    }

    public void setVideoFiles(byte[] videoFiles) {
        this.videoFiles = videoFiles;
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
