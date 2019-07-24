package com.object;

public class Rect {
	//field
	int width;
	int height;
	
	//method
	double getArea() {
		return this.width*this.height;
	}
	
	double getCircum() {
		return 2*(this.width + this.height);
	}
}
