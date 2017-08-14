/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teisaacs.mystudents.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author teisaacs
 */
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

    @Id
    @Column(name = "COURSEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COURSECODE")
    private String courseCode;

    @Column(name = "SHORTDESC")
    private String shortDesc;

    @Lob
    @Column(name = "SUMMARY", length = 64000)
    private String summary;
    
    
    @OneToMany
    @JoinColumn(name="COURSEID", referencedColumnName="COURSEID")
    @JsonManagedReference("course")
    private List<CourseSession> courseSessions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the courseCode
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * @param courseCode the courseCode to set
     */
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    /**
     * @return the shortDesc
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * @param shortDesc the shortDesc to set
     */
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @return the courses
     */
    public List<CourseSession> getCourses() {
        return courseSessions;
    }

    /**
     * @param courses the courses to set
     */
    public void setCourses(List<CourseSession> courseSessions) {
        this.courseSessions = courseSessions;
    }

}
