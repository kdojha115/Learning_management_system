package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.QuizMark;
import com.emo.matrix.lms.service.QuizMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quiz-marks")
public class QuizMarkController {

    @Autowired
    private QuizMarkService quizMarkService;

    // Create a new QuizMark
    @PostMapping("/")
    public ResponseEntity<QuizMark> createQuizMark(@RequestBody QuizMark quizMark) {
        QuizMark createdQuizMark = quizMarkService.createQuizMark(quizMark);
        return ResponseEntity.ok(createdQuizMark);
    }

    // Get all QuizMarks
    @GetMapping("/")
    public ResponseEntity<List<QuizMark>> getAllQuizMarks() {
        List<QuizMark> quizMarks = quizMarkService.getAllQuizMarks();
        return ResponseEntity.ok(quizMarks);
    }

    // Get QuizMarks by student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<QuizMark>> getQuizMarksByStudentId(@PathVariable Long studentId) {
        List<QuizMark> quizMarks = quizMarkService.getQuizMarksByStudentId(studentId);
        return ResponseEntity.ok(quizMarks);
    }

    // Get QuizMarks by quiz ID
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizMark>> getQuizMarksByQuizId(@PathVariable Long quizId) {
        List<QuizMark> quizMarks = quizMarkService.getQuizMarksByQuizId(quizId);
        return ResponseEntity.ok(quizMarks);
    }

    // Get a QuizMark by its ID
    @GetMapping("/{id}")
    public ResponseEntity<QuizMark> getQuizMarkById(@PathVariable Long id) {
        Optional<QuizMark> quizMark = quizMarkService.getQuizMarkById(id);
        return quizMark.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing QuizMark
    @PutMapping("/{id}")
    public ResponseEntity<QuizMark> updateQuizMark(@PathVariable Long id, @RequestBody QuizMark updatedQuizMark) {
        try {
            QuizMark quizMark = quizMarkService.updateQuizMark(id, updatedQuizMark);
            return ResponseEntity.ok(quizMark);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a QuizMark by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuizMark(@PathVariable Long id) {
        quizMarkService.deleteQuizMark(id);
        return ResponseEntity.noContent().build();
    }
}
