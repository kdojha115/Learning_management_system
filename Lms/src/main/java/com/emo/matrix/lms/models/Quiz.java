package com.emo.matrix.lms.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;
    
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // Course to which this quiz belongs

    @OneToMany(mappedBy = "quiz")
    private Set<Question> questions; // Questions in this quiz

    @OneToMany(mappedBy = "quiz")
    private Set<QuizMark> quizMarks; // Marks awarded for this quiz

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin or Teacher who created this Quiz

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // Admin or Teacher who last updated this Quiz

    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated
	
	public Quiz(Long id, String title, String description, Teacher teacher, Course course, Set<Question> questions,
			Set<QuizMark> quizMarks, Admin createdBy, Admin updatedBy, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.teacher = teacher;
		this.course = course;
		this.questions = questions;
		this.quizMarks = quizMarks;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Quiz() {
    }
	


	public Teacher getTeacher() {
		return teacher;
	}




	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}




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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Set<QuizMark> getQuizMarks() {
		return quizMarks;
	}
	public void setQuizMarks(Set<QuizMark> quizMarks) {
		this.quizMarks = quizMarks;
	}
	public Admin getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Admin createdBy) {
		this.createdBy = createdBy;
	}
	public Admin getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Admin updatedBy) {
		this.updatedBy = updatedBy;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

    
    
    // Getters and Setters
}
