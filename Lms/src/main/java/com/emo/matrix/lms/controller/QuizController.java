package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Quiz;
import com.emo.matrix.lms.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    // Create a new quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        Quiz createdQuiz = quizService.createQuiz(quiz);
        return ResponseEntity.ok(createdQuiz);
    }

    // Get all quizzes
    @GetMapping("/")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return ResponseEntity.ok(quizzes);
    }

    // Get quizzes by course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Quiz>> getQuizzesByCourseId(@PathVariable Long courseId) {
        List<Quiz> quizzes = quizService.getQuizzesByCourseId(courseId);
        return ResponseEntity.ok(quizzes);
    }

    // Get a quiz by its ID
    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long id) {
        Optional<Quiz> quiz = quizService.getQuizById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing quiz
    @PutMapping("/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable Long id, @RequestBody Quiz updatedQuiz) {
        try {
            Quiz quiz = quizService.updateQuiz(id, updatedQuiz);
            return ResponseEntity.ok(quiz);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a quiz by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        quizService.deleteQuiz(id);
        return ResponseEntity.noContent().build();
    }
}
