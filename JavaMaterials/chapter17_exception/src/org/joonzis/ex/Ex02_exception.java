package org.joonzis.ex;

public class Ex02_exception {
	public static void main(String[] args) {
		/*
		 * 크기 3짜리 정수형 배열 arr를 선언
		 * 각 인덱스에 순서대로 1, 2, 3 데이터 삽입
		 * 항상 for문을 이용하여 배열 내 데이터 출력
		 * 
		 * ** 예외 처리 **
		 * 위 실행 결과 확인 후
		 * 강제로 arr[3] 위치에 데이터 삽입
		 * 에러 발생 시 "인덱스 가용 법위를 벗어났습니다." 출력
		 */
		
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		try {
			arr[3]=4;			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 가용 범위를 벗어났습니다.");
		}
	}
}	
