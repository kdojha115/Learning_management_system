package com.emo.matrix.lms.utils;

import com.emo.matrix.lms.dto.StudentDTO;
import com.emo.matrix.lms.models.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

    // Convert Student to StudentDTO
    public StudentDTO toDTO(Student student) {
        if (student == null) {
            return null;
        }

        return new StudentDTO(
            student.getId(),
            student.getName(),
            student.getPhoneNumber(),
            student.getEmail(),
            student.getIndependent(),
            student.getAdmin() != null ? student.getAdmin().getName() : null,
            student.getDepartment() != null ? student.getDepartment().getName() : null,
            null, // Enrollments can be handled separately
            null, // AnsweredQuestions can be handled separately
            null, // Certificates can be handled separately
            null, // Courses can be handled separately
            student.getCreatedBy(),
            student.getCreatedAt(),
            student.getUpdatedBy(),
            student.getUpdatedAt()
        );
    }

    // Convert StudentDTO to Student
    public Student toEntity(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        return new Student(
            studentDTO.getId(),
            studentDTO.getName(),
            studentDTO.getPhoneNumber(),
            studentDTO.getEmail(),
            null, // Password should be handled separately
            studentDTO.isIndependent(),
            null, // Admin should be handled separately
            null, // Department should be handled separately
            null, // Enrollments can be handled separately
            null, // AnsweredQuestions can be handled separately
            null, // Certificates can be handled separately
            studentDTO.getCreatedBy(),
            studentDTO.getCreatedAt(),
            studentDTO.getUpdatedBy(),
            studentDTO.getUpdatedAt(),
            null // Courses can be handled separately
        );
    }
}
