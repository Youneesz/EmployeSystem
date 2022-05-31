package com.sfeproject.employesystem;

import com.sfeproject.employesystem.repository.EmployeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = EmployeRepository.class)
public class EmployesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployesystemApplication.class, args);
	}

}
