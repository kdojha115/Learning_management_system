package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "teacher")
public class Teacher {
	
	public Teacher() {
		
	}

    @Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isIndependent=" + isIndependent + ", admin=" + admin + ", department="
				+ department + ", courses=" + courses + ", assignments=" + assignments + ", quizzes=" + quizzes
				+ ", feedbacks=" + feedbacks + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", updatedBy="
				+ updatedBy + ", updatedAt=" + updatedAt + ", isApproved=" + isApproved + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true,nullable = true)
    private String email;  // Optional

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isIndependent = true; // Indicates if the teacher operates independently

    @ManyToOne
    @JoinColumn(name = "admin_id",nullable = true)
    private Admin admin;
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "admin_roles",
//        joinColumns = @JoinColumn(name = "admin_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();

    
    @ManyToOne
    @JoinColumn(name = "department_id", nullable = true)
    private Department department;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;
    
    @OneToMany(mappedBy = "teacher")
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "teacher")
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "teacher")
    private Set<Feedback> feedbacks;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = true)
    private String updatedBy;

    @Column(nullable = true)
    private Timestamp updatedAt;
    
    @Column(nullable = false)
    private boolean isApproved = false;

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
        return this.getName();
    }
    
    
    
    
    // Constructor using field

	

    public Teacher(Long id, String name, String email, String phoneNumber, String password, boolean isIndependent,
			Admin admin, Department department, Set<Course> courses, Set<Assignment> assignments,
			Set<Quiz> quizzes, Set<Feedback> feedbacks, String createdBy, Timestamp createdAt, String updatedBy,
			Timestamp updatedAt, boolean isApproved) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isIndependent = isIndependent;
		this.admin = admin;
//		this.roles = roles;
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

	
	// Getters and Setters
	
	

	
	public Long getId() {
		return id;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(Set<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Set<Quiz> getQuizzes() {
		return quizzes;
	}

	public void setQuizzes(Set<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public boolean isApproved() {
		return isApproved;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIndependent() {
		return isIndependent;
	}

	public void setIndependent(boolean isIndependent) {
		this.isIndependent = isIndependent;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
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

	public void setApproved(boolean b) {
		// TODO Auto-generated method stub
		this.isApproved = b;
		
	}
	
}
