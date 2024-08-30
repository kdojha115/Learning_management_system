package com.emo.matrix.lms.utils;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.models.*;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CourseUtil {

    // Convert Course Entity to CourseDTO
    public static CourseDTO toDTO(Course course) {
        if (course == null) {
            return null;
        }

        Set<String> vidstepTitles = course.getVidsteps() != null ? 
                course.getVidsteps().stream().map(Vidstep::getTitle).collect(Collectors.toSet()) : null;

        Set<String> assignmentTitles = course.getAssignments() != null ? 
                course.getAssignments().stream().map(Assignment::getTitle).collect(Collectors.toSet()) : null;

        Set<String> quizTitles = course.getQuizzes() != null ? 
                course.getQuizzes().stream().map(Quiz::getTitle).collect(Collectors.toSet()) : null;

        Set<Long> enrollmentIds = course.getEnrollments() != null ? 
                course.getEnrollments().stream().map(Enrollment::getId).collect(Collectors.toSet()) : null;

        Set<String> studentNames = course.getStudents() != null ? 
                course.getStudents().stream().map(Student::getName).collect(Collectors.toSet()) : null;

        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getTeacher() != null ? course.getTeacher().getName() : null,
                course.isPrivate(),
                course.isPaid(),
                course.getAdmin() != null ? course.getAdmin().getName() : null,
                course.getDepartment() != null ? course.getDepartment().getName() : null,
                vidstepTitles,
                assignmentTitles,
                quizTitles,
                enrollmentIds,
                studentNames,
                null,
                course.getCreatedBy(),
                course.getCreatedAt(),
                course.getUpdatedBy(),
                course.getUpdatedAt()
        );
    }

    // Convert CourseDTO to Course Entity
    public static Course toEntity(CourseDTO courseDTO, Teacher teacher, Admin admin, Department department, 
                                  Set<Vidstep> vidsteps, Set<Assignment> assignments, Set<Quiz> quizzes, 
                                  Set<Enrollment> enrollments, Set<Student> students) {
        if (courseDTO == null) {
            return null;
        }

        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setTitle(courseDTO.getTitle());
        course.setDescription(courseDTO.getDescription());
        course.setTeacher(teacher);
        course.setPrivate(courseDTO.isPrivate());
        course.setPaid(courseDTO.isPaid());
        course.setAdmin(admin);
        course.setDepartment(department);
        course.setVidsteps(vidsteps);
        course.setAssignments(assignments);
        course.setQuizzes(quizzes);
        course.setEnrollments(enrollments);
        course.setStudents(students);
//        course.setVideoFiles(courseDTO.getVideoFiles());
        course.setCreatedBy(courseDTO.getCreatedBy());
        course.setCreatedAt(courseDTO.getCreatedAt());
        course.setUpdatedBy(courseDTO.getUpdatedBy());
        course.setUpdatedAt(courseDTO.getUpdatedAt());

        return course;
    }
}
