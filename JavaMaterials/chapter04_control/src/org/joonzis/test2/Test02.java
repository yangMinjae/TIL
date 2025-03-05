package org.joonzis.test2;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("몇단을 출력할까요?(0입력시 종료) >>");
			int i=Integer.parseInt(sc.nextLine());
			if(i==0) {
				System.out.println("구구단 종료");
				break;
			}
			if(i>9||i<0) {
				System.out.println("1~9 사이의 값을 입력하시오");
				continue;
			}
			for(int j=1;j<10;j++) {
				System.out.printf("%dx%d = %d%n",i,j,i*j);
			}
		}while(true);
		sc.close();
	}

}
