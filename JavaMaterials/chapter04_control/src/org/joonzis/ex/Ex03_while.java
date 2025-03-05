package org.joonzis.ex;

public class Ex03_while {
	public static void main(String[] args) {
		int num = 0;
		while(num<10) {
			System.out.println(num++);
		}
		System.out.println("---------");
		int num2=0;
		while(true) {
			System.out.println(num2++);
			if(num2>9) {
				System.out.println("종료");
				break;
			}
		}
	}
}
