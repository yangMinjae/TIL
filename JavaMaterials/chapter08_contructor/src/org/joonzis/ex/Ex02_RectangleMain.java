package org.joonzis.ex;

public class Ex02_RectangleMain {
	public static void main(String[] args) {
		Ex02_Rectangle rec1 = new Ex02_Rectangle();
		Ex02_Rectangle rec2 = new Ex02_Rectangle(5);
		Ex02_Rectangle rec3 = new Ex02_Rectangle(4,12);
		
		rec1.output();
		rec2.output();
		rec3.output();
	}
}
