package org.joonzis.test;

import java.util.Scanner;

public class RectMain {
	public static void main(String[] args) {
		Rect rec = new Rect();
		rec.init();
		rec.info();

	}
}
class Rect{
	int width;
	int height;
	void init() {
		Scanner sc = new Scanner(System.in);
		System.out.print("너비 : ");
		this.width= sc.nextInt();
		System.out.print("높이 : ");
		this.height= sc.nextInt();
		System.out.println();
		sc.close();
	}
	void info() {
		System.out.println("너비 : "+this.width);
		System.out.println("높이 : "+this.height);
		System.out.println("넓이 계산");
		System.out.printf("넓이 : %d", calcArea());
		System.out.println();
	}
	int calcArea() {
		return width*height;
	}
}
