package com.basic;

import java.util.Scanner;

public class MethodTest {
	//1.메소드 정의 2.사용
	//hello():console에 "hello,java"를 출력
	static void hello() {
		System.out.println("hello,java");
	}
	
	//increase():int형 변수 한개를 입력 받아 1을 증가 시킨 후 그 값을 리턴
	static int increase(int a) {
		return ++a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//작성된 메소드 사용
		hello();
		System.out.println(increase(sc.nextInt()));
		
		sc.close();
	}
}