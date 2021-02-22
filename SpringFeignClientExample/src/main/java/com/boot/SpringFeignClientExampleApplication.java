package com.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringFeignClientExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringFeignClientExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicio");

	}
}
