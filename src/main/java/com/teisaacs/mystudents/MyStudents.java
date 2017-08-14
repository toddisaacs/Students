package com.teisaacs.mystudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author teisaacs
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories
@ComponentScan
public class MyStudents {
    
    /**
     * Application entry point, delegates to the SpringBoots's SpringApplication 
     * and will bootstrap the application using the auto configuration.
     * 
     * @param args     command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MyStudents.class, args);
    }
}
