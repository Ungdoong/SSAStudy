package com.inter;

class Tom{}
class Bill{}
interface Hillary{}

public class LittleTom extends Tom implements Hillary{
	public static void main(String[] args) {
		LittleTom little = new LittleTom();
		
		if(little instanceof Tom )
			System.out.println("instance of Tom");
		if(little instanceof Hillary )
			System.out.println("instance of Hillary");
//		if(little instanceof Bill )
//			System.out.println("instance of Bill");
		if(little instanceof LittleTom )
			System.out.println("instance of LittleTom");
	}
}