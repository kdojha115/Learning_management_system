package com.emo.matrix.lms.controller;

import com.emo.matrix.lms.models.Vidstep;
import com.emo.matrix.lms.service.VidstepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vidstep")
public class VidstepController {

    @Autowired
    private VidstepService vidstepService;

    // Create a new Vidstep
    @PostMapping("/create")
    public ResponseEntity<Vidstep> createVidstep(@RequestBody Vidstep vidstep) {
        Vidstep createdVidstep = vidstepService.createVidstep(vidstep);
        return ResponseEntity.ok(createdVidstep);
    }

    // Get all Vidsteps
    @GetMapping("/")
    public ResponseEntity<List<Vidstep>> getAllVidsteps() {
        List<Vidstep> vidsteps = vidstepService.getAllVidsteps();
        return ResponseEntity.ok(vidsteps);
    }

    // Get Vidsteps by Course ID
    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Vidstep>> getVidstepsByCourseId(@PathVariable Long courseId) {
        List<Vidstep> vidsteps = vidstepService.getVidstepsByCourseId(courseId);
        return ResponseEntity.ok(vidsteps);
    }

    // Get a specific Vidstep by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vidstep> getVidstepById(@PathVariable Long id) {
        Optional<Vidstep> vidstep = vidstepService.getVidstepById(id);
        return vidstep.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing Vidstep
    @PutMapping("/{id}")
    public ResponseEntity<Vidstep> updateVidstep(@PathVariable Long id, @RequestBody Vidstep vidstepDetails) {
        try {
            Vidstep updatedVidstep = vidstepService.updateVidstep(id, vidstepDetails);
            return ResponseEntity.ok(updatedVidstep);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Vidstep by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVidstep(@PathVariable Long id) {
        try {
            vidstepService.deleteVidstep(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
