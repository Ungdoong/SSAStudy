package com.abst;

public class Rect extends Shape{
	int height, width;

	public Rect(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	public double getArea() {
		return height * width; 
	}
	
	public double getCircum() {
		return 2*(height + width);
	}
}