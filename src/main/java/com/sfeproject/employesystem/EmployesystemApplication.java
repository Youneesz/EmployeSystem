package com.sfeproject.employesystem;

import com.sfeproject.employesystem.repository.EmployeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories(basePackageClasses = EmployeRepository.class)
public class EmployesystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployesystemApplication.class, args);
	}

}
