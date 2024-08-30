package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student {
	
	public Student() {
		
	}

    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + ", isIndependent=" + isIndependent + ", admin=" + admin + ", department="
				+ department + ", enrollments=" + enrollments + ", answeredQuestions=" + answeredQuestions
				+ ", certificates=" + certificates + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + ", courses=" + courses + "]";
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(unique = true,nullable = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private boolean isIndependent = true;  // Indicates if the student signed up independently

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = true)  // This line is added to fix the issue
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

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;

    @OneToMany(mappedBy = "student")
    private Set<AnsweredQuestion> answeredQuestions;

    @OneToMany(mappedBy = "student")
    private Set<Certificate> certificates;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Timestamp createdAt;

    @Column(nullable = true)
    private String updatedBy;

    @Column(nullable = true)
    private Timestamp updatedAt;
    
    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;

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
        return this.getName();
    }
    
    
 // Constructor using field

	
	

	public Student(Long id, String name, String phoneNumber, String email, String password, boolean isIndependent,
			Admin admin, Department department, Set<Enrollment> enrollments,
			Set<AnsweredQuestion> answeredQuestions, Set<Certificate> certificates, String createdBy,
			Timestamp createdAt, String updatedBy, Timestamp updatedAt, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.isIndependent = isIndependent;
		this.admin = admin;
//		this.roles = roles;
		this.department = department;
		this.enrollments = enrollments;
		this.answeredQuestions = answeredQuestions;
		this.certificates = certificates;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
		this.courses = courses;
	}

	// Getters and Setters
	
	
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getIndependent() {
		return isIndependent;
	}

	public void setIsIndependent(boolean isIndependent) {
		this.isIndependent = isIndependent;
	}

    public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Set<AnsweredQuestion> getAnsweredQuestions() {
		return answeredQuestions;
	}

	public void setAnsweredQuestions(Set<AnsweredQuestion> answeredQuestions) {
		this.answeredQuestions = answeredQuestions;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
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

	public Object getIsIndependent() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
