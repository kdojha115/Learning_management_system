package com.emo.matrix.lms.dto;

import java.sql.Timestamp;
import java.util.Set;

public class StudentDTO {

	private Long id;
	private String name;
	private String phoneNumber;
	private String email;
	private boolean isIndependent;
	private String admin; // Reference to the related admin
	private String department; // Reference to the department
	private Set<String> enrollments; // List of enrollments
	private Set<String> answeredQuestions; // List of answered questions
	private Set<String> certificates; // List of certificates earned
	private Set<String> courses; // Courses the student is enrolled in
	private String createdBy;
	private Timestamp createdAt;
	private String updatedBy;
	private Timestamp updatedAt;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isIndependent() {
		return isIndependent;
	}

	public void setIndependent(boolean isIndependent) {
		this.isIndependent = isIndependent;
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

	public void setDepartment(String department) {
		this.department = department;
	}

	public Set<String> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<String> enrollments) {
		this.enrollments = enrollments;
	}

	public Set<String> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(Set<String> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public Set<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<String> certificates) {
		this.certificates = certificates;
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

	public StudentDTO(Long id, String name, String phoneNumber, String email, boolean isIndependent, String admin,
			String department, Set<String> enrollments, Set<String> answeredQuestions, Set<String> certificates,
			Set<String> courses, String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isIndependent = isIndependent;
		this.admin = admin;
		this.department = department;
		this.enrollments = enrollments;
		this.answeredQuestions = answeredQuestions;
		this.certificates = certificates;
		this.courses = courses;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", isIndependent=" + isIndependent + ", admin=" + admin + ", department=" + department
				+ ", enrollments=" + enrollments + ", answeredQuestions=" + answeredQuestions + ", certificates="
				+ certificates + ", courses=" + courses + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + "]";
	}

	public StudentDTO() {

	}
	// Getters and Setters

}
