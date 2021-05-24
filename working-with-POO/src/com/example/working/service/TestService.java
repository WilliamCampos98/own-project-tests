package com.example.working.service;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Scanner;

public class TestService {

	private File file;
	private FileOutputStream fos;
	private Scanner scanner;

	public void decodeBase64ndExport(String reportName, String reportExtension, String report) {
		try {
			file = new File(reportName
					+ new SimpleDateFormat("dd-MM-yyyy HH-mm").format(new Date()).concat("." + reportExtension));
			fos = new FileOutputStream(file);
			byte[] decoder = Base64.getDecoder().decode(report);
			fos.write(decoder);
			System.out.println("the file has been saved");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void readTxtDocument(String filePath) {
		try {
			File file = new File(filePath);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine().trim());
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("An error has occurred, cause: " + e.getMessage());
		} finally {
			scanner.close();
			System.out.println("Proceso concluido");
		}
	}

}
