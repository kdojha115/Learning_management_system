package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Method to retrieve all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Method to retrieve a student by ID
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    // Method to create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Method to update an existing student
    public Student updateStudent(Long studentId, Student studentDetails) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);

        if (existingStudent != null) {
            // Update fields only if they are provided (non-null or non-empty)
            if (studentDetails.getName() != null) {
                existingStudent.setName(studentDetails.getName());
            }
            if (studentDetails.getPhoneNumber() != null) {
                existingStudent.setPhoneNumber(studentDetails.getPhoneNumber());
            }
            if (studentDetails.getEmail() != null) {
                existingStudent.setEmail(studentDetails.getEmail());
            }
            if (studentDetails.getPassword() != null) {
                existingStudent.setPassword(studentDetails.getPassword());
            }
            if (studentDetails.getIsIndependent() != null) { // Assuming isIndependent is a Boolean
                existingStudent.setIsIndependent(studentDetails.getIndependent());
            }
            if (studentDetails.getAdmin() != null) {
                existingStudent.setAdmin(studentDetails.getAdmin());
            }
            if (studentDetails.getDepartment() != null) {
                existingStudent.setDepartment(studentDetails.getDepartment());
            }
            if (studentDetails.getCourses() != null && !studentDetails.getCourses().isEmpty()) {
                existingStudent.setCourses(studentDetails.getCourses());
            }

            // Save and return the updated student
            return studentRepository.save(existingStudent);
        }

        // Return null if the student was not found
        return null;
    }


    // Method to delete a student by ID
    public void deleteStudent(Long studentId) {
            studentRepository.deleteById(studentId);
    }

    // Method to get courses by student ID
    public Set<Course> getCoursesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getCourses();
        }
        return null;
    }
}
