package com.reports.example.reporter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.reports.example.reporter.service.ReportService;

@SpringBootApplication
public class ReporterApplication implements CommandLineRunner {

	private static ReportService service = new ReportService();

	public static void main(String[] args) {
		SpringApplication.run(ReporterApplication.class, args);
		try {
			service.generateReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Services" + System.lineSeparator() + "are running");

	}

}
