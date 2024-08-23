package com.emo.matrix.lms.dto;

public class StudentAssignmentIdDTO {

    private Long studentId;
    private Long assignmentId;

    // Default constructor
    public StudentAssignmentIdDTO() {
    }

    // Constructor with fields
    public StudentAssignmentIdDTO(Long studentId, Long assignmentId) {
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
}
