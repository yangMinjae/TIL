package org.joonzis.ex;

public class Ex02_interface {
	public static void main(String[] args) {
		Shape[] shape = {new Rect(3,4),new Circle(4)};
		for (int i = 0; i < shape.length; i++) {
			shape[i].output();
		}
	}
}
interface Shape{
	public double PI = Math.PI;
	public double calcArea();
	public void output();
}
class Rect implements Shape{
	private int width, height;
	public Rect() {}
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		return (double)width*height;

	}
	public void output() {
		System.out.println("너비 : "+width);
		System.out.println("높이 : "+height);
		System.out.println("넓이 : " + calcArea());
		System.out.println();
		
	};
}
class Circle implements Shape{
	private double radius;
	public Circle() {}
	public Circle(double radius) {	
		this.radius = radius;
	}
	@Override
	public double calcArea() {
		return PI*Math.pow(radius, 2);
	}
	@Override
	public void output() {
		System.out.println("반지름 : "+radius);
		System.out.println("넓이 : " + calcArea());
		System.out.println();
	}
}