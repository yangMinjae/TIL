package org.joonzis.ex;
// NumberFormatException
// 문자열을 정수 및 실수로 변환하지 못할 경우 예외 발생
public class Ex03_exception {
	public static void main(String[] args) {
		String data1 = "100";
		String data2 = "100a";
		
		/*
		 * 위 변수 데이터를 각각 파싱하여 숫자로 출력
		 * 첫 번째 변환된 값:
		 * 두 번쨰 변환된 값:
		 * 출력
		 * 예외 발생 시 "문자열을 숫자로 변환할 수 없습니다" 출력
		 */
		int a,b;
		try {
			a=Integer.parseInt(data1);
			System.out.println("첫번째 변환된 값 : "+a);
			b=Integer.parseInt(data2);
			System.out.println("두번째 변환된 값 : "+b);			
		}catch (NumberFormatException e) {
			System.out.println("문자열을 숫자로 변환할 수 없습니다.");
		}
	}
}
