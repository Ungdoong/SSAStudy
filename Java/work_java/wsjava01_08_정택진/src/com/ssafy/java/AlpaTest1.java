package com.ssafy.java;

public class AlpaTest1 {
	public static void main(String[] args) {
		char str = 'A';
		
		for(int i = 0; i< 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.printf(str++ + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
}