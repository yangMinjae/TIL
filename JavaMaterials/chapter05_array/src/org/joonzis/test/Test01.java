package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=(int)(Math.random()*10)+1;
		}
		System.out.print("{");
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.print("}");
		System.out.println();
		System.out.println("인덱스가 1인 곳의 값을 출력 >>"+arr[1]);
	}
}
