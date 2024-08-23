package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Question;
import com.emo.matrix.lms.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    /**
     * Create a new question.
     *
     * @param question The Question entity to be created.
     * @return The created Question entity.
     */
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    /**
     * Get a question by its ID.
     *
     * @param id The ID of the question.
     * @return An Optional containing the Question entity if found.
     */
    public Optional<Question> getQuestionById(Long id) {
        return questionRepository.findById(id);
    }

    /**
     * Get all questions.
     *
     * @return A list of all Question entities.
     */
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    /**
     * Update an existing question.
     *
     * @param id       The ID of the question to be updated.
     * @param question The Question entity with updated information.
     * @return The updated Question entity.
     */
    public Optional<Question> updateQuestion(Long id, Question question) {
        Optional<Question> existingQuestion = getQuestionById(id);
        if (existingQuestion.isPresent()) {
            Question updatedQuestion = existingQuestion.get();
            updatedQuestion.setText(question.getText());
            updatedQuestion.setOptions(question.getOptions());
            updatedQuestion.setExplanation(question.getExplanation());
            return Optional.of(questionRepository.save(updatedQuestion));
        }
        return Optional.empty();
    }

    /**
     * Delete a question by its ID.
     *
     * @param id The ID of the question to be deleted.
     */
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    /**
     * Get all questions by quiz ID.
     *
     * @param quizId The ID of the quiz.
     * @return A list of questions associated with the quiz.
     */
    public List<Question> getQuestionsByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
