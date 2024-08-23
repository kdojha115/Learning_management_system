package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.CourseRepository;
import com.emo.matrix.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    // Method to create a new course
    public Course createCourse(Course course, Long adminId) {
    	Admin admin = adminRepository.getById(adminId);
    	course.setCreatedBy(admin.getName());
    	course.setAdmin(admin);
    	
        return courseRepository.save(course);
    }

    // Method to update an existing course
    public Course updateCourse(Long courseId, Course updatedCourse) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            course.setTitle(updatedCourse.getTitle());
            // Update other fields as necessary
            return courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found with id: " + courseId);
        }
    }

    // Method to get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Method to get a course by ID
    public Optional<Course> getCourseById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    // Method to delete a course by ID
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    // Method to get courses by a student's ID
    public List<Course> getCoursesByStudentId(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return List.copyOf(student.getCourses());
        } else {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
    }

    // Method to enroll a student in a course
    public Course enrollStudentInCourse(Long courseId, Long studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            Student student = studentOptional.get();

            course.getStudents().add(student);
            student.getCourses().add(course);

            courseRepository.save(course);
            studentRepository.save(student);

            return course;
        } else {
            throw new RuntimeException("Course or Student not found with given IDs");
        }
    }

    // Method to remove a student from a course
    public Course removeStudentFromCourse(Long courseId, Long studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            Student student = studentOptional.get();

            course.getStudents().remove(student);
            student.getCourses().remove(course);

            courseRepository.save(course);
            studentRepository.save(student);

            return course;
        } else {
            throw new RuntimeException("Course or Student not found with given IDs");
        }
    }

    public void save(Course video) {
        courseRepository.save(video);
    }
}
