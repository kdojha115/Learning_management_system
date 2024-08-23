package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Assignment;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.models.StudentAssignment;
import com.emo.matrix.lms.models.StudentAssignmentPk;
import com.emo.matrix.lms.repository.AssignmentRepository;
import com.emo.matrix.lms.repository.StudentAssignmentRepository;
import com.emo.matrix.lms.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
	
	StudentRepository studentRepository;

    private final AssignmentRepository assignmentRepository;
    private final StudentAssignmentRepository studentAssignmentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, StudentAssignmentRepository studentAssignmentRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentAssignmentRepository = studentAssignmentRepository;
    }

    // Create a new Assignment
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Get all Assignments
    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    // Get Assignments by Course ID
    public List<Assignment> getAssignmentsByCourseId(Long courseId) {
        return assignmentRepository.findByCourseId(courseId);
    }

    // Get a specific Assignment by ID
    public Optional<Assignment> getAssignmentById(Long assignmentId) {
        return assignmentRepository.findById(assignmentId);
    }

    // Update an existing Assignment
    public Assignment updateAssignment(Long assignmentId, Assignment assignmentDetails) {
        Optional<Assignment> assignmentOptional = assignmentRepository.findById(assignmentId);

        if (assignmentOptional.isPresent()) {
            Assignment assignment = assignmentOptional.get();
            assignment.setTitle(assignmentDetails.getTitle());
            assignment.setDescription(assignmentDetails.getDescription());
            assignment.setDueDate(assignmentDetails.getDueDate());
            assignment.setCourse(assignmentDetails.getCourse());
            return assignmentRepository.save(assignment);
        } else {
            throw new RuntimeException("Assignment not found");
        }
    }

    // Delete an Assignment by ID
    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    // Assign an Assignment to a Student
//    public StudentAssignment assignAssignmentToStudent(Long assignmentId, Long studentId) {
//        StudentAssignment studentAssignment = new StudentAssignment(studentId, assignmentId);
//        return studentAssignmentRepository.save(studentAssignment);
//    }
    
    public StudentAssignment assignAssignmentToStudent(Long assignmentId, Long studentId) {
        // Fetch the Student and Assignment entities using their IDs
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        Assignment assignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(() -> new RuntimeException("Assignment not found with id: " + assignmentId));

        // Create the composite key
        StudentAssignmentPk studentAssignmentPk = new StudentAssignmentPk(studentId, assignmentId);

        // Create the StudentAssignment entity
        StudentAssignment studentAssignment = new StudentAssignment();
        studentAssignment.setId(studentAssignmentPk);
        studentAssignment.setStudent(student);
        studentAssignment.setAssignment(assignment);

        // Save the entity
        return studentAssignmentRepository.save(studentAssignment);
    }


    // Get Assignments by Student ID
    public List<StudentAssignment> getAssignmentsByStudentId(Long studentId) {
        return studentAssignmentRepository.findByStudentId(studentId);
    }

    // Grade an Assignment
    public StudentAssignment gradeAssignment(Long studentId, Long assignmentId, int grade) {
        Optional<StudentAssignment> studentAssignmentOptional = studentAssignmentRepository.findByStudentIdAndAssignmentId(studentId, assignmentId);

        if (studentAssignmentOptional.isPresent()) {
            StudentAssignment studentAssignment = studentAssignmentOptional.get();
            studentAssignment.setGrade(grade);
            return studentAssignmentRepository.save(studentAssignment);
        } else {
            throw new RuntimeException("Student assignment not found");
        }
    }
}
