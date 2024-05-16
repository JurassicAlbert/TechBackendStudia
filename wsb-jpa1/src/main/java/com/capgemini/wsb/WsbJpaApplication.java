package com.capgemini.wsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.capgemini.wsb.persistence.dao")
public class WsbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbJpaApplication.class, args);
	}
}
