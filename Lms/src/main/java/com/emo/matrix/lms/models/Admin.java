package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "admin")
public class Admin {
	
	

    @Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isSuperAdmin=" + isSuperAdmin + ", teachers=" + teachers + ", students="
				+ students + ", courses=" + courses + ", createdBy=" + createdBy + ", createdAt=" + createdAt
				+ ", updatedBy=" + updatedBy + ", updatedAt=" + updatedAt + "]";
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

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isSuperAdmin = false;

    @OneToMany(mappedBy = "admin")
    private Set<Teacher> teachers;

    @OneToMany(mappedBy = "admin")
    private Set<Student> students;
    
    
    @OneToMany(mappedBy = "admin")
    private Set<Course> courses;
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "admin_roles",
//        joinColumns = @JoinColumn(name = "admin_id"),
//        inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles = new HashSet<>();


    

	@Column(nullable = true)
    private String createdBy;

    @Column(nullable = true)
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
        return this.getName();
    }
    
    public Admin() {
    	
    }
    
    // Constructor using field

    public Admin(Long id, String name, String email, String phoneNumber, String password, boolean isSuperAdmin,
			Set<Teacher> teachers, Set<Student> students, Set<Course> courses, String createdBy,
			Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.isSuperAdmin = isSuperAdmin;
		this.teachers = teachers;
		this.students = students;
		this.courses = courses;
//		this.roles = roles;
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

	public boolean isSuperAdmin() {
		return isSuperAdmin;
	}

	public void setSuperAdmin(boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

}
