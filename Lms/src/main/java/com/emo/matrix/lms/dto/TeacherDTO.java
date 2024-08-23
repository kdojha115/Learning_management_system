package com.emo.matrix.lms.dto;

import java.sql.Timestamp;
import java.util.Set;


public class TeacherDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private boolean isIndependent;
    private String admin;  // Reference to the related admin
	private String department;  // Reference to the department
    private Set<String> courses;  // List of courses managed by the teacher
    private Set<String> assignments;  // List of assignments
    private Set<String> quizzes;  // List of quizzes created by the teacher
    private Set<String> feedbacks;  // Feedbacks given by the teacher
    private String createdBy;
    private Timestamp createdAt;
    private String updatedBy;
    private Timestamp updatedAt;
    private boolean isApproved;
    
    
    public TeacherDTO() {
    	
    }
    
    
	@Override
	public String toString() {
		return "TeacherDTO [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", isIndependent=" + isIndependent + ", admin=" + admin + ", department=" + department + ", courses="
				+ courses + ", assignments=" + assignments + ", quizzes=" + quizzes + ", feedbacks=" + feedbacks
				+ ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy=" + updatedBy + ", updatedAt="
				+ updatedAt + ", isApproved=" + isApproved + "]";
	}
	
	
	public TeacherDTO(Long id, String name, String email, String phoneNumber, boolean isIndependent, String admin,
			String department, Set<String> courses, Set<String> assignments, Set<String> quizzes,
			Set<String> feedbacks, String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt,
			boolean isApproved) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isIndependent = isIndependent;
		this.admin = admin;
		this.department = department;
		this.courses = courses;
		this.assignments = assignments;
		this.quizzes = quizzes;
		this.feedbacks = feedbacks;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.isApproved = isApproved;
	}
	
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
	
	public boolean isIndependent() {
		return isIndependent;
	}
	
	public void setIndependent(boolean isIndependent) {
		this.isIndependent = isIndependent;
	}
    
	public void setAdmin(String admin) {
		this.admin = admin;
	}
    
	public String getAdmin() {
		return admin;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}


	public Set<String> getCourses() {
		return courses;
	}
	public void setCourses(Set<String> courses) {
		this.courses = courses;
	}
	public Set<String> getAssignments() {
		return assignments;
	}
	public void setAssignments(Set<String> assignments) {
		this.assignments = assignments;
	}
	public Set<String> getQuizzes() {
		return quizzes;
	}
	public void setQuizzes(Set<String> quizzes) {
		this.quizzes = quizzes;
	}
	public Set<String> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(Set<String> feedbacks) {
		this.feedbacks = feedbacks;
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
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

    // Getters and Setters
    
}
