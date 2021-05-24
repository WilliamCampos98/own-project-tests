package com.example.working.main;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.example.working.entities.Car;
import com.example.working.service.PooService;
import com.example.working.service.TestService;

public class MainTest {
	private static PooService pooService;
	private static TestService testService;

	public static void compareClass(Class<?> clase) {
		if (clase.equals(Car.class)) {
			System.out.println("Son iguales");
		} else {
			System.out.println("No lo son");
		}
	}

	/* Método Main */
	public static void main(String[] args) {
		/* Instancia de servicio con constructor por defecto */
		pooService = new PooService();
		testService = new TestService();
		/* First exercise, Hello world! */
		// System.out.println("Hola mundo!");

		/* Second exercise, Basic loops */
		// pooService.basicLoops();

		/* Third exercise, Patterns */
		pooService.patternExercise();

		/* Fourth exercise, Create new object with constructor method */
		// pooService.instanceNewCar("414124-232", "141232-65");

		/* Fifth exercise, Create a Basic Calculator */
		// pooService.callResolveOperation();

		/* Sixth exercise, save the location of an object on a plane */
		// pooService.objectOrientationExercise();

		/* Seventh exercise, maintenance of cars with sorting */
		// pooService.carMaintenance();

		/*
		 * Eighth exercise, abstract classes and polymorphism
		 */
		// pooService.alternateBasicPolygonSolver();

		/* Decode bas64 and save file */
		// testService.decodeBase64ndExport("Reporte", "pdf", "base64");

		/* Class comparator */
		// compareClass(Car.class);

	}
}
