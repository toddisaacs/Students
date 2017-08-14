
package com.teisaacs.mystudents.controllers;

import com.teisaacs.mystudents.domain.Student;
import com.teisaacs.mystudents.repositories.StudentRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author teisaacs
 */
@RestController
public class StudentController {
    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentController(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @RequestMapping(value="/api/students", method=RequestMethod.GET )
    public List<Student> getSpeakers() {
        List<Student> students = studentRepository.findAll();
        return students;
    }
    
    @RequestMapping(value="/api/students/{id}", method=RequestMethod.GET )
    public Student getSpeaker( @PathVariable Long id) {
        Student student = studentRepository.findOne(id);
        return student;
    }
    
    @RequestMapping(value="/api/students", method = RequestMethod.POST) 
    public Student save(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }
    
    @RequestMapping(value="/api/students/{id}", method = RequestMethod.PUT) 
    public Student update( @PathVariable Long id, @RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }
    
    
    @RequestMapping(value="/api/students/{id}", method = RequestMethod.DELETE) 
    public void remove(@PathVariable("id") Long id) {
         studentRepository.delete(id);
    }
}
