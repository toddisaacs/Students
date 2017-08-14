/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teisaacs.mystudents.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author teisaacs
 */
@Entity
@Table(name = "COURSESESSION")
public class CourseSession implements Serializable {

    @Id
    @Column(name = "COURSESESSIONID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STARTDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;

    @Column(name = "ENDDATE")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "ONLINE", columnDefinition = "SMALLINT", length = 1)
    private Boolean online;
    
    @OneToMany
    @JoinColumn(name = "COURSESESSIONID", referencedColumnName = "COURSESESSIONID")
    @JsonManagedReference("sessions")
    private List<CourseEnrollment> courseEnrollments;
    
    @ManyToOne
    @JoinColumn(name="COURSEID")
    @JsonBackReference("course")
    private Course course;
    
    @ManyToOne
    @JoinColumn(name="INSTRUCTORID")
    @JsonBackReference
    private Instructor instructor;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

        /**
     * @return the courseEnrollments
     */
    public List<CourseEnrollment> getCourseEnrollments() {
        return courseEnrollments;
    }

    /**
     * @param courseEnrollments the courseEnrollments to set
     */
    public void setCourseEnrollments(List<CourseEnrollment> courseEnrollments) {
        this.courseEnrollments = courseEnrollments;
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the instructor
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     * @param instructor the instructor to set
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
