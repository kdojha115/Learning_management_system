package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "assignment")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    
    private Timestamp dueDate;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "assignment")
    private Set<StudentAssignment> studentAssignments;

    @Column(name = "file_upload")
    private String fileUpload; // Path or URL to the file uploaded by the teacher or admin

    @Column(nullable = false)
    private boolean isGraded; // Indicates if the assignment has been graded

    @Column(nullable = true)
    private double grade; // The grade assigned to the assignment, if applicable

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
        return course.getCreatedBy();
    }

    
    // Constructor using field
    
	
	public Assignment(Long id, String title, String description, Timestamp dueDate, Teacher teacher, Course course,
			Set<StudentAssignment> studentAssignments, String fileUpload, boolean isGraded, double grade,
			String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.teacher = teacher;
		this.course = course;
		this.studentAssignments = studentAssignments;
		this.fileUpload = fileUpload;
		this.isGraded = isGraded;
		this.grade = grade;
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
	
	public Timestamp getDueDate() {
		return dueDate;
	}

	public void setDueDate(Timestamp dueDate) {
		this.dueDate = dueDate;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<StudentAssignment> getStudentAssignments() {
		return studentAssignments;
	}

	public void setStudentAssignments(Set<StudentAssignment> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public String getFileUpload() {
		return fileUpload;
	}

	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
	}

	public boolean isGraded() {
		return isGraded;
	}

	public void setGraded(boolean isGraded) {
		this.isGraded = isGraded;
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
