/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.controllers;

import com.teisaacs.mystudents.domain.CourseSession;
import com.teisaacs.mystudents.repositories.CourseSessionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author teisaacs
 */
@RestController
public class CourseSessionController {
    private final CourseSessionRepository courseSessionRepository;
    
    @Autowired
    public CourseSessionController(final CourseSessionRepository courseSessionRepository) {
        this.courseSessionRepository = courseSessionRepository;
    }
    
    @RequestMapping(value="/api/courseSessions", method=RequestMethod.GET )
    public List<CourseSession> getCourseSessions() {
        List<CourseSession> courseSessions = courseSessionRepository.findAll();

        return courseSessions;
    }
}
