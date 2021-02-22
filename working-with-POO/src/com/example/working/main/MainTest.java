package com.example.working.main;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Scanner;

import com.example.working.service.PooService;

public class MainTest {
	private static Scanner scanner;
	private static PooService service;

	/* Método Main */
	public static void main(String[] args) {
		/* Instancia de servicio con constructor por defecto */
		service = new PooService();

		/* First exercise, Hello world! */
		// System.out.println("Hola mundo!");

		/* Second exercise, Basic loops */
		// service.basicLoops();

		/* Third exercise, Patterns */
		// service.patternExercise();

		/* Fourth exercise, Create new object with constructor method */
		// service.instanceNewCar("414124-232", "141232-65");

		/* Fifth exercise, Create a Basic Calculator */
		// service.callResolveOperation();

		/* Sixth exercise, save the location of an object on a plane */
		// service.objectOrientationExercise();

		/* Seventh exercise, maintenance of cars with sorting */
		// service.carMaintenance();

		/*
		 * Eighth exercise, abstract classes and polymorphism
		 */
		// service.alternateBasicPolygonSolver();
//		try {
//			File file = new File("C:/Prueba/texto.txt");
//			scanner = new Scanner(file);
//			while (scanner.hasNextLine()) {
//				System.out.println(scanner.nextLine().trim());
//			}
//			scanner.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("An error has occurred, cause: " + e.getMessage());
//		} finally {
//			scanner.close();
//			System.out.println("Proceso concluido");
//		}
		
		File file = new File("./test.pdf");

	    try ( FileOutputStream fos = new FileOutputStream(file); ) {
	      // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
	      String b64 = "JVBERi0xLjQKJeLjz9MKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvTGVuZ3RoIDI5Pj5zdHJlYW0KeJwr5HIK4TI2U7AwMFMISeFyDeEK5OICADEzBC0KZW5kc3RyZWFtCmVuZG9iagozIDAgb2JqCjw8L1RhYnMvUy9Hcm91cDw8L1MvVHJhbnNwYXJlbmN5L1R5cGUvR3JvdXAvQ1MvRGV2aWNlUkdCPj4vQ29udGVudHMgMSAwIFIvVHlwZS9QYWdlL1Jlc291cmNlczw8L0NvbG9yU3BhY2U8PC9DUy9EZXZpY2VSR0I+Pi9Qcm9jU2V0IFsvUERGIC9UZXh0IC9JbWFnZUIgL0ltYWdlQyAvSW1hZ2VJXT4+L1BhcmVudCAyIDAgUi9NZWRpYUJveFswIDAgNTk1IDg0Ml0+PgplbmRvYmoKMiAwIG9iago8PC9LaWRzWzMgMCBSXS9UeXBlL1BhZ2VzL0NvdW50IDEvSVRYVCgyLjEuNyk+PgplbmRvYmoKNCAwIG9iago8PC9UeXBlL0NhdGFsb2cvUGFnZXMgMiAwIFIvVmlld2VyUHJlZmVyZW5jZXM8PC9QcmludFNjYWxpbmcvQXBwRGVmYXVsdD4+Pj4KZW5kb2JqCjUgMCBvYmoKPDwvTW9kRGF0ZShEOjIwMjEwMjIwMTg1MzA4WikvQ3JlYXRvcihKYXNwZXJSZXBvcnRzIExpYnJhcnkgdmVyc2lvbiA2LjMuMSkvQ3JlYXRpb25EYXRlKEQ6MjAyMTAyMjAxODUzMDhaKS9Qcm9kdWNlcihpVGV4dCAyLjEuNyBieSAxVDNYVCk+PgplbmRvYmoKeHJlZgowIDYKMDAwMDAwMDAwMCA2NTUzNSBmIAowMDAwMDAwMDE1IDAwMDAwIG4gCjAwMDAwMDAzMzMgMDAwMDAgbiAKMDAwMDAwMDExMCAwMDAwMCBuIAowMDAwMDAwMzk2IDAwMDAwIG4gCjAwMDAwMDA0ODcgMDAwMDAgbiAKdHJhaWxlcgo8PC9JbmZvIDUgMCBSL0lEIFs8ZjIxMjRmZmQ1MzhiZTg4YWJhZWFiMTdiZGRmNDBlOWY+PGUwNDcyZGFiMzVkZTc0MTgwZDZmNGU1YmM3NjMwOTdlPl0vUm9vdCA0IDAgUi9TaXplIDY+PgpzdGFydHhyZWYKNjQyCiUlRU9GCg==";
	      byte[] decoder = Base64.getDecoder().decode(b64);
	      fos.write(decoder);
	      System.out.println("PDF File Saved");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

	}
}
