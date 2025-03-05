package org.joonzis.test;

import java.util.Scanner;

public class TriangleMain {
	public static void main(String[] args) {
		Triangle tri = new Triangle();
		Scanner sc = new Scanner(System.in);
		int width, height;
		System.out.print("너비 : ");
		width= sc.nextInt();
		System.out.print("높이 : ");
		height= sc.nextInt();
		System.out.println();
		tri.init(width, height);
		tri.info();
		sc.close();
	}

}
class Triangle{
	int width;
	int height;
	void init(int width, int height) {
		this.width = width;
		this.height = height;
	}
	void info() {
		System.out.println("너비 : "+this.width);
		System.out.println("높이 : "+this.height);
		System.out.println("넓이 계산");
		System.out.printf("넓이 : %.2f",calcArea());
		System.out.println();
	}
	double calcArea() {
		return width*height/2.0;
	}
}
