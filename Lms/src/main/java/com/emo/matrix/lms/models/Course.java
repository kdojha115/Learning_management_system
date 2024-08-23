package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = true)
    private Teacher teacher; // Optional if the course is posted by an independent teacher

    @Column(nullable = false)
    private boolean isPrivate; // If true, only students under the admin of the teacher can access; otherwise, it's public

    @Column(nullable = false)
    private boolean isPaid; // If true, the course requires payment; otherwise, it's free

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin; // If the course is managed by an admin

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department; // Associated department

    @OneToMany(mappedBy = "course")
    private Set<Vidstep> vidsteps;

    @OneToMany(mappedBy = "course")
    private Set<Assignment> assignments;

    @OneToMany(mappedBy = "course")
    private Set<Quiz> quizzes;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;
    
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    
//	@Column(name = "video_files")
//    private String videoFiles; // This could be a URL or a path to video files related to the course

    @Lob
    @Column(name = "video_files", columnDefinition = "BLOB",nullable = true)
    private byte[] videoFiles;

    
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
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
    
    
    

    // Constructor using field
    public Course(Long id, String title, String description, Teacher teacher, boolean isPrivate, boolean isPaid,
    		Admin admin, Department department, Set<Vidstep> vidsteps, Set<Assignment> assignments, Set<Quiz> quizzes,
    		Set<Enrollment> enrollments, Set<Student> students, byte[] videoFiles, String createdBy, Timestamp createdAt,
    		String updatedBy, Timestamp updatedAt) {
    	super();
    	this.id = id;
    	this.title = title;
    	this.description = description;
    	this.teacher = teacher;
    	this.isPrivate = isPrivate;
    	this.isPaid = isPaid;
    	this.admin = admin;
    	this.department = department;
    	this.vidsteps = vidsteps;
    	this.assignments = assignments;
    	this.quizzes = quizzes;
    	this.enrollments = enrollments;
    	this.students = students;
    	this.videoFiles = videoFiles;
    	this.createdBy = createdBy;
    	this.createdAt = createdAt;
    	this.updatedBy = updatedBy;
    	this.updatedAt = updatedAt;
    }

    
    

    // Getters and Setters
    
    
    

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setVideoFiles(byte[] videoFiles) {
		this.videoFiles = videoFiles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
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

	public Set<Vidstep> getVidsteps() {
		return vidsteps;
	}

	public void setVidsteps(Set<Vidstep> vidsteps) {
		this.vidsteps = vidsteps;
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

	public Set<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(Set<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

//	public String getVideoFiles() {
//		return videoFiles;
//	}
//
//	public void setVideoFiles(String videoFiles) {
//		this.videoFiles = videoFiles;
//	}

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
