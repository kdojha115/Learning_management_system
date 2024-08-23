package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Vidstep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VidstepRepository extends JpaRepository<Vidstep, Long> {
    List<Vidstep> findByCourseId(Long courseId);
}
