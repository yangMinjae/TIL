package org.joonzis.ex;

import java.util.Scanner;

public class Ex05_for {
	public static void main(String[] args) {
		// 0~9까지 출력
		for(int i=0;i<10;i++) {
			System.out.println(i);
		}
		// i가 소멸되는 시점
		// for문을 벗어나면 i는 사용불가
		
		// for문 마다 동일한 변수를 선언해도 무방
		for(int i = 0; i<=9;i++) {
			System.out.println(i);
		}
		// id를 입력받아서 id가 "admin"이면
		// "ID 일치" 출력 후 반복문 종료
		// 일치하지 않으면 "다시 입력하세요" 출력 후 반복
		String id;
		Scanner sc = new Scanner(System.in);
		do {			
			System.out.print("id를 입력하세요 : ");
			id = sc.nextLine();
		}while(!id.equals("admin"));
		System.out.println("ID 일치");
		sc.close();
			
	}
}
