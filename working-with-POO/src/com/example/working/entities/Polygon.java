package com.example.working.entities;

import java.io.Serializable;

public abstract class Polygon implements Serializable {

	private static final long serialVersionUID = 1L;
	protected Double area;
	protected Double perimeter;

	public Polygon() {
	}

	public abstract Double solvePolygonArea();

	public abstract Double solvePolygonPerimeter();

	public abstract String showPolygonData();

	public Polygon(Double area, Double perimeter) {
		this.area = area;
		this.perimeter = perimeter;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(Double perimeter) {
		this.perimeter = perimeter;
	}

}
