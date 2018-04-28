package com.ben.springdata_h2_poc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class Application {
	@Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println(" ********************************************** ");
        System.out.println(" ************ MY SPRING DATA POC STARTED  ************* ");
        System.out.println(" ********************************************** ");
	}
	

	
}
