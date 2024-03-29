package com.ssafy.java;

import java.util.Scanner;

public class ArrayTest {
	static int[] list;
	//print(): 배열을 생성하고, 배열에 입력된 값을 출력
	static void print() {
//		Scanner sc = new Scanner(System.in);
//		String[] str_array = (sc.nextLine()).split(" ");
//		list = new int[str_array.length];
//		for(int i=0; i<str_array.length; i++)
//			list[i] = Integer.parseInt(str_array[i]);
		
		list = new int[]{34,23,64,25,12,75,22,88,53,37};
		for(int num:list)
			System.out.printf(num + " ");
		System.out.println();
	}
	//total(): 배열에 입력된 값의 합계를 구하여 출력
	static void total() {
		int sum=0;
		for(int num:list)
			sum += num;
		System.out.println("배열의 합 : "+sum);
	}
	//average(): 배열에 입력된 값의 평균을 구하여 출력
	static void average() {
		int sum=0;
		for(int num:list)
			sum += num;
		System.out.println("배열의 평균 : " + (sum/list.length));
	}
	//selectionSort()
	static void selectionSort() {
		for(int i = 0; i < list.length; i++) {
			for(int j = i; j < list.length; j++) {
				if(list[j] < list[i]) {
					int tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
	}
	//minimum(): 배열에 입력된 최소값을 구함
	static void minimum() {
		selectionSort();
		System.out.println("배열의 최소값 : "+list[0]);
	}
	
	public static void main(String[] args) {
		print();
		total();
		average();
		minimum();
	}
}