package com.ssafy.java;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int play=0, user, com, user_win=0, com_win=0;
		String input;
		
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.printf("번호를 입력하세요. ");
		play = sc.nextInt();
		play = 4 - play;		
		
		while(user_win < play && com_win < play) {
			System.out.printf("가위바위보 중 하나 입력: ");
			input = sc.next();
			com = (int)(Math.random()*3) + 1;
			
			switch(input){
			case "가위":
				user = 1;
				if(user == com)
					System.out.println("비겼습니다!!!");
				else if(com == 2) {
					System.out.println("졌습니다!!!");
					com_win++;
				}
				else {
					System.out.println("이겼습니다!!!");
					user_win++;
				}
				break;
			case "바위":
				user = 2;
				if(user == com)
					System.out.println("비겼습니다!!!");
				else if(com == 3) {
					System.out.println("졌습니다!!!");
					com_win++;
				}
				else {
					System.out.println("이겼습니다!!!");
					user_win++;
				}
				break;
			case "보":
				user = 3;
				if(user == com)
					System.out.println("비겼습니다!!!");
				else if(com == 1) {
					System.out.println("졌습니다!!!");
					com_win++;
				}
				else {
					System.out.println("이겼습니다!!!");
					user_win++;
				}
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
				break;
			}
		}
		System.out.println();
		System.out.println();
		if(user_win > com_win)
			System.out.println("### 인간 승!!!");
		else
			System.out.println("### 컴퓨터 승!!!");
	}
}
