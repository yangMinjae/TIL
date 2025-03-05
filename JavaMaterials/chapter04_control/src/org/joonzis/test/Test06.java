package org.joonzis.test;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("레벨 : ");
		int level = Integer.parseInt(sc.nextLine());
		switch(level) {
			case 3:
				System.out.println("실행권한 활성화");
			case 2:
				System.out.println("쓰기권한 활성화");
			case 1:
				System.out.println("읽기권한 활성화");
		}
		sc.close();
	}
}
