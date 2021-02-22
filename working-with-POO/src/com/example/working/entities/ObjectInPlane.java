package com.example.working.entities;

import java.io.Serializable;

public class ObjectInPlane implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer xAxis;
	private Integer yAxis;

	public ObjectInPlane() {
	}

	public ObjectInPlane(Integer xAxis, Integer yAxis) {
		this.xAxis = xAxis;
		this.yAxis = yAxis;
	}

	public Integer getxAxis() {
		return xAxis;
	}

	public void setxAxis(Integer xAxis) {
		this.xAxis = xAxis;
	}

	public Integer getyAxis() {
		return yAxis;
	}

	public void setyAxis(Integer yAxis) {
		this.yAxis = yAxis;
	}

	@Override
	public String toString() {
		return "Current position of the object in the plane [xAxis=" + xAxis + ", yAxis=" + yAxis + "]";
	}

}
