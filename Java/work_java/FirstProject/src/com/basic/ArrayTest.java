package com.basic;

public class ArrayTest {

	public static void main(String[] args) {
		//배열은 생성만 해도 타입별로 default 값이 들어가 있음
		int[] score = new int[100];
		double[] point = new double[200];
		boolean[] flag = new boolean[55];
		String[] name = new String[30];
		
		System.out.println(score[33]);
		System.out.println(point[22]);
		System.out.println(flag[8]);
		System.out.println(name[13]);
	}

}
