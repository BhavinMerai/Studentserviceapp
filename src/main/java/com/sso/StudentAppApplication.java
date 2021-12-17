package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.sso.controller, com.sso.service, " + "com.sso.security"})
@EntityScan("com.sso.entity")
@EnableJpaRepositories("com.sso.repository")
public class StudentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

}
