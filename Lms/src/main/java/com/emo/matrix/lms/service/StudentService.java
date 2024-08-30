package com.emo.matrix.lms.service;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Student;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.StudentRepository;
import com.emo.matrix.lms.utils.CourseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private AdminRepository adminRepository;

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
            if (studentDetails.getIndependent()) { // Assuming isIndependent is a Boolean
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
    public Set<CourseDTO> getCoursesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return student.getCourses().stream().map(CourseUtil::toDTO).collect(Collectors.toSet());
        }
        return null;
    }

	public Optional<Student> findStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	public Student createdStudentByAdmin(Student student, Long adminId) {
		
		Optional<Admin> admin = adminRepository.findById(adminId);
		if(adminId != null) {
			Admin a = admin.get();
			student.setIsIndependent(false);
			student.setCreatedBy(a.getName());
			student.setAdmin(a);
		}
		return studentRepository.save(student);
	}

	public Student updateStudentByAdmin(Long id, Long adminId, Student student) {
		
		Optional<Admin> admin = adminRepository.findById(adminId);
		if(adminId != null) {
			Admin a = admin.get();
			String name = a.getName();
//			System.out.println(name);
			Student existingStudent = studentRepository.findById(id).orElse(null);

	        if (existingStudent != null) {
	            // Update fields only if they are provided (non-null or non-empty)
	            if (student.getName() != null) {
	                existingStudent.setName(student.getName());
	            }
	            if (student.getPhoneNumber() != null) {
	                existingStudent.setPhoneNumber(student.getPhoneNumber());
	            }
	            if (student.getEmail() != null) {
	                existingStudent.setEmail(student.getEmail());
	            }
	            if (student.getPassword() != null) {
	                existingStudent.setPassword(student.getPassword());
	            }
	            
	            if (student.getDepartment() != null) {
	                existingStudent.setDepartment(student.getDepartment());
	            }
	            if (student.getCourses() != null && !student.getCourses().isEmpty()) {
	                existingStudent.setCourses(student.getCourses());
	            }
	            
	            existingStudent.setUpdatedBy(name);

//				System.out.println(existingStudent.getUpdatedBy());
	            existingStudent.setAdmin(a);

	            // Save and return the updated student
	            return studentRepository.save(existingStudent);
	        }
			
		}
		return null;
	}
}
