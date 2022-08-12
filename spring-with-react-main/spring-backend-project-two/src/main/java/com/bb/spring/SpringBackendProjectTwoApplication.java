package com.bb.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bb.spring.beans.User;
import com.bb.spring.repositories.UserRepository;

@SpringBootApplication
public class SpringBackendProjectTwoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// Application Context
		SpringApplication.run(SpringBackendProjectTwoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
