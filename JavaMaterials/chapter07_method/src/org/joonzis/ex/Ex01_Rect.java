package org.joonzis.ex;

public class Ex01_Rect {
	// 필드
	int width, height; // 너비, 높이
	boolean isSquare;  // 정사각형 유무
	
	// 메소드
	// 1. 필드 초기화 메소드
	void setFields(int w, int h) {
		this.width=w;
		this.height=h;
		this.isSquare=this.height==this.width;
	}
	void setFields(int side) {
		this.width=this.height=side;
		this.isSquare=true;
	}
	// 2. 사각형 크기 계산 메소드
	int calcArea() {
		return this.width*this.height;
	}
	// 3. 정보 출력 메소드
	void output() {
		// 너비, 높이, 정사각형or직사각형, 크기
		// 출력
		System.out.println("<< 사각형 정보 >> ");
		System.out.println("너비 : "+width+", 높이 : "+height);
		System.out.println("크기 : "+calcArea());
		System.out.println(isSquare? "정사각형":"직사각형");
	}
	
}
