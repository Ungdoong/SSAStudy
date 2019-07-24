package com.object;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;

public class CarTest {
	public static void main(String[] args) {
		Button b = new Button("ok");
		Button c = new Button("cancel");
		Checkbox ch1 = new Checkbox();
		Checkbox ch2 = new Checkbox("one");
		Checkbox ch3 = new Checkbox("two",true);
		
		Frame f= new Frame("객체 생성 테스트");
		f.setLayout(new FlowLayout());
		f.add(b);
		f.add(c);
		f.add(ch1);
		f.add(ch2);
		f.add(ch3);
		
		f.setSize(300, 300);
		f.setVisible(true);
		
		//객체 생성
		Car c1 = new Car();
		Car c2 = new Car(1899);
		Car c3 = new Car(1900, "Sonata");
		Car c4 = new Car(1911, "Benz", "Taekjin Jeong");

		//객체 사용
		c1.num = 1234;
		c1.model = "avante";
		c1.owner = "kim";
		c1.info();
		System.out.println();
		c2.info();
		System.out.println();
		c3.info();
		System.out.println();
		c4.info();
	}
}