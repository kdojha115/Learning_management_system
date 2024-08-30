package com.emo.matrix.lms.utils;

import com.emo.matrix.lms.dto.AdminDTO;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.models.Teacher;

import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AdminUtil {

    // Convert Admin to AdminDTO
    public AdminDTO toDTO(Admin admin) {
        return new AdminDTO(
            admin.getId(),
            admin.getName(),
            admin.getEmail(),
            admin.getPhoneNumber(),
            admin.isSuperAdmin(),
            null,
            null,
            null,
//            convertTeachersToIDs(admin.getTeachers()),
//            convertStudentsToIDs(admin.getStudents()),
//            convertCoursesToIDs(admin.getCourses()),
            admin.getCreatedBy(),
            admin.getCreatedAt(),
            admin.getUpdatedBy(),
            admin.getUpdatedAt()
        );
    }

    // Convert AdminDTO to Admin
    public Admin toEntity(AdminDTO adminDTO) {
        return new Admin(
            adminDTO.getId(),
            adminDTO.getName(),
            adminDTO.getEmail(),
            adminDTO.getPhoneNumber(),
            null, // Password should be handled separately
            adminDTO.isSuperAdmin(),
            null, // Teachers should be handled separately
            null, // Students should be handled separately
            null, // Courses should be handled separately
            adminDTO.getCreatedBy(),
            adminDTO.getCreatedAt(),
            adminDTO.getUpdatedBy(),
            adminDTO.getUpdatedAt()
        );
    }

    // Convert Set of Teachers to Set of IDs
//    private Set<String> convertTeachersToIDs(Set<Teacher> teachers) {
//        return teachers.stream()
//            .map(teacher -> teacher.getId().toString())
//            .collect(Collectors.toSet());
//    }
//
//    // Convert Set of Students to Set of IDs
//    private Set<String> convertStudentsToIDs(Set<Student> students) {
//        return students.stream()
//            .map(student -> student.getId().toString())
//            .collect(Collectors.toSet());
//    }
//
//    // Convert Set of Courses to Set of IDs
//    private Set<String> convertCoursesToIDs(Set<Course> courses) {
//        return courses.stream()
//            .map(course -> course.getId().toString())
//            .collect(Collectors.toSet());
//    }
}
