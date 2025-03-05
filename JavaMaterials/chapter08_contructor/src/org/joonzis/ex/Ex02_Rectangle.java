package org.joonzis.ex;

public class Ex02_Rectangle {
	int width, height;
	public Ex02_Rectangle() {
		this.width=1;
		this.height=1;
	}
	public Ex02_Rectangle(int side) {
		this.width=this.height=side;
	}
	public Ex02_Rectangle(int w, int h) {
		this.width=w;
		this.height=h;
	}
	int calcArea() {
		return this.width*this.height;
	}
	void output() {
		System.out.println("너비 : "+this.width);
		System.out.println("높이 : "+this.height);
		System.out.println("크기 : "+this.calcArea());
		System.out.println(this.width==this.height?"정사각형":"직사각형");
		System.out.println("==========================");
	}
}
