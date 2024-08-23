package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vidstep")
public class Vidstep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String videoFileUrl; // Option to upload video file

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin or Teacher who created this Vidstep

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private Admin updatedBy; // Admin or Teacher who last updated this Vidstep

    private LocalDateTime createdAt; // Timestamp when created
    private LocalDateTime updatedAt; // Timestamp when last updated

    private Integer sequence; // To maintain the sequence of Vidsteps
    
    
    // Constructor using field

    public Vidstep(Long id, String title, String videoFileUrl, Course course, Admin createdBy, Admin updatedBy,
			LocalDateTime createdAt, LocalDateTime updatedAt, Integer sequence) {
		super();
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public Admin getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Admin updatedBy) {
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
