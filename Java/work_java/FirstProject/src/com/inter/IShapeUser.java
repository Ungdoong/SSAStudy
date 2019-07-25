package com.inter;

public class IShapeUser {
	public static void main(String[] args) {
		IShape[] is = new IShape[3];
		is[0]=new ICircle(10);
		is[1]=new ICircle(20);
		is[2]=new IRect(20,30);
		
		for(IShape x :is) {
			System.out.println(x.getClass().getSimpleName());
			System.out.println("면적: "+x.getArea());
			System.out.println("둘레: "+x.getCircum());
			System.out.println("-----------------------");
		}
	}
}