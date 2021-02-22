package com.example.working.entities;

import java.io.Serializable;

/* Serializable: Para que un programa java pueda convertir un objeto en un montón de bytes y pueda luego recuperarlo, el objeto necesita ser Serializable. Al poder convertir el objeto a bytes, ese objeto se puede enviar a través de la red, guardarlo en un fichero, y después reconstruirlo al otra lado de la red, para asi leerlo del fichero.*/
public class MathCalculator implements Serializable {

	private static final long serialVersionUID = 1L;
	/*
	 * Parámetros: declaración de variables u objetos del modelo de una clase que se
	 * utilizarán en el código del programa
	 */
	private Double number1;
	/*
	 * Modificador de acceso privado: solo la clase puede acceder a la propiedad de
	 * la clase.
	 */
	private Double number2;
	private Integer operation;
	private Double sideA;
	private Double sideB;
	private Double sideC;
	private Double sideD;
	private Double perimeter;
	private Double area;

	public Double solveIsoscelesTriangleArea(Double sideA, Double sideB) {
		this.area = (sideB * (Math.sqrt(Math.pow(sideA, 2) - (Math.pow(sideB, 2) / 4)))) / 2;
		return this.area;
	}

	public Double solveIsoscelesTrianglePerimeter(Double sideA, Double sideB) {
		this.perimeter = (2 * sideA) + sideB;
		return this.perimeter;
	}

	public MathCalculator(Double number1, Double number2, Integer operation) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
	}

	public MathCalculator(Double number1, Double number2, Integer operation, Double sideA, Double sideB) {
		this.number1 = number1;
		this.number2 = number2;
		this.operation = operation;
		this.sideA = sideA;
		this.sideB = sideB;
	}

	/* Constructor para cuadrilateros irregulares */
	public MathCalculator(Double sideA, Double sideB, Double sideC, Double sideD) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.sideD = sideD;
	}

	/*
	 * Constructor para Paralelogramo: Un paralelogramo es un cuadrilátero cuyos
	 * pares de lados opuestos son iguales y paralelos dos a dos.
	 */
	public MathCalculator(Double sideA, Double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;
	}

	/*
	 * Constructor para cuadrados
	 */
	public MathCalculator(Double sideA) {
		this.sideA = sideA;
	}

	/*
	 * Método constructor: Un constructor es un método especial de una clase que se
	 * llama automáticamente siempre que se declara un objeto de esa clase. Su
	 * función es inicializar el objeto y sirve para asegurarnos que los objetos
	 * siempre contengan valores válidos.
	 */
	public MathCalculator() {
	}

	/*
	 * Método get: Es un método de acceso publico designado para leer los valores de
	 * las propiedades del objeto correspondiente, el método retorna el valor de una
	 * de las propiedades del objeto
	 */
	public Double getNumber1() {
		return number1;
	}

	/*
	 * Encapsulamiento: es un principio del lenguaje Java cuya filosofía es hacer
	 * que los atributos de las clases se puedan editar sólo a través de métodos. De
	 * manera general, se hace teniendo las propiedades como privadas y métodos que
	 * la controlan públicos. Comúnmente, se crean un grupo de métodos llamados
	 * getters (se encargan de obtener el valor de la propiedad) y setters (se
	 * encargan de setearla).
	 */

	/*
	 * Método set: Es un método de acceso público el cual su función es asignar
	 * valores a una propiedad correspondiente al objeto siendo que el argumento del
	 * metodo debe ser del mismo tipo de la propiedad en cuestión del objeto
	 */
	public void setNumber1(Double number1) {
		this.number1 = number1;
	}

	/*
	 * Método get: Es un método de acceso público el cual su función es de mostrar
	 * valores de una propiedad de la clase correspondiente a este método siendo que
	 * el valor que retorno es el mismo que el de la propiedad en cuestión
	 */
	public Double getNumber2() {
		return number2;
	}

	public void setNumber2(Double number2) {
		this.number2 = number2;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public Double getSideA() {
		return sideA;
	}

	public void setSideA(Double sideA) {
		this.sideA = sideA;
	}

	public Double getSideB() {
		return sideB;
	}

	public void setSideB(Double sideB) {
		this.sideB = sideB;
	}

	public Double getSideC() {
		return sideC;
	}

	public void setSideC(Double sideC) {
		this.sideC = sideC;
	}

	public Double getSideD() {
		return sideD;
	}

	public void setSideD(Double sideD) {
		this.sideD = sideD;
	}

	public Double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(Double perimeter) {
		this.perimeter = perimeter;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String triangleIsoscelestoString() {
		return "Triangle isosceles [sideA=" + sideA + ", sideB=" + sideB + ", perimeter=" + perimeter + ", area=" + area
				+ "]";
	}
}
