package org.joonzis.test;

import java.util.Scanner;

class Circle {
	int radius;
	static final double PI=Math.PI;
	String name; 
	void info() {
		System.out.println("반지름 : "+radius);
		System.out.println("이름 : "+name);
		System.out.printf("크기 : %.2f%n",(PI*Math.pow(this.radius, 2)));
		System.out.printf("둘레 : %.2f",(PI*2*this.radius));
	}
}
class CircleMain{
	public static void main(String[] args) {
		Circle cir = new Circle();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		cir.name=sc.nextLine();
		
		System.out.print("반지름 : ");
		cir.radius=Integer.parseInt(sc.nextLine());
		

		System.out.println();
		cir.info();
		sc.close();
		
	}
}
