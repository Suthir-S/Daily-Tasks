package com.quinbay.wholesaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableJpaRepositories("com.quinbay.wholesaler.repository")

@Service
public class WholesalerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WholesalerApplication.class, args);
	}

}
