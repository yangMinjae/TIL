package org.joonzis.test;

import java.util.Arrays;

public class Test02 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 50, 60, 13, 25, 97};
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==60)System.out.println("인덱스는 : "+i);
		}
		System.out.println(Arrays.toString(arr));
	}
}
