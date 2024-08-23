package com.emo.matrix.lms.dto;


import java.sql.Timestamp;
import java.util.Set;

public class AssignmentDTO {

    private Long id;
    private String title;
    private String description;
    private Timestamp dueDate;
    private String fileUpload;
    private boolean isGraded;
    private double grade;
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;

    // Teacher details
    private String teacherName;

    // Course details
    private String courseName;

    // Student assignments (for tracking submissions)
    private Set<StudentAssignmentDTO> studentAssignments;

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

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set<StudentAssignmentDTO> getStudentAssignments() {
		return studentAssignments;
	}

	public void setStudentAssignments(Set<StudentAssignmentDTO> studentAssignments) {
		this.studentAssignments = studentAssignments;
	}

	public AssignmentDTO(Long id, String title, String description, Timestamp dueDate, String fileUpload,
			boolean isGraded, double grade, String createdBy, Timestamp createdAt, String updatedBy,
			Timestamp updatedAt, String teacherName, String courseName, Set<StudentAssignmentDTO> studentAssignments) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.fileUpload = fileUpload;
		this.isGraded = isGraded;
		this.grade = grade;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.teacherName = teacherName;
		this.courseName = courseName;
		this.studentAssignments = studentAssignments;
	}

	@Override
	public String toString() {
		return "AssignmentDTO [id=" + id + ", title=" + title + ", description=" + description + ", dueDate=" + dueDate
				+ ", fileUpload=" + fileUpload + ", isGraded=" + isGraded + ", grade=" + grade + ", createdBy="
				+ createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt
				+ ", teacherName=" + teacherName + ", courseName=" + courseName + ", studentAssignments="
				+ studentAssignments + "]";
	}
    
	public AssignmentDTO() {
		
	}
    

}
