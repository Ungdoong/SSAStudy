package com.abst;

public class ShapeTest {

	public static void main(String[] args) {
		Shape[] s = new Shape[3];
		s[0] = new Circle(6);
		s[1] = new Rect(6,7);
		s[2] = new Circle(90);
		
		for(Shape x :s) {
			System.out.println(x.getClass().getSimpleName());
			System.out.println("면적:" + x.getArea());
			System.out.println("둘레:" + x.getCircum());
			System.out.println("-------------------");
		}
	}
}