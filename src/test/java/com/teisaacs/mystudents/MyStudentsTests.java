/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teisaacs.mystudents;

import com.teisaacs.mystudents.domain.Course;
import com.teisaacs.mystudents.domain.CourseEnrollment;
import com.teisaacs.mystudents.domain.CourseSession;
import com.teisaacs.mystudents.domain.Instructor;
import com.teisaacs.mystudents.domain.Student;
import com.teisaacs.mystudents.repositories.CourseEnrollmentRepository;
import com.teisaacs.mystudents.repositories.CourseRepository;
import com.teisaacs.mystudents.repositories.CourseSessionRepository;
import com.teisaacs.mystudents.repositories.InstructorRepository;
import com.teisaacs.mystudents.repositories.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author teisaacs
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MyStudentsTests.class)
@EnableAutoConfiguration
@ComponentScan
@ActiveProfiles("test")
public class MyStudentsTests {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseSessionRepository courseSessionRepository;

    @Autowired
    private CourseEnrollmentRepository courseEnrollmentRepository;

    @Test
    public void testAddStudent() throws Exception {
        Student s = new Student();
        s.setFirstName("New");
        s.setLastName("Student");
        s.setAddress("Address");
        s.setCity("City");
        s.setStatecode("IN");
        s.setZipcode("12345");

        s = studentRepository.save(s);

        Assert.assertNotNull(s.getId());
    }

    @Test
    public void testAddInstructor() throws Exception {
        Instructor i = new Instructor();
        i.setFirstName("John");
        i.setMiddleName("A");
        i.setLastName("Johnson");
        i.setTenured(Boolean.FALSE);

        i = instructorRepository.save(i);

        Assert.assertNotNull(i.getId());

        List<Student> students = studentRepository.findAll();
        System.out.println("students " + students.size());
    }

    @Test
    public void testAddCourse() throws Exception {
        Course c = new Course();
        c.setShortDesc("TEST");
        c.setSummary("Testing Summary");

        c = courseRepository.save(c);
        Assert.assertNotNull(c.getId());
    }

    @Test
    public void testAddCourseSession() throws Exception {
        Course c = MyStudentsTests.createCourse();
        c = courseRepository.save(c);

        Instructor i = MyStudentsTests.createInstructor();
        i = instructorRepository.save(i);

        CourseSession courseSession = new CourseSession();

        courseSession.setCourse(c);
        courseSession.setInstructor(i);
        courseSession = courseSessionRepository.save(courseSession);

        Assert.assertNotNull(courseSession.getId());
    }

    @Test
    public void testAddCourseEnrollment() throws Exception {
        Long studentID;

        Course c = MyStudentsTests.createCourse();
        courseRepository.save(c);

        Instructor i = MyStudentsTests.createInstructor();
        instructorRepository.save(i);

        CourseSession courseSession = new CourseSession();

        courseSession.setCourse(c);
        courseSession.setInstructor(i);
        courseSession = courseSessionRepository.save(courseSession);
        Assert.assertNotNull(courseSession.getId());

        Student s = MyStudentsTests.createStudent();
        studentRepository.save(s);
        studentID = s.getId();

        Assert.assertNotNull(studentID);

        List<CourseEnrollment> enrollmentList = new ArrayList<CourseEnrollment>();

        CourseEnrollment e = new CourseEnrollment();
        e.setStudent(s);
        e.setCourseSession(courseSession);
        courseEnrollmentRepository.save(e);

        Assert.assertNotNull(e.getId());

        enrollmentList.add(e);

        s.setCourseEnrollments(enrollmentList);
        studentRepository.save(s);

        courseSession.setCourseEnrollments(enrollmentList);
        courseSessionRepository.save(courseSession);

        //clear session
        this.studentRepository.flush();

        Student fetchedStudent = studentRepository.findOne(studentID);
        Assert.assertNotNull(fetchedStudent.getCourseEnrollments());

        studentRepository.delete(fetchedStudent);

        List<CourseEnrollment> enrollments = courseEnrollmentRepository.findAll();
        Assert.assertEquals(0, enrollments.size());
    }

    protected static Student createStudent() {
        Student s = new Student();
        s.setFirstName("New");
        s.setLastName("Student");
        s.setAddress("Address");
        s.setCity("City");
        s.setStatecode("IN");
        s.setZipcode("12345");

        return s;
    }

    protected static Course createCourse() {
        Course c = new Course();
        c.setShortDesc("TEST");
        c.setSummary("Testing Summary");

        return c;
    }

    protected static Instructor createInstructor() {
        Instructor i = new Instructor();
        i.setFirstName("John");
        i.setMiddleName("A");
        i.setLastName("Johnson");
        i.setTenured(Boolean.FALSE);

        return i;
    }

}
