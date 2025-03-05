package org.joonzis.ex;

public class Ex01_Rect {
	int width, height;
	
	public Ex01_Rect() {}
	public Ex01_Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	void setWidth(int width) {
		this.width = width;
	}
	void setHeight(int height) {
		this.height = height;
	}
	void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
	}
}
