package com.object;

public class ObjectTest {
	@Override
	public String toString() {
		return "ObjecTest: 2019/07/25 made by taek. toString() 테스트 클래스";
	}

	public static void main(String[] args) {
		ObjectTest ot = new ObjectTest();
		System.out.println(ot);//레퍼런스만 출력해도 toString()가 호출됨
		System.out.println(ot.toString());
	}
}