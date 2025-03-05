package org.joonzis.ex;

public class Ex01_Triangle {
	// 필드
	int width, height;
	
	// 메소드
	// 초기화 메소드, 크기 계산 메소드, 출력 메소드
	public Ex01_Triangle() {
		width=height=1;
	}
	public Ex01_Triangle(int w, int h) {
		this.width=w;
		this.height=h;
	}
	double calcArea() {
		return this.width*this.height/2.0;
	}
	void output() {
		System.out.println("너비 : "+this.width);
		System.out.println("높이 : "+this.height);
		System.out.println("크기 : "+this.calcArea());
		System.out.println("======================");
	}
}
