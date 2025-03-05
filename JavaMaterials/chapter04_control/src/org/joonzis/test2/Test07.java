package org.joonzis.test2;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("정수 입력(-1입력시 종료)");
			System.out.print("첫번째 정수 >>");
			int a = Integer.parseInt(sc.nextLine());
			if(a==-1) {
				System.out.println("프로그램 종료");
				break;
			}
			System.out.print("두번째 정수 >>");
			int b = Integer.parseInt(sc.nextLine());
			if(b==-1) {
				System.out.println("프로그램 종료");
				break;
			}
			int sum =0;
			int big, small;
			if(a>b) {
				big=a;
				small=b;
			}else {
				big=b;
				small=a;
			}
			System.out.print(small+"부터"+big+"까지의 합은");
			for(;small<big+1;small++) {
				sum+=small;
			}
			System.out.println(sum+"입니다.");
			System.out.println("===========================");
		}
		sc.close();
	}

}
