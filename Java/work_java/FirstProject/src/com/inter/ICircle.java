package com.inter;

public class ICircle implements IShape{
	int r;
	
	public ICircle(int r) {
		this.r = r;
	}

	@Override
	public double getArea() {
		return 3.14 * r * r ;
	}

	@Override
	public double getCircum() {
		return 2 * 3.14 * r;
	}
}
