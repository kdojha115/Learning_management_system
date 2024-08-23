package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.AnsweredQuestion;
import com.emo.matrix.lms.service.AnsweredQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/answered-questions")
public class AnsweredQuestionController {

    @Autowired
    private AnsweredQuestionService answeredQuestionService;

    // Create or save a new answered question
    @PostMapping("/")
    public ResponseEntity<AnsweredQuestion> createAnsweredQuestion(@RequestBody AnsweredQuestion answeredQuestion) {
        AnsweredQuestion createdAnsweredQuestion = answeredQuestionService.createAnsweredQuestion(answeredQuestion);
        return ResponseEntity.ok(createdAnsweredQuestion);
    }

    // Get all answered questions for a specific student
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<AnsweredQuestion>> getAnsweredQuestionsByStudentId(@PathVariable Long studentId) {
        List<AnsweredQuestion> answeredQuestions = answeredQuestionService.getAnsweredQuestionsByStudentId(studentId);
        return ResponseEntity.ok(answeredQuestions);
    }

    // Get all answered questions for a specific quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<AnsweredQuestion>> getAnsweredQuestionsByQuizId(@PathVariable Long quizId) {
        List<AnsweredQuestion> answeredQuestions = answeredQuestionService.getAnsweredQuestionsByQuizId(quizId);
        return ResponseEntity.ok(answeredQuestions);
    }

    // Get an answered question by its ID
    @GetMapping("/{id}")
    public ResponseEntity<AnsweredQuestion> getAnsweredQuestionById(@PathVariable Long id) {
        Optional<AnsweredQuestion> answeredQuestion = answeredQuestionService.getAnsweredQuestionById(id);
        return answeredQuestion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing answered question
    @PutMapping("/{id}")
    public ResponseEntity<AnsweredQuestion> updateAnsweredQuestion(@PathVariable Long id, @RequestBody AnsweredQuestion updatedAnsweredQuestion) {
        try {
            AnsweredQuestion updatedQuestion = answeredQuestionService.updateAnsweredQuestion(id, updatedAnsweredQuestion);
            return ResponseEntity.ok(updatedQuestion);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an answered question by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnsweredQuestion(@PathVariable Long id) {
        answeredQuestionService.deleteAnsweredQuestion(id);
        return ResponseEntity.noContent().build();
    }
}
