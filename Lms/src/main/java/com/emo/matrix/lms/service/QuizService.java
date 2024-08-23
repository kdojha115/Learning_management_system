package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Quiz;
import com.emo.matrix.lms.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Create a new quiz
    public Quiz createQuiz(Quiz quiz) {
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setUpdatedAt(LocalDateTime.now());
        return quizRepository.save(quiz);
    }

    // Get all quizzes
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Get quizzes by course ID
    public List<Quiz> getQuizzesByCourseId(Long courseId) {
        return quizRepository.findByCourseId(courseId);
    }

    // Get a quiz by its ID
    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }

    // Update an existing quiz
    public Quiz updateQuiz(Long id, Quiz updatedQuiz) {
        return quizRepository.findById(id).map(existingQuiz -> {
            existingQuiz.setTitle(updatedQuiz.getTitle());
            existingQuiz.setDescription(updatedQuiz.getDescription());
            existingQuiz.setCourse(updatedQuiz.getCourse());
            existingQuiz.setTeacher(updatedQuiz.getTeacher());
            existingQuiz.setQuestions(updatedQuiz.getQuestions());
            existingQuiz.setQuizMarks(updatedQuiz.getQuizMarks());
            existingQuiz.setUpdatedBy(updatedQuiz.getUpdatedBy());
            existingQuiz.setUpdatedAt(LocalDateTime.now());
            return quizRepository.save(existingQuiz);
        }).orElseThrow(() -> new RuntimeException("Quiz not found with id: " + id));
    }

    // Delete a quiz by its ID
    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
