package com.example.miniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
@SpringBootApplication
public class CounsellorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounsellorApplication.class, args);
	}

}
