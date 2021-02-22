package com.example.working.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import com.example.working.entities.Car;
import com.example.working.entities.MathCalculator;
import com.example.working.entities.ObjectInPlane;
import com.example.working.entities.Polygon;
import com.example.working.entities.Rectangle;
import com.example.working.entities.Triangle;

/*Service: Esta sección en algunos patrones de diseño suele delegar se a un eslabón entre el acceso de los datos en las entidades y los controladores, esta sección se le delega la lógica del negocio para tener un proyecto mejor estructurado y ordenado */
public class PooService {

	/*
	 * Variables Globales y locales: las variables son propiedades de un objeto en
	 * cuestión y poseen u tipo, al declarar variables fuera de métodos son
	 * variables que pueden ser usadas en cualquier método de la misma clase estas
	 * son conocidas como "Variables Globales" por otra parte las variables que son
	 * declaradas dentro de los métodos únicamente pueden ser utilizadas dentro de
	 * este y se le conocen como "Variables Locales"
	 */
	private MathCalculator calculator;
	private List<MathCalculator> triangles;
	private Scanner scanner;
	private Double result = 0.0, area = 0.00, perimeter = 0.00;
	private String operationName = "No asigned", message = "Nothing";
	private Boolean exitMenu, exitSubMenu;
	private String movement;
	private ObjectInPlane object;

	private Car car;
	private List<Car> cars;
	private Integer option;
	private Integer id;
	private String color;
	private String mark;
	private Double price;
	private Double km;
	private String licensePlate;
	private Integer index;

	private List<Polygon> polygons;
	private Triangle triangle;
	private Rectangle rectangle;

	private String inputText;
	private List<Pattern> patterns;

	public static final String pUpperCase = ".*[A-Z].*";
	public static final String pLowerCase = ".*[a-z].*";
	public static final String pEspecialCharacters = ".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*";
	public static final String pPersonalizedCharacter = ".*\\d.*";

	/* Sobrecarga de métodos */
	public void instanceNewCar(String carLicencePlate1, String carLicencePlate2) {
		Car car = new Car(1, "Red", "Toyota", 5000.00, 123.45);
		Car carTwo = new Car(2, "Gray", "BMW", 125000.34, 0.00);
		System.out.println(car.toString("First car: ", carLicencePlate1));
		System.out.println(carTwo.toString("Second car: ", carLicencePlate2));
	}

	public void instanceNewCar() {
		/*
		 * Instancio un nuevo objeto de la clase "Car", con el método constructor doy un
		 * valor inicial a las propiedades del objeto "car" Java almacena el objeto y
		 * sus propiedades en memoria posteriormente inprimo las propiedades del objeto
		 * en consola
		 */
		Car car = new Car(1, "Red", "Toyota", 5000.00, 123.45);
		Car carTwo = new Car(2, "Gray", "BMW", 125000.34, 0.00);
		System.out.println(car.toString("First car: "));
		System.out.println(carTwo.toString("Second car: "));
	}

	public void createOrUpdateCar(String action, Integer index, String licensePlate) {
		/* instance new Car */
		car = new Car();
		if (action.equalsIgnoreCase("create")) {
			System.out.println("Action in progress: introducing a new car into the system.");
		} else {
			System.out.println("Action in progress: updating a car by license plate: " + licensePlate);
		}
		/* Solicitando valor del auto */
		System.out.println("Enter the value of the id:");
		id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter the color of the car:");
		color = scanner.nextLine();

		System.out.println("Enter the name of the mark:");
		mark = scanner.nextLine();

		System.out.println("Enter the price of the car:");
		price = scanner.nextDouble();

		System.out.println("Enter the mileage of the car:");
		km = scanner.nextDouble();

		System.out.println("Enter the car license code:");
		this.licensePlate = scanner.next();

		car.setId(id);
		car.setColor(color);
		car.setMark(mark);
		car.setPrice(price);
		car.setKm(km);
		car.setLicensePlate(this.licensePlate);

		if (action.equalsIgnoreCase("create")) {
			cars.add(car);
			System.out.println("The car has been successfully entered into the system, car information:");
		} else {
			cars.set(index, car);
			System.out.println("The car has been satisfactorily updated in position: " + (index + 1) + ".");
		}
		System.out.println(car.toString() + ".\n");
	}

