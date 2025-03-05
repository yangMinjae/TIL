package org.joonzis.test;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("필기 점수 : ");
		int wt =Integer.parseInt(sc.nextLine());
		System.out.print("실기 점수 : ");
		int pt =Integer.parseInt(sc.nextLine());
		if((wt>=70&&pt>=70)||(wt+pt)/2>=80) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");			
		}
		sc.close();
	}
}
