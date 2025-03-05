package org.joonzis.ex;

public class Ex04_2D_array {
	public static void main(String[] args) {
		//int[] arr = {1,2,3};
		int[][] arr1= {{1,2,3},{4,5,6},{7,8,9,10,11},{1,5}};
		
		for (int i = 0; i < arr1.length; i++) {
			System.out.println((i+1)+"번째 배열");
			System.out.print("{");
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j]+" ");
			}
			System.out.print("}");
			System.out.println();
		}
		System.out.println();
		
		for (int[] is : arr1) {
			System.out.print("{");
			for (int a : is) {
				System.out.print(a+" ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
}
