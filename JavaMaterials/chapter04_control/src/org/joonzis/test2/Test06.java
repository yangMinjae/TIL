package org.joonzis.test2;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {			
			System.out.println("입력하신 수까지의 합을 구합니다.(입력값 미포함,-1입력시 종료)");
			System.out.print("정수를 입력하시오 : ");
			int a= Integer.parseInt(sc.nextLine());
			System.out.println();
			if(a==-1) {
				System.out.println("프로그램 종료");
				break;
			}
			if(a<2) {
				System.out.println("2이상의 값을 입력하시오");
				System.out.println("==============================");
				continue;
			}
			int sum=0;
			for(int i=1; i<a;i++) {
				sum+=i;
			}
			System.out.println("합계는"+sum+"입니다.");
			System.out.println("==============================");
		}
		sc.close();
		
	}

}
