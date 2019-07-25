package com.inter;

public class IRect implements IShape {
	int width;
	int height;
	
	public IRect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircum() {
		return 2 * (height + width);
	}

}