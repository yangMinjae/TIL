package org.joonzis.test;

public class Test06 {
	public static void main(String[] args) {
		int[] arr = {13, 22, -3, 92, 55, 5};
		int max=arr[0], min=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>max)max=arr[i];
			else if(arr[i]<min)min=arr[i];
		}
		System.out.println("최대값 : "+max);
		System.out.println("최대값 : "+min);
	}
}
