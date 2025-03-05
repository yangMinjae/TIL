package org.joonzis.test;

public class CarMain {
	public static void main(String[] args) {
		Car car1 = new Car();
		car1.setFields("k5", "black");
		car1.output();
		
		Car car2 = new Car();
		car2.setFields("k9", "white", 2021);
		car2.output();
		
	}
}
