package com.basic;

import java.util.Scanner;

public class MethodTest2 {
	//1.메소드 정의 2.사용
	//printGreeting(): 이름을 매개변수로 입력받아 그 앞에 "...be happy!"를 붙여 출력
	static void printGreeting(String name) {
		System.out.println("...be happy!"+name);
	}
	//greeting(): 이름을 매개변수로 입력받아 이름 뒤에 "welcome!"를 붙여 리턴.
	static String greeting(String name) {
		return name+" welcome!";
	}
	//concat(): 문자열 두 개를 입력 받아 그 둘을 붙여 리턴
	static String concat(String str1, String str2) {
		return str1+str2;
	}
	//sum(): 정수형 변수(int) 두개를 입력 받아 그 합을 구해 리턴
	static int sum(int a, int b) {
		return a+b;
	}
	//sum(): 실수형 변수(float) 두개를 입력 받아 그 합을 구해 리턴
	static float sum(float a, float b) {
		return a+b;
	}
	//sum(): 실수형 변수(double) 두개를 입력 받아 그 합을 구해 리턴
	static double sum(double a, double b) {
		return a+b;
	}
	//abs(): 정수형 변수(num) 한 개를 입력 받아 절대값을 구한 뒤 리턴
	static int abs(int num) {
		return (num>0)? num:-num;
	}
	//pi(): 원주율 값을 리턴
	static double pi() {
		return 4*(83*Math.atan(1./107.) + 17*Math.atan(1./1710.) - 22*Math.atan(1./103697.) - 24*Math.atan(1./2513489.
				- 44*Math.atan(1./18280007883.) + 12*Math.atan(1./7939642926390344818.) + 22*Math.atan(1./305421172725770425384731479018.)));
	}
	
	public static void main(String[] args) {
		//작성된 메소드 사용
		printGreeting("정택진");
		System.out.println(greeting("정택진"));
		System.out.println(concat("안녕하세요!", "반갑습니다"));
		System.out.println(abs(-5));
		System.out.println(pi());
	}
}