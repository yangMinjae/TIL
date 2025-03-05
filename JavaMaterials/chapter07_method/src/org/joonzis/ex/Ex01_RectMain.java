package org.joonzis.ex;

public class Ex01_RectMain {
	public static void main(String[] args) {
		Ex01_Rect rec = new Ex01_Rect();
		rec.setFields(10, 20);
		rec.output();
		
		Ex01_Rect rec2 = new Ex01_Rect();
		rec2.setFields(15);
		rec2.output();
	}
}
