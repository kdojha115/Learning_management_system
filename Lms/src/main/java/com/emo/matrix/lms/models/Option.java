package com.emo.matrix.lms.models;

import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text; // Text of the option

    private Boolean isCorrect; // Whether this option is the correct answer

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question; // The question to which this option belongs

	public Option(Long id, String text, Boolean isCorrect, Question question) {
		super();
		this.id = id;
		this.text = text;
		this.isCorrect = isCorrect;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
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

    // Getters and Setters
    
    
}
