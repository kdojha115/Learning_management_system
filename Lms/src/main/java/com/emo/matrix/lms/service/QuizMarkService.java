package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.QuizMark;
import com.emo.matrix.lms.repository.QuizMarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizMarkService {

    @Autowired
    private QuizMarkRepository quizMarkRepository;

    // Create a new QuizMark
    public QuizMark createQuizMark(QuizMark quizMark) {
        quizMark.setCreatedAt(LocalDateTime.now());
        quizMark.setUpdatedAt(LocalDateTime.now());
        return quizMarkRepository.save(quizMark);
    }

    // Get all QuizMarks
    public List<QuizMark> getAllQuizMarks() {
        return quizMarkRepository.findAll();
    }

    // Get QuizMarks by student ID
    public List<QuizMark> getQuizMarksByStudentId(Long studentId) {
        return quizMarkRepository.findByStudentId(studentId);
    }

    // Get QuizMarks by quiz ID
    public List<QuizMark> getQuizMarksByQuizId(Long quizId) {
        return quizMarkRepository.findByQuizId(quizId);
    }

    // Get a QuizMark by its ID
    public Optional<QuizMark> getQuizMarkById(Long id) {
        return quizMarkRepository.findById(id);
    }

    // Update an existing QuizMark
    public QuizMark updateQuizMark(Long id, QuizMark updatedQuizMark) {
        return quizMarkRepository.findById(id).map(existingQuizMark -> {
            existingQuizMark.setMark(updatedQuizMark.getMark());
            existingQuizMark.setQuiz(updatedQuizMark.getQuiz());
            existingQuizMark.setStudent(updatedQuizMark.getStudent());
            existingQuizMark.setUpdatedBy(updatedQuizMark.getUpdatedBy());
            existingQuizMark.setUpdatedAt(LocalDateTime.now());
            return quizMarkRepository.save(existingQuizMark);
        }).orElseThrow(() -> new RuntimeException("QuizMark not found with id: " + id));
    }

    // Delete a QuizMark by its ID
    public void deleteQuizMark(Long id) {
        quizMarkRepository.deleteById(id);
    }
}
