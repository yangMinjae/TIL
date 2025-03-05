package org.joonzis.ex;

import java.util.Scanner;

public class Ex03_String_Array {
	public static void main(String[] args) {
		// 크기 3의 문자열 배열 names를 생성
		// 스캐너로부터 이름을 입력받아
		// "입력한 이름 : 00"출력
		// 일반 for, 향상 for
		String[] strArr = new String[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < strArr.length; i++) {
			System.out.print("이름"+(i+1)+" : ");
			strArr[i]=sc.nextLine();
		}
		for (int a = 0; a < strArr.length; a++) {
			System.out.print("입력한 이름 : "+strArr[a]+" | ");
		}
		System.out.println();
		for (String string : strArr) {			
			System.out.print("입력한 이름 : "+string+" | ");
		}
		
		sc.close();
	}
}
