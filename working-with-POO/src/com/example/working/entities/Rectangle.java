package com.example.working.entities;

public class Rectangle extends Polygon {

	private static final long serialVersionUID = 1L;
	private Double sideA;
	private Double sideB;

	public Rectangle(Double sideA, Double sideB) {
		this.sideA = sideA;
		this.sideB = sideB;

	}

	public Rectangle() {
	}

	public Rectangle(Double area, Double perimeter, Double sideA, Double sideB) {
		super(area, perimeter);
		this.sideA = sideA;
		this.sideB = sideB;

	}

	@Override
	public Double solvePolygonArea() {
		return sideA * sideB;

	}

	@Override
	public Double solvePolygonPerimeter() {
		return (sideA * 2) + (sideB * 2);
	}

	@Override
	public String showPolygonData() {
		String message = "Rectangle (base=" + sideA + ", height=" + sideB + ", perimeter=" + perimeter + ", area="
				+ area + ")";
		return message;
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

}
