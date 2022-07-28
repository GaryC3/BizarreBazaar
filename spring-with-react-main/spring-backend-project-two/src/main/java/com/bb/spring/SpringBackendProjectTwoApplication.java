package com.skillstorm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.skillstorm.spring.models.User;
import com.skillstorm.spring.repositories.UserRepository;

@SpringBootApplication
public class SpringBackendProjectTwoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// Application Context
		SpringApplication.run(SpringBackendProjectTwoApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	// CommandLineRunner provides a run method to run in our Tomcat embedded server
	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Bobby", "Boucher"));
		userRepository.save(new User("Daffy", "Duck"));
		userRepository.save(new User("Tommy", "Hilfiger"));
		userRepository.save(new User("Mike", "Wazowski"));
	}

}
