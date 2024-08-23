package com.emo.matrix.lms.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentAssignmentId implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "assignment_id")
    private Long assignmentId;

    // Getters, setters, equals, and hashCode
}
