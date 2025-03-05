package org.joonzis.test;

import java.util.Calendar;

public class Q1Car {
	public static void main(String[] args) {
		Car car = new Car("소나타","black",2015);
		car.output();
		
		Car car2 = new Car("소나타","black");
		car2.output();
		
	}
}

class Car{
	String model, color;
	int year;
	boolean isNewCar;
	static Calendar calendar = Calendar.getInstance();
	public Car(String model, String color, int year) {
		super();
		this.model = model;
		this.color = color;
		this.year = year;
		this.isNewCar=calendar.get(Calendar.YEAR)==year;
	}
	Car(String model, String color){
		this(model,color,calendar.get(Calendar.YEAR));
	}
	void output() {
		System.out.println("차종 : "+this.model);
		System.out.println("색상 : "+this.color);
		System.out.println("연식 : "+this.year);
		System.out.println(this.isNewCar?"최신":"구식");
		System.out.println();
	}
	     
}
