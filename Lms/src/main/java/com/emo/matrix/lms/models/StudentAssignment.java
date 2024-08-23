package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "student_assignment")
public class StudentAssignment {

	@EmbeddedId
    private StudentAssignmentPk id;  

	@ManyToOne
    @JoinColumn(name = "assignment_id", insertable = false, updatable = false)
    private Assignment assignment;  

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;
    
//    @Id
//    @Column(name = "student_id")
//    private Long studentId;
//
//    @Id
//    @Column(name = "assignment_id")
//    private Long assignmentId;

    @Column(name = "file_submission")
    private String fileSubmission; // Path or URL to the file submitted by the student

    @Column(nullable = false)
    private boolean isSubmitted; // Indicates if the assignment has been submitted

    @Column(name = "submission_date")
    private Timestamp submissionDate;

    @Column(name = "isGraded")
    private boolean graded; // Indicates if the assignment has been graded

    @Column(name = "grade")
    private double grade; // The grade assigned to the student for the assignment
    
    

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = true)
    private String updatedBy;

    @Column(nullable = true)
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        if (createdAt == null) createdAt = new Timestamp(System.currentTimeMillis());
        if (createdBy == null) createdBy = getCurrentUserId();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
        updatedBy = getCurrentUserId();
    }

    private String getCurrentUserId() {
        // This method should return the ID or name of the currently authenticated user
        return student.getName();
    }
    
    
    // Constructor using field
    


    public StudentAssignment(StudentAssignmentPk id, Assignment assignment, Student student, String fileSubmission,
			boolean isSubmitted, Timestamp submissionDate, boolean graded, double grade, String createdBy,
			Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
		super();
		this.id = id;
		this.assignment = assignment;
		this.student = student;
		this.fileSubmission = fileSubmission;
		this.isSubmitted = isSubmitted;
		this.submissionDate = submissionDate;
		this.graded = graded;
		this.grade = grade;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	// Getters and Setters
	
	
    

	public StudentAssignment(Long studentId, Long assignmentId) {
		// TODO Auto-generated constructor stub
	}

	public StudentAssignment() {
		// TODO Auto-generated constructor stub
	}

	public String getFileSubmission() {
		return fileSubmission;
	}

	public StudentAssignmentPk getId() {
		return id;
	}

	public void setId(StudentAssignmentPk id) {
		this.id = id;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setFileSubmission(String fileSubmission) {
		this.fileSubmission = fileSubmission;
	}

	public boolean isSubmitted() {
		return isSubmitted;
	}

	public void setSubmitted(boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	public Timestamp getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Timestamp submissionDate) {
		this.submissionDate = submissionDate;
	}

	public boolean isGraded() {
		return graded;
	}

	public void setGraded(boolean graded) {
		this.graded = graded;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
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
