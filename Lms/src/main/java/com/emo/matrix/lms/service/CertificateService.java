package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Certificate;
import com.emo.matrix.lms.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    // Create a new Certificate
    public Certificate createCertificate(Certificate certificate) {
        certificate.setCreatedAt(LocalDateTime.now());
        return certificateRepository.save(certificate);
    }

    // Get all Certificates
    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    // Get Certificate by ID
    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    // Get Certificates by Student ID
    public List<Certificate> getCertificatesByStudentId(Long studentId) {
        return certificateRepository.findByStudentId(studentId);
    }

    // Get Certificates by Course ID
    public List<Certificate> getCertificatesByCourseId(Long courseId) {
        return certificateRepository.findByCourseId(courseId);
    }

    // Update an existing Certificate
    public Certificate updateCertificate(Long id, Certificate updatedCertificate) {
        return certificateRepository.findById(id).map(existingCertificate -> {
            existingCertificate.setStudent(updatedCertificate.getStudent());
            existingCertificate.setCourse(updatedCertificate.getCourse());
            existingCertificate.setIssueDate(updatedCertificate.getIssueDate());
            existingCertificate.setFileUrl(updatedCertificate.getFileUrl());
            existingCertificate.setCreatedBy(updatedCertificate.getCreatedBy());
            existingCertificate.setCreatedAt(LocalDateTime.now());
            return certificateRepository.save(existingCertificate);
        }).orElseThrow(() -> new RuntimeException("Certificate not found with id: " + id));
    }

    // Delete a Certificate by ID
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}
