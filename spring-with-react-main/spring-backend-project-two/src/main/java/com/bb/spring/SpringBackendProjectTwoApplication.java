package com.bb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bb.spring.repositories.UserRepository;

@SpringBootApplication
@ComponentScan("com.bb.spring")
@Configuration
@EnableAutoConfiguration
public class SpringBackendProjectTwoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// Application Context
		SpringApplication.run(SpringBackendProjectTwoApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //10 salt
	}

	@Autowired
	UserRepository userRepository;

	// CommandLineRunner provides a run method to run in our Tomcat embedded server
	@Override
	public void run(String... args) throws Exception {
//		userRepository.save(new User("Bobby", "Boucher"));
//		userRepository.save(new User("Daffy", "Duck"));
//		userRepository.save(new User("Tommy", "Hilfiger"));
//		userRepository.save(new User("Mike", "Wazowski"));
	}

}
