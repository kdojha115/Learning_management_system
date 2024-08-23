package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.StudentAssignment;
import com.emo.matrix.lms.models.StudentAssignmentPk;
import com.emo.matrix.lms.repository.StudentAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAssignmentService {

    @Autowired
    private StudentAssignmentRepository studentAssignmentRepository;

    /**
     * Assign an assignment to a student.
     *
     * @param studentId    The ID of the student.
     * @param assignmentId The ID of the assignment.
     * @return The created StudentAssignment entity.
     */
    public StudentAssignment assignAssignmentToStudent(Long studentId, Long assignmentId) {
        StudentAssignment studentAssignment = new StudentAssignment(studentId, assignmentId);
        return studentAssignmentRepository.save(studentAssignment);
    }

    /**
     * Get all assignments for a specific student.
     *
     * @param studentId The ID of the student.
     * @return A list of StudentAssignment entities.
     */
    public List<StudentAssignment> getAssignmentsByStudentId(Long studentId) {
        return studentAssignmentRepository.findByStudentId(studentId);
    }

    /**
     * Get a specific assignment for a student.
     *
     * @param studentId    The ID of the student.
     * @param assignmentId The ID of the assignment.
     * @return The StudentAssignment entity.
     */
    public Optional<StudentAssignment> getAssignmentByStudentIdAndAssignmentId(Long studentId, Long assignmentId) {
        StudentAssignmentPk id = new StudentAssignmentPk(studentId, assignmentId);
        return studentAssignmentRepository.findById(id);
    }

    /**
     * Update the grade of an assignment for a student.
     *
     * @param studentId    The ID of the student.
     * @param assignmentId The ID of the assignment.
     * @param grade        The new grade.
     * @return The updated StudentAssignment entity.
     */
    public Optional<StudentAssignment> updateGrade(Long studentId, Long assignmentId, int grade) {
        Optional<StudentAssignment> studentAssignmentOpt = getAssignmentByStudentIdAndAssignmentId(studentId, assignmentId);
        if (studentAssignmentOpt.isPresent()) {
            StudentAssignment studentAssignment = studentAssignmentOpt.get();
            studentAssignment.setGrade(grade);
            return Optional.of(studentAssignmentRepository.save(studentAssignment));
        }
        return Optional.empty();
    }

    /**
     * Delete a specific assignment for a student.
     *
     * @param studentId    The ID of the student.
     * @param assignmentId The ID of the assignment.
     */
    public void deleteAssignment(Long studentId, Long assignmentId) {
        StudentAssignmentPk id = new StudentAssignmentPk(studentId, assignmentId);
        studentAssignmentRepository.deleteById(id);
    }

    /**
     * Get all StudentAssignment entries.
     *
     * @return A list of all StudentAssignment entities.
     */
    public List<StudentAssignment> getAllStudentAssignments() {
        return studentAssignmentRepository.findAll();
    }
}
