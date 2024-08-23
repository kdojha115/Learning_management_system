package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "answered_question")
public class AnsweredQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer; // The student's answer to the question

    private Boolean isCorrect; // Whether the student's answer is correct or not

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question; // The question that was answered

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student; // The student who answered the question
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "student_id", referencedColumnName = "student_Id"),
        @JoinColumn(name = "assignment_id", referencedColumnName = "assignment_Id")
    })
    private StudentAssignment studentAssignment;

	@ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz; // The quiz to which this question belongs

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin or Teacher who created this AnsweredQuestion

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // Admin or Teacher who last updated this AnsweredQuestion

    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    // Getters and Setters

    // Constructor with fields

    public AnsweredQuestion(Long id, String answer, Boolean isCorrect, Question question, Student student,
			StudentAssignment studentAssignment, Quiz quiz, Admin createdBy, Admin updatedBy, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.answer = answer;
		this.isCorrect = isCorrect;
		this.question = question;
		this.student = student;
		this.studentAssignment = studentAssignment;
		this.quiz = quiz;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

    // Default Constructor
    public AnsweredQuestion() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public StudentAssignment getStudentAssignment() {
		return studentAssignment;
	}

	public void setStudentAssignment(StudentAssignment studentAssignment) {
		this.studentAssignment = studentAssignment;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
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
