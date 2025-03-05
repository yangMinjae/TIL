package org.joonzis.ex;

public class Ex02_polymorphism {
	public static void main(String[] args) {
		// 길이 3짜리 부모 배열을 선언
		// 각각 인덱스에 사각형, 삼각형, 원형 클래스 객체 대입
		// 각 객체별 크기 출력;
		
		Shape sh[] = new Shape[3];
		sh[0] = new Rect(3,2);
		sh[1] = new Triangle(7,3);
		sh[2] = new Circle(5);
		for (int i = 0; i < sh.length; i++) {
			System.out.printf("%.2f%n",sh[i].calcArea());
		}
	}
}
class Shape{
	// 의미 없는 메소드(자식들이 사용하기 위해 만듦)
	public double calcArea() {
		return 0; 
	}
}
class Rect extends Shape{
	private int width, height;
	public Rect() {}
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		System.out.print("사각형 : ");
		return width * height;
	}
	
}
class Triangle extends Shape{
	private int width, height;
	public Triangle() {}
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	public double calcArea() {
		System.out.print("삼각형 : ");
		return width*height/2.0;
	}
	
	
}
class Circle extends Shape{
	private double radius;

	public Circle() {}
	public Circle(double radius) {
		this.radius = radius;
	}
	@Override
	public double calcArea() {
		System.out.print("원 : ");
		return Math.PI*Math.pow(radius, 2);
	}
	
	
}