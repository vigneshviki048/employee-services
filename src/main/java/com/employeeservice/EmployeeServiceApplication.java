package com.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = "com.employeeservices.*")
@EnableJpaRepositories
@Slf4j
public class EmployeeServiceApplication {

	private static final long msTosec=1000;
	
	public static void main(String[] args) {
		
		long start=System.currentTimeMillis();
		SpringApplication app=new SpringApplication(EmployeeServiceApplication.class);
		Environment env=app.run(args).getEnvironment();
		
		long end=System.currentTimeMillis();
		log.info("\n\n******************EMPLOYEE SERVICES APPLICATION SUCCESSFULLY STARTED*******************************"
				+ env.getProperty("spring.application.name"),env.getActiveProfiles(),((end-start)/msTosec));
	}

}
