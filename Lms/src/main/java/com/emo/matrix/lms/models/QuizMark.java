package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_mark")
public class QuizMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double mark; // The mark obtained in the quiz

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz; // The quiz that was attempted

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // The student who took the quiz

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin or Teacher who created this QuizMark record

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // Admin or Teacher who last updated this QuizMark record

    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    // Getters and Setters

    // Constructor with fields
    public QuizMark(Long id, Double mark, Quiz quiz, Student student, Admin createdBy, Admin updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.mark = mark;
        this.quiz = quiz;
        this.student = student;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Default Constructor
    public QuizMark() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMark() {
		return mark;
	}

	public void setMark(Double mark) {
		this.mark = mark;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
    
    
}
