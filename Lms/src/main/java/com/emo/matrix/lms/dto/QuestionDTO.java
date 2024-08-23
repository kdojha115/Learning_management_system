package com.emo.matrix.lms.dto;

import java.util.Set;

public class QuestionDTO {

    private Long id;
    private String text;
    private String explanation;
    private String questionType; // Enum type as a string (e.g., "multiple-choice", "true/false")
    private Integer points;
    private String difficultyLevel;
    private Set<String> options; // List of option texts as strings
    private String quiz; // Quiz object as a string (e.g., Quiz ID or other identifier)

    // Default constructor
    public QuestionDTO() {
    }

    // Constructor with fields
    public QuestionDTO(Long id, String text, String explanation, String questionType, Integer points,
                       String difficultyLevel, Set<String> options, String quiz) {
        this.id = id;
        this.text = text;
        this.explanation = explanation;
        this.questionType = questionType;
        this.points = points;
        this.difficultyLevel = difficultyLevel;
        this.options = options;
        this.quiz = quiz;
    }

    // Getters and Setters
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
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

    public Set<String> getOptions() {
        return options;
    }

    public void setOptions(Set<String> options) {
        this.options = options;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }
}
