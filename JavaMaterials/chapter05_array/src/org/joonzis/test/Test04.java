package org.joonzis.test;

import java.util.Scanner;

public class Test04 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			System.out.print((i+1)+"번째 값 입력 : ");
			arr[i]=sc.nextInt();
		}
		System.out.println("값을 더합니다.");
		int sum =0;
		for (int i : arr) {
			sum+=i;
		}
		System.out.println("합은"+sum);
		sc.close();
	}
}
