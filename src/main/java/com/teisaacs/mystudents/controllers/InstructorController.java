/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.controllers;

import com.teisaacs.mystudents.domain.Instructor;
import com.teisaacs.mystudents.repositories.InstructorRepository;
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
public class InstructorController {
    private final InstructorRepository instructorRepository;
    
    @Autowired
    public InstructorController(final InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    
    @RequestMapping(value="/api/instructors", method=RequestMethod.GET )
    public List<Instructor> getInstructors() {
        List<Instructor> instructors = instructorRepository.findAll();

        return instructors;
    }
}
