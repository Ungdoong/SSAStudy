package com.object;

public class Car {
	//data, field, member field
	int num;
	String model;
	String owner;
	boolean falg;
	double d;
	
	//cunstructor. 생성자. 객체가 생성이 될 때 자동으로 실행되는 메소드
	//조건: 메소드 이름이 클래스 이름과 동일하고 리턴타입은 적지 않음
	//default 생성자(파라메터가 없는 생성자)
	Car(){ this(0,"hello","dfsdf");}
	Car(int num){ this.num=num; }
	Car(int num, String model){
		this.num=num;
		this.model=model;
	}
	Car(int num, String model, String owner){
		this.num=num;
		this.model=model;
		this.owner=owner;
	}
	
	//method
	void run(){
		System.out.println("rund method...");
	}
	
	void stop() {
		System.out.println("stop method...");
	}
	void info() {
		if(num != 0)
			System.out.println("num:"+num);
		if(model != null)
			System.out.println("model:"+model);
		if(owner != null)
			System.out.println("owner:"+owner);
	}
}