	public void findAllCars() {
		/* View all cars in the system */
		System.out.println("Action in progress: viewing the full list of cars in the system.");
		if (cars.isEmpty()) {
			System.out.println("The car list is empty, you could add a new car from the menu.\n");
		} else {
			index = 0;
			cars.forEach(c -> {
				index++;
				System.out.println(index + "-" + c.toString() + ".");
			});
			System.out.println("");
		}
	}

	public void carMaintenance() {
		try {
			/* Intancio nuevos atributos que utilizare en el desarrollo del método */
			scanner = new Scanner(System.in);
			cars = new ArrayList<Car>();
			exitMenu = false;
			option = 0;
			System.out.println("Welcome to simple car maintenance App!");
			/*
			 * Bucle que mantiene la app esperando instrucciones hasta cerrarla manualmente
			 */
			while (!exitMenu) {
				System.out.println("Choose an action to do!");
				/* Listado de acciones a ejecutar en la app */
				System.out.println(
						"1)Add new Car.  2)View the full list of Cars.  3)Update a Car by license plate.  4)Delete one Car from the list.  \n5)Find one car by license plate.  6)View the cheapest car.  7)View the more expensive car.  8)Exit.");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					/* Add new Car */
					this.createOrUpdateCar("create", null, null);
					break;
				case 2:
					/* View the full list of Cars */
					this.findAllCars();
					break;
				case 3:
					/* Update car by license plate */
					System.out.println("Enter the value of the license plate of the car to update:");
					scanner.nextLine();
					licensePlate = scanner.nextLine();
					car = new Car(licensePlate.trim());
					if (cars.contains(car)) {
						index = cars.indexOf(car);
						this.createOrUpdateCar("update", index, licensePlate);
					} else {
						System.out.println("We didn't found a car by license plate: " + licensePlate + ".\n");
					}
					break;
				case 4:
					/* Delete one Car from the list */
					System.out.println("Enter the value of the license plate of the car to delete:");
					scanner.nextLine();
					licensePlate = scanner.nextLine();
					System.out.println("Action in progress: deleting a car by license plate: " + licensePlate + ".");
					car = new Car(licensePlate.trim());
					if (cars.contains(car)) {
						cars.remove(car);
						System.out.println("The car by the license plate: " + licensePlate
								+ " has been deleted successfully in the position: " + (index + 1) + ".\n");
					} else {
						System.out.println("We didn't found a car by license plate: " + licensePlate + ".\n");
					}
					break;
				case 5:
					/* Find one car by license plate */
					System.out.println("Enter the license plate of the car to see its information:");
					scanner.nextLine();
					licensePlate = scanner.nextLine();
					System.out.println("Action in progress: Searching a car by license plate: " + licensePlate + ".");
					car = new Car(licensePlate.trim());
					if (cars.contains(car)) {
						System.out.println("Satisfactory results for license plate: " + licensePlate + ".\n"
								+ cars.get(cars.indexOf(car)).toString() + ".\n");
					} else {
						System.out.println("We didn't found a car by license plate: " + licensePlate + ".\n");
					}
					break;
				case 6:
					/* View the cheapest car */
					System.out.println("Action in progress: viewing the information of the cheapest car.");
					if (!cars.isEmpty()) {
						System.out.println(
								cars.stream().min(Comparator.comparing(Car::getPrice)).get().toString() + ".\n");
					} else {
						System.out.println("The car list is empty.\n");
					}
					break;
				case 7:
					/* View the more expensive car */
					System.out.println("Action in progress: viewing the information of the more expensive car.");
					if (!cars.isEmpty()) {
						System.out.println(
								cars.stream().max(Comparator.comparing(Car::getPrice)).get().toString() + ".\n");
					} else {
						System.out.println("The car list is empty.\n");
					}
					break;
				case 8:
					/* Close app */
					System.out.println("Closing application, bye!");
					exitMenu = true;
					break;
				default:
					System.out.println("You have chosen an invalid operation...");
					break;
				}
			}
			scanner.close();
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public void callResolveOperation() {
		try {
			/* Inicialización de variables */
			scanner = new Scanner(System.in);
			calculator = new MathCalculator();
			exitMenu = false;
			System.out.println("Welcome to the Math Calculator Application!");
			while (!exitMenu) {
				System.out.println("Choose the operation to resolve: ");
				System.out.println(
						"1)Summation.  2)Multiplication.  3)Division.  4)Substraction.\n5)Calculate perimeter and area(Quadrilateral).  6)Calculate area and perimeter of isosceles triangle.  7)Exit.\n");
				calculator.setOperation(scanner.nextInt());
				if (calculator.getOperation() > 0 && calculator.getOperation() < 5) {
					System.out.println("Enter the first number of the operation");
					calculator.setNumber1(scanner.nextDouble());
					System.out.println("Enter the second number of the operation");
					calculator.setNumber2(scanner.nextDouble());
					this.solveBasicMathOperation(calculator.getOperation(), calculator.getNumber1(),
							calculator.getNumber2());
					System.out.println("");
				} else if (calculator.getOperation() == 5) {
					this.solveBasicQuadrilateralOperation();
				} else if (calculator.getOperation() == 6) {
					this.solverBasicIsoscelesTriangle();
				} else if (calculator.getOperation() == 7) {
					System.out.println("Closing application, bye!");
					exitMenu = true;
				} else {
					System.out.println("You have chosen an invalid operation...");
				}
			}
			scanner.close();
		} catch (Exception e) {
			scanner.close();
			System.out.println(e.getMessage());
		}
	}

	/*
	 * Parámetros y argumentos: Son datos que se envían al método para interactuar
	 * dentro de el mismo método, con el término "this" se puede distinguir entre un
	 * argumento y un parámetro local
	 */

	/*
	 * Los métodos con valor de retorno son módulos de programa que pueden recibir
	 * datos de entrada por medio de variables locales (parámetros) y posteriormente
	 * retorna un resultado al punto donde es llamado. Este tipo de métodos se
	 * utiliza para operar cualquier tipo de proceso que produzca un resultado.
	 */
	private void solveBasicMathOperation(Integer operation, Double number1, Double number2) {
		switch (operation) {
		/* Summation */
		case 1:
			operationName = "summation";
			result = number1 + number2;
			message = "The result of the " + operationName + " is: " + result;
			break;
		/* Multiplication */
		case 2:
			operationName = "multiplication";
			result = number1 * number2;
			message = "The result of the " + operationName + " is: " + result;
			break;
		/* Division */
		case 3:
			operationName = "division";
			if (number1 == 0.0) {
				message = "You can't do a " + operationName + " by zero";
			} else {
				result = number1 / number2;
				message = "The result of the " + operationName + " is: " + result;
			}
			break;
		/* Subtraction */
		case 4:
			operationName = "subtraction";
			result = number1 - number2;
			message = "The result of the " + operationName + " is: " + result;
			break;
		/* You have chosen an invalid operation */
		default:
			message = "You have chosen an invalid operation...";
			break;
		}
		System.out.println(message);
	}

	/* Basic Math Operations Calculator Extension */
	private void solverBasicIsoscelesTriangle() {
		exitSubMenu = false;
		perimeter = 0.00;
		area = 0.00;
		triangles = new ArrayList<MathCalculator>();
		while (exitSubMenu == false) {
			System.out.println("Isosceles triangle solver submenu, choose an option to perform:");
			System.out.println(
					"1)Solve perimeter and area.  2)Show triangle with the largest surface.  3)Show triangle with the smallest surface.  4)View all solved triangles.  5)Back to menu.");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				/* Solving perimeter and area */
				calculator = new MathCalculator();
				System.out.println("Action in progress: Solving perimeter and area of ​​an isosceles triangle.");
				System.out.println("Enter the value of the congruent side 'A':");
				calculator.setSideA(scanner.nextDouble());
				System.out.println("Enter the value of the triangle's base:");
				calculator.setSideB(scanner.nextDouble());

				/* Solving tringle's area */
				if (calculator.getSideA() <= 0 || calculator.getSideB() <= 0) {
					System.out.println("The value of the sides must be greater than 0.\n");
				} else {
					area = calculator.solveIsoscelesTriangleArea(calculator.getSideA(), calculator.getSideB());
					perimeter = calculator.solveIsoscelesTrianglePerimeter(calculator.getSideA(),
							calculator.getSideB());
					calculator.setPerimeter(perimeter);
					calculator.setArea(area);
					triangles.add(calculator);
					System.out.println("The value of the area of the triangle is: " + area
							+ " and the value of the perimeter is: " + perimeter + ".\n");
				}
				break;
			case 2:
				/* Showing triangle with the largest surface */
				System.out.println("Action in progress: Showing the isosceles triangle with the largest surface.");
				if (!triangles.isEmpty()) {
					System.out.println(triangles.stream().max(Comparator.comparing(MathCalculator::getPerimeter)).get()
							.triangleIsoscelestoString() + ".\n");
				} else {
					System.out.println("The triangles list is empty!\n");
				}
				break;
			case 3:
				/* Show triangle with the smallest surface */
				System.out.println("Action in progress: Showing the isosceles triangle with the smallest surface.");
				if (!triangles.isEmpty()) {
					System.out.println(triangles.stream().min(Comparator.comparing(MathCalculator::getPerimeter)).get()
							.triangleIsoscelestoString() + ".\n");
				} else {
					System.out.println("The triangles list is empty!\n");
				}
				break;
			case 4:
				/* Viewing all triangles solved */
				System.out.println("Action in progress: listing all the solved triangles.");
				if (!triangles.isEmpty()) {
					index = 0;
					triangles.forEach(t -> {
						System.out.println(index + 1 + "-" + t.triangleIsoscelestoString());
						index++;
					});
					System.out.println("");
				} else {
					System.out.println("The triangles list is empty!\n");
				}
				break;
			case 5:
				/* Back to menu */
				System.out.println("Going back to the main menu...");
				exitSubMenu = true;
				break;
			default:
				/* Default option */
				System.out.println("You have chosen an invalid operation...");
				break;
			}
		}
	}

