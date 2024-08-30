package com.emo.matrix.lms.service;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.models.*;
import com.emo.matrix.lms.repository.*;
import com.emo.matrix.lms.utils.CourseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final AdminRepository adminRepository;
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;
    private final VidstepRepository vidstepRepository;
    private final AssignmentRepository assignmentRepository;
    private final QuizRepository quizRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository,
                         AdminRepository adminRepository, TeacherRepository teacherRepository,
                         DepartmentRepository departmentRepository, VidstepRepository vidstepRepository,
                         AssignmentRepository assignmentRepository, QuizRepository quizRepository,
                         EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
        this.vidstepRepository = vidstepRepository;
        this.assignmentRepository = assignmentRepository;
        this.quizRepository = quizRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    // Method to create a new course
    public Course createCourse(Course course, Long adminId) {
    	
        Optional<Admin> admin = adminRepository.findById(adminId);
        if(adminId != null) {
        	Admin a = admin.get();
        	course.setAdmin(a);
        	course.setPrivate(true);
        	course.setPaid(true);
        	course.setCreatedBy(a.getName());
        }
        
        return courseRepository.save(course);
    }

    // Method to update an existing course
//    public CourseDTO updateCourse(Long courseId, CourseDTO updatedCourseDTO) {
//        Optional<Course> courseOptional = courseRepository.findById(courseId);
//        if (courseOptional.isPresent()) {
//            Course course = courseOptional.get();
//            Teacher teacher = teacherRepository.findById(Long.parseLong(updatedCourseDTO.getTeacherId())).orElse(null);
//            Department department = departmentRepository.findById(Long.parseLong(updatedCourseDTO.getDepartmentId())).orElse(null);
//            Set<Vidstep> vidsteps = vidstepRepository.findAllByIdIn(updatedCourseDTO.getVidstepIds());
//            Set<Assignment> assignments = assignmentRepository.findAllByIdIn(updatedCourseDTO.getAssignmentIds());
//            Set<Quiz> quizzes = quizRepository.findAllByIdIn(updatedCourseDTO.getQuizIds());
//            Set<Enrollment> enrollments = enrollmentRepository.findAllByIdIn(updatedCourseDTO.getEnrollmentIds());
//            Set<Student> students = studentRepository.findAllByIdIn(updatedCourseDTO.getStudentIds());
//
//            course.setTitle(updatedCourseDTO.getTitle());
//            course.setDescription(updatedCourseDTO.getDescription());
//            course.setTeacher(teacher);
//            course.setPrivate(updatedCourseDTO.isPrivate());
//            course.setPaid(updatedCourseDTO.isPaid());
//            course.setDepartment(department);
//            course.setVidsteps(vidsteps);
//            course.setAssignments(assignments);
//            course.setQuizzes(quizzes);
//            course.setEnrollments(enrollments);
//            course.setStudents(students);
//
//            Course savedCourse = courseRepository.save(course);
//            return CourseUtil.toDTO(savedCourse);
//        } else {
//            throw new RuntimeException("Course not found with id: " + courseId);
//        }
//    }

    // Method to get all courses
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseUtil::toDTO).collect(Collectors.toList());
    }

    // Method to get a course by ID
    public Optional<CourseDTO> getCourseById(Long courseId) {
        return courseRepository.findById(courseId).map(CourseUtil::toDTO);
    }

    // Method to delete a course by ID
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    // Method to get courses by a student's ID
    public List<CourseDTO> getCoursesByStudentId(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return student.getCourses().stream().map(CourseUtil::toDTO).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Student not found with id: " + studentId);
        }
    }

    // Method to enroll a student in a course
    public CourseDTO enrollStudentInCourse(Long courseId, Long studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            Student student = studentOptional.get();

            course.getStudents().add(student);
            student.getCourses().add(course);

            courseRepository.save(course);
            studentRepository.save(student);

            return CourseUtil.toDTO(course);
        } else {
            throw new RuntimeException("Course or Student not found with given IDs");
        }
    }

    // Method to remove a student from a course
    public CourseDTO removeStudentFromCourse(Long courseId, Long studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (courseOptional.isPresent() && studentOptional.isPresent()) {
            Course course = courseOptional.get();
            Student student = studentOptional.get();

            course.getStudents().remove(student);
            student.getCourses().remove(course);

            courseRepository.save(course);
            studentRepository.save(student);

            return CourseUtil.toDTO(course);
        } else {
            throw new RuntimeException("Course or Student not found with given IDs");
        }
    }

    public void save(Course video) {
        courseRepository.save(video);
    }

    public Course uploadVideo(Long id, MultipartFile file) throws Exception {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isEmpty()) {
            throw new RuntimeException("Course not found with given ID");
        }

        Course course = optionalCourse.get();
        try {
            // Set the video file as bytes (consider handling large files differently)
            course.setVideoFiles(file.getBytes());
            courseRepository.save(course);
            return course;
        } catch (IOException e) {
            // Log and rethrow the exception
            throw new Exception("Failed to save video file", e);
        }
    }

	
}
