package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		int[] arr = {13, 22, -3, 92, 55, 5};
		System.out.println(Arrays.toString(arr));
		Scanner sc = new Scanner(System.in);
		int a, b;
		while(true) {			
			System.out.println("바꾸고 싶은 index 2개를 고르시오");
			System.out.print("첫번째 >> ");
			a=sc.nextInt();
			if(a<0||a>=arr.length) {
				System.out.println(0+"에서 "+(arr.length-1)+"까지의 값을 입력하시오");
				System.out.println("=====================");
				continue;
			}
			System.out.print("두번쨰 >> ");
			b=sc.nextInt();
			if(b<0||b>=arr.length) {
				System.out.println(0+"에서 "+(arr.length-1)+"까지의 값을 입력하시오");
				System.out.println("=====================");
				continue;
			}
			break;
		}
		int tmp=arr[a];
		arr[a]=arr[b];
		arr[b]=tmp;
		
		System.out.println("값을 변경합니다.");
		System.out.println("변경 후");
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}
