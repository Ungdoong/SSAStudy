package com.object;

public class Rect {
	//field
	int width;
	int height;
	
	public Rect(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return "Rect [height= "+height+" / width= "+width+"]";
	}

	//method
	double getArea() {
		return this.width*this.height;
	}
	
	double getCircum() {
		return 2*(this.width + this.height);
	}
	
	public static void main(String[] args) {
		Rect r = new Rect(5, 7);
		System.out.println(r);
	}
}
