package com.emo.matrix.lms.dto;

public class OptionDTO {

    private Long id;
    private String text; // Text of the option
    private Boolean isCorrect; // Whether this option is the correct answer
    private String question; // The question to which this option belongs

    // Default constructor
    public OptionDTO() {
    }

    // Constructor with fields
    public OptionDTO(Long id, String text, Boolean isCorrect, String question) {
        this.id = id;
        this.text = text;
        this.isCorrect = isCorrect;
        this.question = question;
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

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(Boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
