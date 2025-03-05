package org.joonzis.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01_exception {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 		// 얘는 왜 try안에 안넣을까?
		int num1, num2;								// try는 중괄호를 갖고 있고 이 코드가 이 안에 들어간다면 지역 변수가 되어 
		try {										// 바깥에서는 쓸 수 없게 된다.		
			System.out.print("정수 1 입력 >> ");
			num1 = sc.nextInt();
			
			System.out.print("정수 2 입력 >> ");
			num2 = sc.nextInt();
			
			System.out.println("덧셈 결과 : " + (num1+num2));
			System.out.println("뺼셈 결과 : " + (num1-num2));
			System.out.println("곱셈 결과 : " + (num1*num2));
			System.out.println("나눗셈 결과 : " + (num1/num2));			
		}catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}catch (InputMismatchException e) {
			// e.printStackTrace();			// 무슨 exception일지 모를때 이 코드를 통해 알 수 있다.
			System.out.println("정수만 입력할 수 있습니다.");
		}finally {
			if(sc != null)
				sc.close();			
		}
	}
}
