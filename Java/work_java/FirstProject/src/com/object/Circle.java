package com.object;

public class Circle {
	//field
	int r;
	
	//method
	double getArea() {
		return Math.pow(this.r, 2)*Math.PI;
	}
	
	double getCircum() {
		return 2*Math.PI*this.r; 
	}
}