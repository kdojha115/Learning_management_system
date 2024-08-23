package com.emo.matrix.lms.service;

import com.emo.matrix.lms.exception.ResourceNotFoundException;
import com.emo.matrix.lms.models.Course;
import com.emo.matrix.lms.models.Teacher;
import com.emo.matrix.lms.repository.CourseRepository;
import com.emo.matrix.lms.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;
    

    /**
     * Creates a new teacher.
     *
     * @param teacher the Teacher object to be created
     * @return the created Teacher object
     */
    public Teacher createTeacher(Teacher teacher) {
        teacher.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        teacher.setCreatedBy(teacher.getName());
        teacher.setApproved(false);  // Default to false
        teacher.setIndependent(true);
//        teacher.setAdmin(teacher.getAdmin());
        return teacherRepository.save(teacher);
    }

    /**
     * Finds a teacher by ID.
     *
     * @param teacherId the ID of the teacher to be found
     * @return the Teacher object
     * @throws ResourceNotFoundException if the teacher with the given ID does not exist
     */
    public Teacher findTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + teacherId));
    }

    /**
     * Deletes a teacher by ID.
     *
     * @param teacherId the ID of the teacher to be deleted
     */
    public void deleteTeacher(Long teacherId) {

    	teacherRepository.deleteById(teacherId);
    }

    /**
     * Updates an existing teacher.
     *
     * @param teacherId      the ID of the teacher to be updated
     * @param teacherDetails the Teacher object containing updated details
     * @return the updated Teacher object
     * @throws ResourceNotFoundException if the teacher with the given ID does not exist
     */
    public Teacher updateTeacher(Long teacherId, Teacher teacherDetails) {
        Teacher existingTeacher = findTeacherById(teacherId);

        // Update fields only if they are provided (non-null)
        if (teacherDetails.getName() != null) {
            existingTeacher.setName(teacherDetails.getName());
        }
        if (teacherDetails.getEmail() != null) {
            existingTeacher.setEmail(teacherDetails.getEmail());
        }
        if (teacherDetails.getPhoneNumber() != null) {
            existingTeacher.setPhoneNumber(teacherDetails.getPhoneNumber());
        }
        if (teacherDetails.getPassword() != null) {
            existingTeacher.setPassword(teacherDetails.getPassword());
        }
        if (teacherDetails.isIndependent()) { // Assuming isIndependent is a Boolean
            existingTeacher.setIndependent(teacherDetails.isIndependent());
        }
        if (teacherDetails.getAdmin() != null) {
            existingTeacher.setAdmin(teacherDetails.getAdmin());
        }
        if (teacherDetails.getDepartment() != null) {
            existingTeacher.setDepartment(teacherDetails.getDepartment());
        }
        if (teacherDetails.getCourses() != null && !teacherDetails.getCourses().isEmpty()) {
            existingTeacher.setCourses(teacherDetails.getCourses());
        }
        if (teacherDetails.getAssignments() != null && !teacherDetails.getAssignments().isEmpty()) {
            existingTeacher.setAssignments(teacherDetails.getAssignments());
        }
        if (teacherDetails.getQuizzes() != null && !teacherDetails.getQuizzes().isEmpty()) {
            existingTeacher.setQuizzes(teacherDetails.getQuizzes());
        }
        if (teacherDetails.getFeedbacks() != null && !teacherDetails.getFeedbacks().isEmpty()) {
            existingTeacher.setFeedbacks(teacherDetails.getFeedbacks());
        }

        // Update metadata
        existingTeacher.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        if (teacherDetails.getName() != null) {
            existingTeacher.setUpdatedBy(teacherDetails.getName());
        }

        return teacherRepository.save(existingTeacher);
    }


    /**
     * Assigns a course to a teacher.
     *
     * @param teacherId the ID of the teacher
     * @param courseId  the ID of the course to be assigned
     * @throws ResourceNotFoundException if the teacher or course does not exist
     */
    public void assignCourseToTeacher(Long teacherId, Long courseId) {
        Teacher teacher = findTeacherById(teacherId);
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));

        Set<Course> courses = teacher.getCourses();
        courses.add(course);
        teacher.setCourses(courses);
        teacherRepository.save(teacher);
    }

	public List<Teacher> getAllAdmins() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

	public Object findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
