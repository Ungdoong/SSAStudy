package com.ssafy.java;

public class Lotto {
	public static void main(String[] args) {
		int[] numbers = new int[6];
		int index=0;
		
		while(numbers[5] == 0) {
			int gen_num = (int)((Math.random()*45) + 1);
			boolean exist = false;
			
			for(int number:numbers) {
				if(gen_num == number) {
					exist = true;
					break;
				}
			}
			if(!exist)
				numbers[index++] = gen_num;
		}
		
		for(int i=0; i<numbers.length; i++) {
			for(int j=i; j<numbers.length; j++) {
				if(numbers[i] > numbers[j]) {
					int tmp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = tmp;
				}
			}
		}
		
		for(int number:numbers)
			System.out.printf("%d ",number);
	}
}