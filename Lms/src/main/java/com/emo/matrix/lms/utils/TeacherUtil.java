package com.emo.matrix.lms.utils;

import com.emo.matrix.lms.dto.TeacherDTO;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Teacher;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class TeacherUtil {

    // Convert Teacher to TeacherDTO
    public TeacherDTO toDTO(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        return new TeacherDTO(
            teacher.getId(),
            teacher.getName(),
            teacher.getEmail(),
            teacher.getPhoneNumber(),
            teacher.isIndependent(),
            teacher.getAdmin() != null ? teacher.getAdmin().getName() : null,
            teacher.getDepartment() != null ? teacher.getDepartment().getName() : null,
            convertCoursesToIDs(teacher.getCourses()), // Courses can be handled separately
            null, // Assignments can be handled separately
            null, // Quizzes can be handled separately
            null, // Feedbacks can be handled separately
            teacher.getCreatedBy(),
            teacher.getCreatedAt(),
            teacher.getUpdatedBy(),
            teacher.getUpdatedAt(),
            teacher.isApproved()
        );
    }

    // Convert TeacherDTO to Teacher
    public Teacher toEntity(TeacherDTO teacherDTO) {
        if (teacherDTO == null) {
            return null;
        }

        return new Teacher(
            teacherDTO.getId(),
            teacherDTO.getName(),
            teacherDTO.getEmail(),
            teacherDTO.getPhoneNumber(),
            null, // Password should be handled separately
            teacherDTO.isIndependent(),
            null, // Admin should be handled separately
            null, // Department should be handled separately
            null, // Courses can be handled separately
            null, // Assignments can be handled separately
            null, // Quizzes can be handled separately
            null, // Feedbacks can be handled separately
            teacherDTO.getCreatedBy(),
            teacherDTO.getCreatedAt(),
            teacherDTO.getUpdatedBy(),
            teacherDTO.getUpdatedAt(),
            teacherDTO.isApproved()
        );
    }
    
//	  Convert Set of Courses to Set of IDs
	  private Set<String> convertCoursesToIDs(Set<Course> courses) {
	      return courses.stream()
	          .map(course -> course.getId().toString())
	          .collect(Collectors.toSet());
	  }
}
