/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.teisaacs.mystudents.repositories;

import com.teisaacs.mystudents.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring creates an implementation of this interface.
 * @author teisaacs
 */
public interface StudentRepository extends JpaRepository<Student, Long>  {
    
}
