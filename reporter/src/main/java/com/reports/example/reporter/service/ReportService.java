package com.reports.example.reporter.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.reports.example.reporter.dto.Car;
import com.reports.example.reporter.dto.Person;
import com.reports.example.reporter.dto.ReportDTO;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {
	private static String url = "https://www.transparenciaactiva.gob.sv/system/covers/images/000/008/950/large/logo.png?1554919365";
	public static Logger log = LoggerFactory.getLogger(ReportService.class);
	private List<Person> persons;
	private List<Car> cars;

	public List<Person> getPersons() {
		persons = new ArrayList<>();
		persons.add(new Person(1, "William", "Campos", 22, 1.74));
		persons.add(new Person(2, "Carlos", "Ramirez", 32, 1.64));
		persons.add(new Person(3, "Juan", "Ortega", 22, 1.84));
		return persons;
	}

	public List<Car> getCars() {
		cars = new ArrayList<>();
		cars.add(new Car(1, "Red", "Toyota", 2340.23, 0.00));
		cars.add(new Car(2, "Red", "Truck", 4342.23, 0.00));
		cars.add(new Car(3, "Blue", "Mitsubishi", 4567.23, 123.00));
		cars.add(new Car(4, "Blue", "Tsuru", 867.23, 33.00));
		cars.add(new Car(5, "Yellow", "Lamborghini", 2340.23, 353.00));
		cars.add(new Car(6, "Yellow", "Lamborghini Gallardo", 3456.23, 333.00));
		return cars;
	}

	public static InputStream generateBarCode() {
		try {
			BitMatrix bitMatrix;
			Writer writer = new QRCodeWriter();
			/*
			 * bitMatrix = writer.encode(url, BarcodeFormat.QR_CODE, 200, 200);
			 * MatrixToImageWriter.writeToStream(bitMatrix, "png", new FileOutputStream(new
			 * File("c:/Prueba/QR.png"))); System.out.println("Completado QR");
			 */

			System.out.println("Completado PDF417");

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			writer = new PDF417Writer();
			bitMatrix = writer.encode("OK MAÑANA LO HAGO", BarcodeFormat.PDF_417, 300, 100);
			MatrixToImageWriter.writeToStream(bitMatrix, "png", stream);
			System.out.println("Completado QR");
			System.out.println("Completado PDF417");
			InputStream input = new ByteArrayInputStream(stream.toByteArray());
			return input;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void generateReport() {
		try {
			String reportPath = "src/main/reportes/report-example.jasper";
			String imagesPath = "src/main/imagenes/";
			ReportDTO report = new ReportDTO("Reporte Test Jasper", new Date(), this.getCars(), this.getPersons());
			List<ReportDTO> reports = new ArrayList<ReportDTO>();
			reports.add(report);
			JRBeanCollectionDataSource beanCollection = new JRBeanCollectionDataSource(reports);
			// Para crear un archivo local de prueba
			File file = new File("reporte.pdf");
			InputStream input = new FileInputStream(new File(reportPath));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("imagesPath", imagesPath);
			map.put("barCode", ReportService.generateBarCode());
			JasperPrint jp = JasperFillManager.fillReport(reportPath, map, beanCollection);
			byte[] bytes = JasperExportManager.exportReportToPdf(jp);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(bytes);
			fos.close();
		} catch (Exception e) {
			log.info("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
