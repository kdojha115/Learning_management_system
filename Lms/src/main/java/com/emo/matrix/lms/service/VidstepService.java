package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Vidstep;
import com.emo.matrix.lms.repository.VidstepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VidstepService {

    private final VidstepRepository vidstepRepository;

    @Autowired
    public VidstepService(VidstepRepository vidstepRepository) {
        this.vidstepRepository = vidstepRepository;
    }

    // Create a new Vidstep
    public Vidstep createVidstep(Vidstep vidstep) {
        return vidstepRepository.save(vidstep);
    }

    // Get all Vidsteps
    public List<Vidstep> getAllVidsteps() {
        return vidstepRepository.findAll();
    }

    // Get Vidsteps by Course ID
    public List<Vidstep> getVidstepsByCourseId(Long courseId) {
        return vidstepRepository.findByCourseId(courseId);
    }

    // Get a specific Vidstep by ID
    public Optional<Vidstep> getVidstepById(Long vidstepId) {
        return vidstepRepository.findById(vidstepId);
    }

    // Update an existing Vidstep
    public Vidstep updateVidstep(Long vidstepId, Vidstep vidstepDetails) {
        Optional<Vidstep> vidstepOptional = vidstepRepository.findById(vidstepId);

        if (vidstepOptional.isPresent()) {
            Vidstep vidstep = vidstepOptional.get();
            vidstep.setTitle(vidstepDetails.getTitle());
            vidstep.setVideoFileUrl(vidstepDetails.getVideoFileUrl());
            vidstep.setCourse(vidstepDetails.getCourse());
            return vidstepRepository.save(vidstep);
        } else {
            throw new RuntimeException("Vidstep not found");
        }
    }

    // Delete a Vidstep by ID
    public void deleteVidstep(Long vidstepId) {
        vidstepRepository.deleteById(vidstepId);
    }
}
