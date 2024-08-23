package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    
    private String explanation;

    @Enumerated(EnumType.STRING)
    private QuestionType questionType; // Enum for type of question (e.g., multiple-choice, true/false)

    private Integer points; // Points for the question

    private String difficultyLevel; // Difficulty level (e.g., easy, medium, hard)

    @OneToMany(mappedBy = "question")
    private Set<Option> options; // Options for the question

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz; // Quiz to which this question belongs

	

	public Question(Long id, String text, String explanation, QuestionType questionType, Integer points,
			String difficultyLevel, Set<Option> options, Quiz quiz) {
		super();
		this.id = id;
		this.text = text;
		this.explanation = explanation;
		this.questionType = questionType;
		this.points = points;
		this.difficultyLevel = difficultyLevel;
		this.options = options;
		this.quiz = quiz;
	}
	
	

	public String getExplanation() {
		return explanation;
	}



	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

    // Getters and Setters
    
}
