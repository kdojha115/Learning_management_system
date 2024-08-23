package com.emo.matrix.lms.repository;

import com.emo.matrix.lms.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<Certificate> findByStudentId(Long studentId);

	List<Certificate> findByCourseId(Long courseId);
}
