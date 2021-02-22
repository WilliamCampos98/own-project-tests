package com.example.working.entities;

import java.io.Serializable;

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String color;
	private String mark;
	private Double price;
	private Double km;
	private String licensePlate;

	public Car() {
	}

	/* Sobrecarga de constructores */
	public Car(Integer id, String color, String mark, Double price, Double km) {
		this.id = id;
		this.color = color;
		this.mark = mark;
		this.price = price;
		this.km = km;
	}

	public Car(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String toString(String nameObject) {
		return nameObject + "[id=" + id + ", color=" + color + ", mark=" + mark + ", price=" + price + ", km=" + km
				+ "]";
	}

	/*
	 * Sobrecarga de métodos: La firma de un método es la combinación del nombre y
	 * los tipos de los parámetros o argumentos. La sobrecarga de métodos es la
	 * creación de varios métodos con el mismo nombre, pero con diferente lista de
	 * tipos de parámetros. Java utiliza el número y tipo de parámetros para
	 * seleccionar cuál definición de método ejecutar.
	 */
	public String toString(String nameObject, String carLicensePlate) {
		return nameObject + "[id=" + id + ", color=" + color + ", mark=" + mark + ", price=" + price + ", km=" + km
				+ ", car licence plate=" + carLicensePlate + "]";
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", color=" + color + ", mark=" + mark + ", price=" + price + ", km=" + km
				+ ", licensePlate=" + licensePlate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		return true;
	}

}
