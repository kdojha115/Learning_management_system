package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.dto.CourseDTO;
import com.emo.matrix.lms.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTeacherId(Long teacherId);

	Course save(Course video);
}
