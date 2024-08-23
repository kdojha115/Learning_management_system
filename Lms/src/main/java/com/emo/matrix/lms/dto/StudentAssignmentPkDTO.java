package com.emo.matrix.lms.dto;

public class StudentAssignmentPkDTO {

    private Long studentId;
    private Long assignmentId;

    // Default constructor
    public StudentAssignmentPkDTO() {
    }

    // Constructor with fields
    public StudentAssignmentPkDTO(Long studentId, Long assignmentId) {
        this.studentId = studentId;
        this.assignmentId = assignmentId;
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

    @Override
    public String toString() {
        return "StudentAssignmentPkDTO{" +
                "studentId=" + studentId +
                ", assignmentId=" + assignmentId +
                '}';
    }
}
