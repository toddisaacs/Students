/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.repositories;

import com.teisaacs.mystudents.domain.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author teisaacs
 */
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    
}
