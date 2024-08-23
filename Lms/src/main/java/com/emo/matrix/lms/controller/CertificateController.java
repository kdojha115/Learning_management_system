package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Certificate;
import com.emo.matrix.lms.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // Create a new Certificate
    @PostMapping("/")
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate) {
        Certificate createdCertificate = certificateService.createCertificate(certificate);
        return ResponseEntity.ok(createdCertificate);
    }

    // Get all Certificates
    @GetMapping("/")
    public ResponseEntity<List<Certificate>> getAllCertificates() {
        List<Certificate> certificates = certificateService.getAllCertificates();
        return ResponseEntity.ok(certificates);
    }

    // Get Certificate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        Optional<Certificate> certificate = certificateService.getCertificateById(id);
        return certificate.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get Certificates by Student ID
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Certificate>> getCertificatesByStudentId(@PathVariable Long studentId) {
        List<Certificate> certificates = certificateService.getCertificatesByStudentId(studentId);
        return ResponseEntity.ok(certificates);
    }

    // Get Certificates by Course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Certificate>> getCertificatesByCourseId(@PathVariable Long courseId) {
        List<Certificate> certificates = certificateService.getCertificatesByCourseId(courseId);
        return ResponseEntity.ok(certificates);
    }

    // Update an existing Certificate
    @PutMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable Long id, @RequestBody Certificate updatedCertificate) {
        try {
            Certificate certificate = certificateService.updateCertificate(id, updatedCertificate);
            return ResponseEntity.ok(certificate);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Certificate by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
        return ResponseEntity.noContent().build();
    }
}
