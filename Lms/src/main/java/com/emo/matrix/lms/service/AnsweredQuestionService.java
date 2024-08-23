package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.AnsweredQuestion;
import com.emo.matrix.lms.repository.AnsweredQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AnsweredQuestionService {

    @Autowired
    private AnsweredQuestionRepository answeredQuestionRepository;

    // Create or save a new answered question
    public AnsweredQuestion createAnsweredQuestion(AnsweredQuestion answeredQuestion) {
        answeredQuestion.setCreatedAt(LocalDateTime.now());
        answeredQuestion.setUpdatedAt(LocalDateTime.now());
        return answeredQuestionRepository.save(answeredQuestion);
    }

    // Get all answered questions for a specific student
    public List<AnsweredQuestion> getAnsweredQuestionsByStudentId(Long studentId) {
        return answeredQuestionRepository.findByStudentId(studentId);
    }

    // Get all answered questions for a specific quiz
    public List<AnsweredQuestion> getAnsweredQuestionsByQuizId(Long quizId) {
        return answeredQuestionRepository.findByQuizId(quizId);
    }

    // Get an answered question by its ID
    public Optional<AnsweredQuestion> getAnsweredQuestionById(Long id) {
        return answeredQuestionRepository.findById(id);
    }

    // Update an existing answered question
    public AnsweredQuestion updateAnsweredQuestion(Long id, AnsweredQuestion updatedAnsweredQuestion) {
        return answeredQuestionRepository.findById(id).map(existingAnsweredQuestion -> {
            existingAnsweredQuestion.setAnswer(updatedAnsweredQuestion.getAnswer());
            existingAnsweredQuestion.setIsCorrect(updatedAnsweredQuestion.getIsCorrect());
            existingAnsweredQuestion.setQuestion(updatedAnsweredQuestion.getQuestion());
            existingAnsweredQuestion.setStudent(updatedAnsweredQuestion.getStudent());
            existingAnsweredQuestion.setQuiz(updatedAnsweredQuestion.getQuiz());
            existingAnsweredQuestion.setUpdatedBy(updatedAnsweredQuestion.getUpdatedBy());
            existingAnsweredQuestion.setUpdatedAt(LocalDateTime.now());
            return answeredQuestionRepository.save(existingAnsweredQuestion);
        }).orElseThrow(() -> new RuntimeException("Answered Question not found with id: " + id));
    }

    // Delete an answered question by its ID
    public void deleteAnsweredQuestion(Long id) {
        answeredQuestionRepository.deleteById(id);
    }
}
