package com.reports.example.reporter.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ReportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String reportName;
	private Date fecha;
	private List<Car> cars;
	private List<Person> persons;

	public ReportDTO(String reportName, Date fecha, List<Car> cars, List<Person> persons) {
		this.reportName = reportName;
		this.fecha = fecha;
		this.cars = cars;
		this.persons = persons;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
