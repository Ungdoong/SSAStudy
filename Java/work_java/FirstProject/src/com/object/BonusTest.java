package com.object;

public class BonusTest {

	void printBonus(Employee who) {
		System.out.println(who.getBonus());
	}
	
	public static void main(String[] args) {
		Employee tom = new Employee(123, "tom kim", 5000);
		Manager bill = new Manager(587, "bill jones", 7000, 100);
		
		BonusTest bt = new BonusTest();
		bt.printBonus(tom);
		bt.printBonus(bill);
	}
}