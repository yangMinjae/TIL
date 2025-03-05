package org.joonzis.ex;

public class Ex04_Circle {
	/*
	 * int x,y : 좌표
	 * double radius : 반지름
	 * 
	 * 메소드
	 * -생성자() : 좌표 0,0 radius  값 1로 고정
	 * -생성자(radius) : 좌표 0,0
	 * -풀생성자
	 * -calcaArea() : 원의 크기 리턴 (PI*r*r)
	 * -calcCircum() : 원의 둘레 리턴 (2*PI*r)
	 * -output() : 원의 중심 좌표, 반지름, 크기, 둘레 출력
	 * 
	 * ***PI 구하기 -> Math.PI
	 */
	int x,y;
	double radius;
	public Ex04_Circle() {
		this(0,0,1);
	}
	public Ex04_Circle(int x, int y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	public Ex04_Circle(double radius) {
		this(0,0,radius);
	}
	
	double calcArea() {
		return Math.PI*Math.pow(this.radius, 2);
	}
	double calcCircum() {
		return 2*Math.PI*this.radius;
	}
	void output() {
		System.out.println("중심좌표 : ("+this.x+", "+this.y+")");
		System.out.println("반지름 : "+this.radius);
		System.out.printf("크기 : %.2f%n",this.calcArea());
		System.out.printf("둘레 : %.2f%n"
				+ "",this.calcCircum());
		System.out.println("========================");
	}
	
}
