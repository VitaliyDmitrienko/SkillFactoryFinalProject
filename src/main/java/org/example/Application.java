package org.example;

import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		UserRepository userRepository = new UserRepository() {
//		UserService userService = new UserService (userRepository);
//		userService = new UserService();

//		System.out.println(userService.getBalance(1));
	}

}
