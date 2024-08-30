package com.emo.matrix.lms.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course; // The course for which feedback is given

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher; // The teacher for which feedback is given

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // The student who provided the feedback

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Admin createdBy; // Admin who created this feedback

    private LocalDateTime createdAt; // Timestamp when the feedback was created

    @OneToMany(mappedBy = "feedback")
    private Set<FeedbackQuestion> feedbackQuestions; // Mapping to FeedbackQuestion table

    private int rating;// Rating given by the student
    
    private String content; // or other field name



    // Constructor with fields
    public Feedback(Long id, Course course, Teacher teacher, Student student, Admin createdBy, LocalDateTime createdAt, Set<FeedbackQuestion> feedbackQuestions, int rating,String content) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.student = student;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.feedbackQuestions = feedbackQuestions;
        this.rating = rating;
        this.content = content;
    }

    // Default Constructor
    public Feedback() {
    }

    // Getters and Setters
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Admin getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Admin createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<FeedbackQuestion> getFeedbackQuestions() {
        return feedbackQuestions;
    }

    public void setFeedbackQuestions(Set<FeedbackQuestion> feedbackQuestions) {
        this.feedbackQuestions = feedbackQuestions;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
