package org.joonzis.test2;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("숫자게임 시작");
		int answer=(int)(100*Math.random())+1;
		int input;
		while(true) {
			System.out.print("입력 :");
			input = Integer.parseInt(sc.nextLine());
			if(input>answer) {
				System.out.println("Down!");
			}else if(input<answer) {
				System.out.println("Up!");
			}else {
				System.out.println("정답입니다.\n프로그램 종료");
				break;
			}
			sc.close();
		}
	}

}
