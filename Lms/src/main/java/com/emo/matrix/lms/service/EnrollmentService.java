package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Enrollment;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.repository.EnrollmentRepository;
import com.emo.matrix.lms.repository.StudentRepository;
import com.emo.matrix.lms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository, 
                             StudentRepository studentRepository, 
                             CourseRepository courseRepository) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    // Enroll a student in a course
    public Enrollment enrollStudentInCourse(Long studentId, Long courseId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        Optional<Course> courseOptional = courseRepository.findById(courseId);

        if (studentOptional.isPresent() && courseOptional.isPresent()) {
            Student student = studentOptional.get();
            Course course = courseOptional.get();

            Enrollment enrollment = new Enrollment();
            enrollment.setStudent(student);
            enrollment.setCourse(course);

            return enrollmentRepository.save(enrollment);
        } else {
            throw new RuntimeException("Student or Course not found");
        }
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Get enrollments by student ID
    public List<Enrollment> getEnrollmentsByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    // Get enrollments by course ID
    public List<Enrollment> getEnrollmentsByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    // Remove enrollment by ID
    public void removeEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
