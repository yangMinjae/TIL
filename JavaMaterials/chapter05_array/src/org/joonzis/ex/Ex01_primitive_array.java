package org.joonzis.ex;

import java.util.Arrays;

public class Ex01_primitive_array {
	public static void main(String[] args) {
		// 정수영 arr1이라는 배열을 선언(크기 3)
		int[] arr1 = new int[3];
		// 정수형 arr2라는 배열을
		// 10, 20, 30의 값으로 초기화
		int[] arr2 = {10,20,30};
		// 배열 내 데이터 확인
		// 1.Arrays.toString() 메소드 사용
		// 값만 확인하는 용도
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));

		for(int i:arr1) {
			System.out.print(i+", ");
		}
		System.out.println();
		// 2. 배열 내 모든 인덱스 접근(중요)
		// 값을 저장하거나, 꺼내기 가능
		// 주로 반복문과 같이 사용
		for(int i=0; i<arr1.length;i++) {
			System.out.print(arr1[i]+", ");
		}
		
		// 인덱스 범위를 벗어난 요소(예외 발생)
		// System.out.println(arr1[3]);
	}
}
