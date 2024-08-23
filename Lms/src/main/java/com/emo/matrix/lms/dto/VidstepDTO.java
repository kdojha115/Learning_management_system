package com.emo.matrix.lms.dto;

import java.time.LocalDateTime;

public class VidstepDTO {

    private Long id;
    private String title;
    private String videoFileUrl; // URL or path to the video file
    private String course; // ID or name of the course this Vidstep is associated with
    private String createdBy; // ID or name of the Admin or Teacher who created this Vidstep
    private String updatedBy; // ID or name of the Admin or Teacher who last updated this Vidstep
    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated
    private Integer sequence; // Sequence to maintain the order of Vidsteps

    // Default constructor
    public VidstepDTO() {
    }

    // Constructor with fields
    public VidstepDTO(Long id, String title, String videoFileUrl, String course, String createdBy, String updatedBy,
                      LocalDateTime createdAt, LocalDateTime updatedAt, Integer sequence) {
        this.id = id;
        this.title = title;
        this.videoFileUrl = videoFileUrl;
        this.course = course;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.sequence = sequence;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoFileUrl() {
        return videoFileUrl;
    }

    public void setVideoFileUrl(String videoFileUrl) {
        this.videoFileUrl = videoFileUrl;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
