package com.example.InnDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableScheduling
public class InnDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnDbApplication.class, args);
	}

}
