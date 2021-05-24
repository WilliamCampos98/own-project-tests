package com.project.portfolio.academicchargecontrolws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcademicChargeControlWsApplication implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(AcademicChargeControlWsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Application is running");
	}
}
