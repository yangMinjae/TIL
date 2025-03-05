package org.joonzis.ex;
/*
 * throws(예외 떠넘기기)
 * -메소드를 호출한 곳으로 예외를 떠넘긴다.
 * -떠넘길 예외 클래스를 쉼표(,)로 구분해서 나열할 수 있다.
 * -throws 키워드가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 한다.
 */
public class Ex06_exception {
	public static void main(String[] args) {
		try{
			divide(5,0);
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}
	public static void divide(int num1, int num2) throws ArithmeticException{	// exception을 호출한곳으로 떠넘기겠다.
		System.out.println("몫 : " + (num1/num2));
		System.out.println("나머지 : " + (num1%num2));
	}
}
