package com.object;

class Employee{
	int num;
	String name;
	int salary;
	
	public Employee(int num, String name, int salary) {
		super();
		this.num = num;
		this.name = name;
		this.salary = salary;
	}

	double getBonus() {
		return salary*0.2;
	}
}

public class Manager extends Employee{
	int deptcode;
	
	Manager(int num, String name, int salary, int deptcode){
		super(num, name, salary);
		this.deptcode=deptcode;
	}
	
	@Override
	double getBonus() {
		return salary * 0.3;
	}
	
	public static void main(String[] args) {
		
	}
}
