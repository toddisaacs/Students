/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teisaacs.mystudents.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author teisaacs
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @Column(name = "STUDENTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRSTNAME")
    @Size(max = 50)
    private String firstName;

    @Column(name = "MIDDLENAME")
    @Size(max = 50)
    private String middleName;

    @Column(name = "LASTNAME", nullable = false)
    @Size(max = 50)
    @NotBlank
    private String lastName;

    @Column(name = "ADDRESS", nullable = false)
    @Size(max = 100)
    @NotBlank
    private String address;

    @Column(name = "ADDRESS2")
    @Size(max = 100)
    private String address2;

    @Column(name = "CITY", nullable = false)
    @NotBlank
    @Size(max = 100)
    private String city;

    @Column(name = "STATECODE", nullable = false)
    @Size(max = 2)
    @NotBlank
    private String statecode;

    @Column(name = "ZIPCODE", nullable = false)
    @Size(max = 7)
    @NotBlank
    private String zipcode;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")
    @JsonManagedReference("student")
    private List<CourseEnrollment> courseEnrollments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the statecode
     */
    public String getStatecode() {
        return statecode;
    }

    /**
     * @param statecode the statecode to set
     */
    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
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

}
