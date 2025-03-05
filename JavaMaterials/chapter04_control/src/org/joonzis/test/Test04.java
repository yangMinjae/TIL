package org.joonzis.test;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 : ");
		char a =sc.nextLine().charAt(0);
		if('9'>=a && a>='0') {
			System.out.println("아라비아 숫자");
		}else if('Z'>=a&&a>='A') {
			System.out.println("대문자");
		}else if('z'>=a&&a>='a') {
			System.out.println("소문자");
		}else {
			System.out.println("일반문자");
		}
		sc.close();
	}
}
