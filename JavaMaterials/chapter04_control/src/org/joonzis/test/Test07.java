package org.joonzis.test;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		switch(month) {
			case 1:case 3:case 5:case 7: case 8:case 10:case 12:
				System.out.println(month+"월은 31일까지 있습니다.");
				break;
			case 2:
				System.out.println(month+"월은 28일까지 있습니다.");
				break;
			default:
				System.out.println(month+"월은 30일까지 있습니다.");
		}
		sc.close();
	}
}
