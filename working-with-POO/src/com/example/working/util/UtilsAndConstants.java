package com.example.working.util;

public class UtilsAndConstants {

	public final Double pi = 3.1416;
	public static Double a;

	public Double calculateAreaOfCircle(Double radio) {
		a = pi * (radio) * 2;
		return a;
	}
}
