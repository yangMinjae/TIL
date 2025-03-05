package org.joonzis.ex;

import java.util.Scanner;
import java.util.Arrays;

public class Ex02_for_each {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		
		// 1. 개별적으로 한개씩 삽입
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		System.out.println(Arrays.toString(arr));
		
		// 2. 반복문 이용
		for (int a = 0; a < arr.length; a++) {
			arr[a]=sc.nextInt();
		}
		System.out.println(Arrays.toString(arr));
		
		// for-each문(향상 for문)
		// arr 배열이 각 요소를 num 이라는
		// 임시 변수로 전달해서 처리
		// 위에서 입력한 arr 데이터가
		// 순차적으로 num으로 넘어옴
		for (int num : arr) {
			System.out.println(num);
		}
		// for-each문은 값을 입력받을 수 없다
		sc.close();
		
	}
}
