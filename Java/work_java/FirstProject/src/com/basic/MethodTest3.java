package com.basic;

import java.util.Arrays;
import java.util.Scanner;

public class MethodTest3 {
	//1.메소드 정의 2.사용
	//average(): 정수형 변수 3개를 입력받아 그 평균을 double 타입으로 출력
	static void average(int a, int b, int c) {
		System.out.println((double)((a+b+c)/3.));
	}
	//reverse(): boolean형 매개변수 한 개를 입력 받아 그 반대의 값을 리턴(true => false, false => true)
	static boolean reverse(boolean flag) {
		return !flag;
	}
	//result(): boolean형 매개변수 2개(a,b)를 받아 String 변수를 리턴
	//a와 b가 모두 참인 경우에는 "ok"를 리턴. 그 이외에는 "cancel"을 리턴
	static String result(boolean a, boolean b) {
		return (a & b)?"ok":"cancel";
	}
	//loopString(): int형 변수(count)와 문자열 변수(msg) 한개를 입력 받아 count번 만큼 
	//반복해서 msg 문자열을 출력 (한줄에 한문장씩)
	static void loopString(int count, String msg) {
		for(int i = 0; i < count; i++)
			System.out.println(msg);
	}
	//getArea(): int형의 반지름 값(r)을 입력 받아 원면적을 계산한 후 리턴
	static double getArea(int r) {
		return Math.pow(r, 2.)*Math.PI;
	}
	//printCircum(): int형의 반지름 값(r)을 입력 받아 원둘레를 계산한 후 리턴
	static void printCircum(int r) {
		System.out.println(2.*r*Math.PI);
	}
	//makeArray(): 배열의 길이를 int형 변수(len)로 입력 받아 그 길이의 배열을 만들어 리턴
	static int[] makeArray(int len) {
		return new int[len];
	}
	//total(): int형 배열 data를 입력 받아 배열 안의 모든 값을 더해서 출력
	static void total(int[] array) {
		int sum = 0;
		for(int num:array)
			sum += num;
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		int[] data = {10,20,30,50,90,123,450,66,67};
		//작성된 메소드 사용
		average(1, 2, 3);
		System.out.println(reverse(true));
		System.out.println(reverse(false));
		System.out.println(result(true,true));
		System.out.println(result(true,false));
		loopString(3, "헬로우");
		System.out.println(getArea(3));
		printCircum(3);
		System.out.println(Arrays.toString(makeArray(9)));
		total(data);
	}
}