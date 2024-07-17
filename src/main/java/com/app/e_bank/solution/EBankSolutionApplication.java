package com.app.e_bank.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.app.e_bank.solution.Repository")
public class EBankSolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankSolutionApplication.class, args);
	}

}
