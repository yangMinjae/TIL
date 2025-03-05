package org.joonzis.ex;

public class Ex01_Rect {
	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle();
		Rectangle rec2 = new Rectangle(3,4);
		Rectangle rec3 = new Rectangle(4,4);
		
		rec1.output();
		rec2.output();
		rec3.output();
		
	}
}
class Rectangle{
	private int width, height;
	private boolean isSquare;
	public Rectangle() {
		this(1,1);
	}
	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.isSquare = width == height;
	}
	private int calcArea() {
		return width*height;
	}
	public void output() {
		System.out.println("너비 : " + width);
		System.out.println("높이 : " + height);
		System.out.println("넓이 : " + calcArea());
		System.out.println(isSquare?"정사각형":"직사각형");
		System.out.println();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean isSquare() {
		return isSquare;
	}
	public void setSquare(boolean isSquare) {
		this.isSquare = isSquare;
	}
	
}