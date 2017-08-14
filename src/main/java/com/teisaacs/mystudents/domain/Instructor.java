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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author teisaacs
 */
@Entity
@Table(name = "INSTRUCTOR")
public class Instructor implements Serializable {
    
    @Id
    @Column(name = "INSTRUCTORID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "FIRSTNAME")
    private String firstName;
    
    @Column(name = "MIDDLENAME")
    private String middleName;
    
    @Column(name = "LASTNAME")
    private String lastName;
    
    @Column(name = "TENURED", columnDefinition = "SMALLINT", length = 1)
    private Boolean tenured;
    
    @OneToMany
    @JoinColumn(name="INSTRUCTORID", referencedColumnName="INSTRUCTORID")
    @JsonManagedReference
    private List<CourseSession> courseSessions;

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
     * @return the tenured
     */
    public Boolean getTenured() {
        return tenured;
    }

    /**
     * @param tenured the tenured to set
     */
    public void setTenured(Boolean tenured) {
        this.tenured = tenured;
    }
}
