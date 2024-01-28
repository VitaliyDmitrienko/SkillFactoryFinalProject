package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		System.out.println("In case of Application run local, can see execute: http://localhost:8080/greeting");
		System.out.println("URI request syntax can access by: http://localhost:8080/swagger-ui/index.html#");
		System.out.println("API Docs can access by: http://localhost:8080/v3/api-docs");
	}

}
