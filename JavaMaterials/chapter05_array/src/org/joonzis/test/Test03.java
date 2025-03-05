package org.joonzis.test;

public class Test03 {
	public static void main(String[] args) {
		int sum=0;
		int arr[] = {10, 20, 50, 60, 13, 25, 97};
		for (int a = 0; a < arr.length; a++) {
			sum+=arr[a];
		}
		System.out.println("총점"+sum);
		System.out.printf("평균%.2f",(double)sum/arr.length);
		
	}
}
