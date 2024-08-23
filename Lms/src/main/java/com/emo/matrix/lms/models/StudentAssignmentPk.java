package com.emo.matrix.lms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentAssignmentPk implements Serializable {
	
	
	@Column(name = "assignment_id")
    private Long assignmentId;

    @Column(name = "student_id")
    private Long studentId;

    public StudentAssignmentPk() {}

    public StudentAssignmentPk(Long studentId, Long assignmentId) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentAssignmentPk that = (StudentAssignmentPk) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(assignmentId, that.assignmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, assignmentId);
    }
}
