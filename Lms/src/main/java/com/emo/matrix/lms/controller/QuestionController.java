package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Question;
import com.emo.matrix.lms.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Create a new question
    @PostMapping("/")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.ok(createdQuestion);
    }

    // Get a question by ID
    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Optional<Question> question = questionService.getQuestionById(id);
        return question.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all questions
    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    // Update an existing question
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> updatedQuestion = questionService.updateQuestion(id, question);
        return updatedQuestion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete a question by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    // Get all questions by quiz ID
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>> getQuestionsByQuizId(@PathVariable Long quizId) {
        List<Question> questions = questionService.getQuestionsByQuizId(quizId);
        return ResponseEntity.ok(questions);
    }
}
