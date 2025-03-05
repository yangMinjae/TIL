package org.joonzis.test;

import java.util.Scanner;

public class Test07 {
	public static void main(String[] args) {
		int[] a =new int[10];
		Scanner sc = new Scanner(System.in); 
		StringBuilder s=new StringBuilder("");
		for (int i = 0; i < a.length; i++) {
			System.out.print((i+1)+"번째 값 입력 : ");
			a[i]=sc.nextInt();
			if(a[i]%3==0) {
				s.append(i+"");
			}
		}
		System.out.println("입력 완료");
		System.out.println("3의 배수 출력");
		System.out.print("{");
		for (int i = 0; i < s.length(); i++) {
			System.out.print(a[s.charAt(i)-'0']+" ");
		}
		System.out.print("}");
		sc.close();
	}
}
