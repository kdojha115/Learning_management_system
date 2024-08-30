package com.emo.matrix.lms.service;

import com.emo.matrix.lms.dto.TeacherDTO;
import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Admin;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.AdminRepository;
import com.emo.matrix.lms.repository.CourseRepository;
import com.emo.matrix.lms.repository.TeacherRepository;
import com.emo.matrix.lms.utils.TeacherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @Autowired
    private AdminRepository adminRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    
    public Teacher createdTeacherByAdmin(Teacher teacher, Long adminId) {
    	Optional<Admin> admin = adminRepository.findById(adminId);
    	if(adminId != null) {
    		Admin a = admin.get();
    		teacher.setIndependent(false);
    		teacher.setApproved(true);
    		teacher.setCreatedBy(a.getName());
    		teacher.setAdmin(a);
    	}
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDTO) {
        Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Teacher not found with id: " + id)
        );

        // Update fields only if they are provided (non-null or non-empty)
        if (teacherDTO.getName() != null) {
            existingTeacher.setName(teacherDTO.getName());
        }
        if (teacherDTO.getEmail() != null) {
            existingTeacher.setEmail(teacherDTO.getEmail());
        }
        if (teacherDTO.getPhoneNumber() != null) {
            existingTeacher.setPhoneNumber(teacherDTO.getPhoneNumber());
        }
        if (teacherDTO.isIndependent()) { // Assuming independent is a Boolean
            existingTeacher.setIndependent(teacherDTO.isIndependent());
        }
        // Add any additional related entities update logic here if needed

        // Update other fields like createdBy, updatedBy, etc., if needed
        if (teacherDTO.getCreatedBy() != null) {
            existingTeacher.setCreatedBy(teacherDTO.getCreatedBy());
        }
        if (teacherDTO.getCreatedAt() != null) {
            existingTeacher.setCreatedAt(teacherDTO.getCreatedAt());
        }
        if (teacherDTO.getUpdatedBy() != null) {
            existingTeacher.setUpdatedBy(teacherDTO.getUpdatedBy());
        }
        if (teacherDTO.getUpdatedAt() != null) {
            existingTeacher.setUpdatedAt(teacherDTO.getUpdatedAt());
        }
        if (teacherDTO.isApproved() != true) { // Assuming approved is a Boolean
            existingTeacher.setApproved(teacherDTO.isApproved());
        }

        // Save and return the updated teacher
        return teacherRepository.save(existingTeacher);
  
    }

//    public TeacherDTO getTeacherById(Long id) {
//        Teacher teacher = teacherRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
//        return TeacherUtil.toDTO(teacher);
//    }
//
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }



    public Teacher assignCourseToTeacher(Long teacherId, Long courseId) {
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + teacherId));
        // Assume CourseRepository is available and you can fetch course by ID
         Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));
         teacher.getCourses().add(course);
         course.setTeacher(teacher);
        return teacherRepository.save(teacher);
    }

	public Optional<Teacher> findTeacherById(Long id) {
		// TODO Auto-generated method stub
		return teacherRepository.findById(id);
	}

	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return teacherRepository.existsById(id);
	}

	public void deleteTeacher(Long id) {
		// TODO Auto-generated method stub
		teacherRepository.deleteById(id);
		
	}

	public Teacher updateTeacherByAdmin(Long id, Long adminId, Teacher teacher) {
		
		Optional<Admin> admin = adminRepository.findById(adminId);
		if(adminId != null) {
			Admin a = admin.get();
			Teacher existingTeacher = teacherRepository.findById(id).orElseThrow(
		            () -> new ResourceNotFoundException("Teacher not found with id: " + id)
		        );

		        // Update fields only if they are provided (non-null or non-empty)
		        if (teacher.getName() != null) {
		            existingTeacher.setName(teacher.getName());
		        }
		        if (teacher.getEmail() != null) {
		            existingTeacher.setEmail(teacher.getEmail());
		        }
		        if (teacher.getPhoneNumber() != null) {
		            existingTeacher.setPhoneNumber(teacher.getPhoneNumber());
		        }
		        
		        // Add any additional related entities update logic here if needed

		        // Update other fields like createdBy, updatedBy, etc., if needed
		        if (teacher.getCreatedBy() != null) {
		            existingTeacher.setCreatedBy(teacher.getCreatedBy());
		        }
		        if (teacher.getCreatedAt() != null) {
		            existingTeacher.setCreatedAt(teacher.getCreatedAt());
		        }
		        if (teacher.getUpdatedBy() != null) {
		            existingTeacher.setUpdatedBy(teacher.getUpdatedBy());
		        }
		        if (teacher.getUpdatedAt() != null) {
		            existingTeacher.setUpdatedAt(teacher.getUpdatedAt());
		        }
		        if (teacher.isApproved() != true) { // Assuming approved is a Boolean
		            existingTeacher.setApproved(teacher.isApproved());
		        }
		        
		        existingTeacher.setAdmin(a);

		        // Save and return the updated teacher
		        return teacherRepository.save(existingTeacher);
		}
		return null;
	}
}
