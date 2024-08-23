package com.emo.matrix.lms.utils;

import com.emo.matrix.lms.dto.AdminDTO;
import com.emo.matrix.lms.dto.AssignmentDTO;
import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.dto.StudentDTO;
import com.emo.matrix.lms.dto.TeacherDTO;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Assignment;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.models.Teacher;

import java.util.Set;
import java.util.stream.Collectors;

public class DtoConverter {

    
//    public static AdminDTO convertToAdminDTO(Admin admin) {
//        if (admin == null) {
//            return null;
//        }
//        return new AdminDTO(
//            admin.getId(),
//            admin.getName(),
//            admin.getEmail(),
//            admin.getPhoneNumber(),
//            admin.isSuperAdmin(),
//            admin.getTeachers().stream().map(Teacher::getId).collect(Collectors.toSet()),
//            admin.getStudents().stream().map(Student::getId).collect(Collectors.toSet()),
//            admin.getCourses().stream().map(Course::getId).collect(Collectors.toSet()),
//            admin.getCreatedBy(),
//            admin.getCreatedAt(),
//            admin.getUpdatedBy(),
//            admin.getUpdatedAt()
//        );
//    }
//
//    public static Admin convertToAdmin(AdminDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//        return new Admin(
//            dto.getId(),
//            dto.getName(),
//            dto.getEmail(),
//            dto.getPhoneNumber(),
//            null, // Password should be handled securely
//            dto.isSuperAdmin(),
//            dto.getTeacherIds().stream().map(Teacher::).collect(Collectors.toSet()),
//            dto.getStudentIds().stream().map(Student::new).collect(Collectors.toSet()),
//            dto.getCourseIds().stream().map(Course::new).collect(Collectors.toSet()),
//            dto.getCreatedBy(),
//            dto.getCreatedAt(),
//            dto.getUpdatedBy(),
//            dto.getUpdatedAt()
//        );
//    }
//
//    // Assignment conversions
//    public static AssignmentDTO convertToAssignmentDTO(Assignment assignment) {
//        if (assignment == null) {
//            return null;
//        }
//        return new AssignmentDTO(
//            assignment.getId(),
//            assignment.getTitle(),
//            assignment.getDescription(),
//            assignment.getDueDate(),
//            assignment.getTeacher() != null ? assignment.getTeacher().getId() : null,
//            assignment.getCourse().getId(),
//            assignment.getStudentAssignments().stream().map(sa -> sa.getId()).collect(Collectors.toSet()),
//            assignment.getFileUpload(),
//            assignment.isGraded(),
//            assignment.getGrade(),
//            assignment.getCreatedBy(),
//            assignment.getCreatedAt(),
//            assignment.getUpdatedBy(),
//            assignment.getUpdatedAt()
//        );
//    }
//
//    public static Assignment convertToAssignment(AssignmentDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//        return new Assignment(
//            dto.getId(),
//            dto.getTitle(),
//            dto.getDescription(),
//            dto.getDueDate(),
//            dto.getTeacherName() != null ? new Teacher(dto.getTeacherName()) : null,
//            new Course(dto.getCourseId()),
//            dto.getStudentAssignmentIds().stream().map(id -> new StudentAssignment(id)).collect(Collectors.toSet()),
//            dto.getFileUpload(),
//            dto.isGraded(),
//            dto.getGrade(),
//            dto.getCreatedBy(),
//            dto.getCreatedAt(),
//            dto.getUpdatedBy(),
//            dto.getUpdatedAt()
//        );
//    }
//
//    // Course conversions
//    public static CourseDTO convertToCourseDTO(Course course) {
//        if (course == null) {
//            return null;
//        }
//        return new CourseDTO(
//            course.getId(),
//            course.getName(),
//            course.getDescription(),
//            course.getCreatedBy(),
//            course.getCreatedAt(),
//            course.getUpdatedBy(),
//            course.getUpdatedAt()
//        );
//    }
//
//    public static Course convertToCourse(CourseDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//        return new Course(
//            dto.getId(),
//            dto.getName(),
//            dto.getDescription(),
//            dto.getCreatedBy(),
//            dto.getCreatedAt(),
//            dto.getUpdatedBy(),
//            dto.getUpdatedAt()
//        );
//    }
//
//    // Student conversions
//    public static StudentDTO convertToStudentDTO(Student student) {
//        if (student == null) {
//            return null;
//        }
//        return new StudentDTO(
//            student.getId(),
//            student.getName(),
//            student.getEmail(),
//            student.getPhoneNumber(),
//            student.getCourses().stream().map(Course::getId).collect(Collectors.toSet()),
//            student.getCreatedBy(),
//            student.getCreatedAt(),
//            student.getUpdatedBy(),
//            student.getUpdatedAt()
//        );
//    }
//
//    public static Student convertToStudent(StudentDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//        return new Student(
//            dto.getId(),
//            dto.getName(),
//            dto.getEmail(),
//            dto.getPhoneNumber(),
//            dto.getCourses().stream().map(Course::new).collect(Collectors.toSet()),
//            dto.getCreatedBy(),
//            dto.getCreatedAt(),
//            dto.getUpdatedBy(),
//            dto.getUpdatedAt()
//        );
//    }
//
//    // Teacher conversions
//    public static TeacherDTO convertToTeacherDTO(Teacher teacher) {
//        if (teacher == null) {
//            return null;
//        }
//        return new TeacherDTO(
//            teacher.getId(),
//            teacher.getName(),
//            teacher.getEmail(),
//            teacher.getPhoneNumber(),
//            teacher.getCourses().stream().map(Course::getId).collect(Collectors.toSet()),
//            teacher.getCreatedBy(),
//            teacher.getCreatedAt(),
//            teacher.getUpdatedBy(),
//            teacher.getUpdatedAt()
//        );
//    }
//
//    public static Teacher convertToTeacher(TeacherDTO dto) {
//        if (dto == null) {
//            return null;
//        }
//        return new Teacher(
//            dto.getId(),
//            dto.getName(),
//            dto.getEmail(),
//            dto.getPhoneNumber(),
//            dto.getCourses().stream().map(Course::new).collect(Collectors.toSet()),
//            dto.getCreatedBy(),
//            dto.getCreatedAt(),
//            dto.getUpdatedBy(),
//            dto.getUpdatedAt()
//        );
//    }
}