	private void solveBasicQuadrilateralOperation() {
		exitSubMenu = false;
		/* Loop for Basic Quadrilateral Operations */
		while (exitSubMenu == false) {
			System.out.println("Quadrilateral operations solver submenu, Choose the type of quadrilateral to solve:");
			System.out.println("1)Square.  2)Trapeze.  3)Rhombus.  4)Back to menu.");
			calculator.setOperation(scanner.nextInt());
			System.out.println("");
			switch (calculator.getOperation()) {
			case 1:
				/* Square area and perimeter */
				System.out.println("Enter the value of one of its sides:");
				calculator.setSideA(scanner.nextDouble());

				perimeter = calculator.getSideA() * 4;
				area = Math.pow(calculator.getSideA(), 2);

				System.out.println(
						"The value of the Perimeter is: " + perimeter + " and the value of the Area is: " + area);
				break;
			case 2:
				/* Trapeze area and perimeter */
				System.out.println("Enter the value of the largest base:");
				calculator.setSideA(scanner.nextDouble());
				System.out.println("Enter the value of the shortest base:");
				calculator.setSideB(scanner.nextDouble());
				System.out.println("Enter the value of the oblique side:");
				calculator.setSideC(scanner.nextDouble());
				System.out.println("Enter the height value:");
				calculator.setSideD(scanner.nextDouble());

				perimeter = calculator.getSideA() + calculator.getSideB() + (2 * calculator.getSideC());
				area = ((calculator.getSideA() + calculator.getSideB()) * calculator.getSideD()) / 2;

				System.out.println(
						"The value of the Perimeter is: " + perimeter + " and the value of the Area is: " + area);
				break;
			case 3:
				/* Rhombus area and perimeter */
				System.out.println("Enter the value of one of its sides:");
				calculator.setSideA(scanner.nextDouble());
				System.out.println("Enter the value of both diagonals that cross the center of the rhombus:");
				calculator.setSideB(scanner.nextDouble());
				calculator.setSideC(scanner.nextDouble());

				perimeter = calculator.getSideA() * 4;
				area = (calculator.getSideB() * calculator.getSideC()) / 2;

				System.out.println(
						"The value of the Perimeter is: " + perimeter + " and the value of the Area is: " + area);
				break;
			case 4:
				System.out.println("Going back to the main menu...");
				exitSubMenu = true;
				break;
			default:
				System.out.println("You have chosen an invalid operation...");
				break;
			}
			System.out.println("");
		}
	}

