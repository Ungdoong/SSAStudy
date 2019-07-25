package com.inter;

public class ShrimpAvocado implements Sandwich {
	String[] materials;
	int price;
	

	public ShrimpAvocado(String[] materials, int price) {
		super();
		this.materials = materials;
		this.price = price;
	}

	@Override
	public void make() {
		StringBuilder sb = new StringBuilder();
		
		for(String m :materials)
			sb.append(m+"+");
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}

	@Override
	public void price() {
		System.out.println("Shrimp Sandwich : "+price+"원");
	}
}