/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.controllers;

import com.teisaacs.mystudents.domain.Course;
import com.teisaacs.mystudents.repositories.CourseRepository;
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
public class CourseController {
    
  
    private final CourseRepository courseRepository;
    
    @Autowired
    public CourseController(final CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    @RequestMapping(value="/api/courses", method=RequestMethod.GET )
    public List<Course> getCourses() {
        List<Course> courses = courseRepository.findAll();

        return courses;
    }
}
