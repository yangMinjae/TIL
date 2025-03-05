package org.joonzis.test;

public class CircleMain {
	public static void main(String[] args) {
		
	}
}
class Circle{
	double radius;
	public Circle(){
		this(1);
	}
	public Circle(int radius) {
		this.radius=radius;
	}
	double calcArea(){
		return Math.PI*Math.pow(radius, 2);
	}
	void output() {
		System.out.println("반지름 : " + this.radius);
		System.out.println("크기 : " + this.calcArea());
	}
}