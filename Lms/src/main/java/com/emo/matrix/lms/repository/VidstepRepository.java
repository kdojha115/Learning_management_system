package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Vidstep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface VidstepRepository extends JpaRepository<Vidstep, Long> {
    List<Vidstep> findByCourseId(Long courseId);

	Set<Vidstep> findAllByIdIn(Set<String> vidsteps);

	Set<Vidstep> findAllByTitleIn(Set<String> vidsteps);
}