	public void objectOrientationExercise() {
		try {
			/* Fourth exercise, save the location of an object on a plane */
			exitMenu = false;
			movement = "";
			object = new ObjectInPlane(0, 0);
			scanner = new Scanner(System.in);
			System.out.println("Welcome to the object orientation test on a plane!");
			System.out.println(
					"You can control the movement of your object within a plane orienting yourself along the X and Y axes, to move your object press the awsd keys \nat the same time you will see the position of your character, press the O key to finish the test.");
			while (exitMenu == false) {
				movement = scanner.nextLine();
				if (movement.equalsIgnoreCase("") == true) {
					System.out.println("You did nothing...");
					System.out.println(object.toString());
				} else {
					switch (movement) {
					case "a":
						object.setxAxis(object.getxAxis() - 1);
						System.out.println(object.toString());
						break;
					case "s":
						object.setyAxis(object.getyAxis() - 1);
						System.out.println(object.toString());
						break;
					case "w":
						object.setyAxis(object.getyAxis() + 1);
						System.out.println(object.toString());
						break;
					case "d":
						object.setxAxis(object.getxAxis() + 1);
						System.out.println(object.toString());
						break;
					case "o":
						System.out.println("Finishing the object location test, bye!");
						exitMenu = true;
						break;
					default:
						System.out.println("You have chosen an invalid operation...");
						System.out.println(object.toString());
						break;
					}
				}

			}
		} catch (Exception e) {
			scanner.close();
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void alternateBasicPolygonSolver() {
		try {
			scanner = new Scanner(System.in);
			exitMenu = false;
			option = 0;
			perimeter = 0.00;
			area = 0.00;
			polygons = new ArrayList<Polygon>();
			System.out.println("Welcome to alternate basic polygon solver app!");
			while (!exitMenu) {
				System.out.println("Choose an option to perform!");
				System.out.println(
						"1)Solve polygon.  2)View all polygons on list.  3)Find the polygon with the largest area and perimeter.\n4)Find the polygon with the smallest area and perimeter.  5)Exit.");
				option = scanner.nextInt();
				System.out.println("");
				switch (option) {
				case 1:
					/* Solver polygon */
					System.out.println("Action in progress: Solving polygon.");
					System.out.println("Choose the type of polygon to solve:\n1)Triangle.  2)Rectangle.");
					option = scanner.nextInt();
					if (option == 1) {
						triangle = new Triangle();
						System.out.println("Enter the value of sides 1, 2 and 3:");
						triangle.setSideA(scanner.nextDouble());
						triangle.setSideB(scanner.nextDouble());
						triangle.setSideC(scanner.nextDouble());

						if (triangle.getSideA() <= 0 || triangle.getSideB() <= 0 || triangle.getSideC() <= 0) {
							System.out.println("Side values ​​must be greater than 0!");
						} else {
							perimeter = triangle.solvePolygonPerimeter();
							triangle.setPerimeter(perimeter);

							area = triangle.solvePolygonArea();
							triangle.setArea(area);

							System.out.println(triangle.showPolygonData() + ".\n");
							polygons.add(triangle);
						}
					} else if (option == 2) {
						rectangle = new Rectangle();
						System.out.println("Enter the value of the base and height:");
						rectangle.setSideA(scanner.nextDouble());
						rectangle.setSideB(scanner.nextDouble());

						perimeter = rectangle.solvePolygonPerimeter();
						area = rectangle.solvePolygonArea();

						rectangle.setArea(area);
						rectangle.setPerimeter(perimeter);

						System.out.println(rectangle.showPolygonData() + ".\n");
						polygons.add(rectangle);
					} else {
						System.out.println("You have chosen an invalid option!\n");
					}
					break;
				case 2:
					/* View all polygons on list */
					if (!polygons.isEmpty()) {
						index = 0;
						polygons.forEach(t -> {
							System.out.println(index + 1 + "-" + t.showPolygonData() + ".");
							index++;
						});
						System.out.println("");
					} else {
						System.out.println("The polygons list is empty!\n");
					}
					break;
				case 3:
					/* Find the polygon with the largest area and perimeter */
					System.out.println(
							"Action in progress: Looking at the polygons with the largest area and perimeter.");
					if (!polygons.isEmpty()) {
						System.out.println("Largest area-"
								+ polygons.stream().max(Comparator.comparing(Polygon::getArea)).get().showPolygonData()
								+ ".");
						System.out.println("Largest perimeter-" + polygons.stream()
								.max(Comparator.comparing(Polygon::getPerimeter)).get().showPolygonData() + ".\n");
					} else {
						System.out.println("The polygons list is empty.\n");
					}
					break;
				case 4:
					/* Find the polygon with the smallest area and perimeter */
					System.out.println(
							"Action in progress: Looking at the polygons with the smallest area and perimeter.");
					if (!polygons.isEmpty()) {
						System.out.println("Smallest area-"
								+ polygons.stream().min(Comparator.comparing(Polygon::getArea)).get().showPolygonData()
								+ ".");
						System.out.println("Smallest perimeter-" + polygons.stream()
								.min(Comparator.comparing(Polygon::getPerimeter)).get().showPolygonData() + ".\n");
					} else {
						System.out.println("The polygons list is empty!\n");
					}
					break;
				case 5:
					System.out.println("Closing app, bye!");
					exitMenu = true;
					break;
				default:
					System.out.println("You have chosen an invalid operation...");
					break;
				}
			}
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void basicLoops() {
		try {
			scanner = new Scanner(System.in);
			option = 0;
			exitMenu = false;
			System.out.println(
					"Welcome to the basic loops, the 3 basic java loops are executed based on the number of times the user requests.");
			while (!exitMenu) {
				System.out.println("Choose the loop to excute:\n1)Do While.  2)While.  3)For.  4)Exit.");
				option = scanner.nextInt();
				switch (option) {
				case 1:
					exitSubMenu = false;
					index = 0;
					do {
						index++;
						System.out.println(index);
						System.out.println("Executing loop, Do while, continue?\n1)Yes.  2)No.");
						option = scanner.nextInt();
						System.out.println("");
						if (option == 1) {
							exitSubMenu = false;
						} else if (option == 2) {
							exitSubMenu = true;
						} else {
							System.out.println("Invalid option.");
						}
					} while (exitSubMenu == false);
					System.out.println("Loop number of times: " + index + ".\n");
					break;
				case 2:
					System.out.println("Executing loop, While, enter a number greater than 0 to count:");
					option = scanner.nextInt();
					index = 0;
					while (option > 0 && option > index) {
						System.out.println(index);
						index++;
					}
					System.out.println("Loop number of times: " + index + ".\n");
					break;
				case 3:
					Integer gNumber = 0, sNumber = 0, option2 = 0;
					index = 0;
					System.out.println("Enter two numbers one greater than the other:");
					option = scanner.nextInt();
					option2 = scanner.nextInt();
					if (option > option2) {
						gNumber = option;
						sNumber = option2;
					} else {
						gNumber = option2;
						sNumber = option;
					}
					for (; sNumber <= gNumber; gNumber--, sNumber++, index++) {
						System.out.println(sNumber + " - " + gNumber);
					}
					System.out.println("Loop number of times: " + index + ".\n");
					break;
				case 4:
					System.out.println("Closing app, bye!");
					exitMenu = true;
					break;
				default:
					System.out.println("You have chosen an invalid operation...");
					break;
				}
			}
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void init() {
		patterns = new ArrayList<Pattern>();
		patterns.add(Pattern.compile(pUpperCase));
		patterns.add(Pattern.compile(pLowerCase));
		patterns.add(Pattern.compile(pPersonalizedCharacter));
		patterns.add(Pattern.compile(pEspecialCharacters));
	}

	public void patternExercise() {
		try {
			scanner = new Scanner(System.in);
			this.init();
			System.out.println(
					"Welcome to the writing pattern analysis test, write something to test the operation of the app");
			inputText = scanner.nextLine();
			if (inputText == null) {
				System.out.println("The text is null!");
			} else if (inputText.isEmpty()) {
				System.out.println("The text is empty!");
			} else if (inputText.trim().length() == 1) {
				System.out.println("Valitading per character...");
				inputText = inputText.trim();
				if (Character.isUpperCase(inputText.charAt(0))) {
					System.out.println("The character entered is uppercase!");
				} else {
					System.out.println("The character entered is lowercase!");
				}
				System.out.println("Character: " + inputText + ".");
			} else if (inputText.trim().length() > 1) {
				inputText = inputText.trim();
				System.out.println("Valitading text...");
				for (Pattern p : patterns) {
					if (p.matcher(inputText).matches()) {
						System.out.println("The text entered matches the patterns established by the system!");
						break;
					}
				}
				System.out.println("Nothing matches!");
			}
		} catch (Exception e) {
			scanner.close();
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}
	}
}
