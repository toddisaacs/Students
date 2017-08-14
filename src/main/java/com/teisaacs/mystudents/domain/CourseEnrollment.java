/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author teisaacs
 */
@Entity
@Table(name = "COURSEENROLLMENT")
public class CourseEnrollment implements Serializable {
    @Id
    @Column(name = "COURSEENROLLMENTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @ManyToOne
    @JoinColumn(name="STUDENTID")
    @JsonBackReference("student")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name="COURSESESSIONID")
    @JsonBackReference("sessions")
    private CourseSession courseSession;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the courseSession
     */
    public CourseSession getCourseSession() {
        return courseSession;
    }

    /**
     * @param courseSession the courseSession to set
     */
    public void setCourseSession(CourseSession courseSession) {
        this.courseSession = courseSession;
    }
    
   
    
}
