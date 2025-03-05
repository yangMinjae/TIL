package org.joonzis.test;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Task1 tsk = new Task1();
		tsk.iterate();
	}

}
class Task1{
	private int input;
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("10 이상의 정수를 입력하시오 : ");
		this.input = sc.nextInt();
		sc.close();
	}
	public int divide(int num) throws ArithmeticException{
		return input/num;
	}
	public void iterate() {
		int num = 0;
		input();
		for (int i = 0; i < 100; i++) {
			num =(int)(Math.random()*10);
			System.out.println("<< "+ (i+1) +"회 >>");
			try {
				System.out.println(input+" / " + num +" = " + divide(num));
			} catch (ArithmeticException e) {				
				System.out.println("0으로 나눠진 상황");
			}
			System.out.println();
		}
	}
}