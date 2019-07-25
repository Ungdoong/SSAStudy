package com.abst;

public class Circle extends Shape{
	int r;
	
	public Circle(int r) {
		super();
		this.r = r;
	}

	public double getArea() {
		return Math.pow(r, 2) * Math.PI; 
	}
	
	public double getCircum() {
		return 2*r*Math.PI;
	}
}