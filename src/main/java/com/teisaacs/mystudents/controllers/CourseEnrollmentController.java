/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.controllers;

import com.teisaacs.mystudents.domain.CourseEnrollment;
import com.teisaacs.mystudents.repositories.CourseEnrollmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author teisaacs
 */
public class CourseEnrollmentController {
    private final CourseEnrollmentRepository courseEnrollmentRepository;
    
    @Autowired
    public CourseEnrollmentController(final CourseEnrollmentRepository courseEnrollmentRepository) {
        this.courseEnrollmentRepository = courseEnrollmentRepository;
    }
    
    @RequestMapping(value="/api/courseEnrollments", method=RequestMethod.GET )
    public List<CourseEnrollment> getCourseSessions() {
        List<CourseEnrollment> enrollments = courseEnrollmentRepository.findAll();

        return enrollments;
    }
}
