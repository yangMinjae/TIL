package org.joonzis.test;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		format();
	}
	static int getAge() throws AgeException{
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int tmp = sc.nextInt();
		if(tmp > 150 || tmp < 0) {
			sc.close();
			throw new AgeException("0~150 의 값을 입력하십시오.");
		}
		sc.close();
		return tmp;
	}
	static void format() {
		System.out.println();
		try {
			System.out.println("입력하신 나이 : " + getAge());			
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}
	}
}
class AgeException extends Exception{
	private static final long serialVersionUID = 1L;
	public AgeException(String msg) {
		super(msg);
	}
}