package org.joonzis.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수a를 입력하시오 : ");
		int a = Integer.parseInt(sc.nextLine());
		if(a%3==0) {
			System.out.println("3의 배수");
			sc.close();
			return;
		}
		
		if(a%2==0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
		sc.close();
	}
}
