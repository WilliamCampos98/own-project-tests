package com.reports.example.reporter.dto;

public class Triangle extends Polygon {

	private static final long serialVersionUID = 1L;
	private Double sideA;
	private Double sideB;
	private Double sideC;

	public Triangle(Double sideA, Double sideB, Double sideC) {
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	public Triangle() {
	}

	public Triangle(Double area, Double perimeter, Double sideA, Double sideB, Double sideC) {
		super(area, perimeter);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	@Override
	public Double solvePolygonArea() {
		Double p = (sideA + sideB + sideC) / 2;
		return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
	}

	@Override
	public Double solvePolygonPerimeter() {
		return sideA + sideB + sideC;
	}

	@Override
	public String showPolygonData() {
		String message = "Triangle (sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + ", perimeter="
				+ perimeter + ", area=" + area + ")";
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

	public Double getSideC() {
		return sideC;
	}

	public void setSideC(Double sideC) {
		this.sideC = sideC;
	}

}
