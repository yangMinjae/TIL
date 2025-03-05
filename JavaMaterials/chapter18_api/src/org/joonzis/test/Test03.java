package org.joonzis.test;

public class Test03 {

	public static void main(String[] args) {
		Circle cir1 = new Circle(0, 0, 1.5);
		Circle cir2 = new Circle(0, 0, 1.5);
		Circle cir3 = new Circle(2,2,3.3);
		System.out.println(cir1.equals(cir2)?"같은 원":"다른 원");
		System.out.println(cir1.equals(cir3)?"같은 원":"다른 원");
	}

}
class Coordinate{
	private int x, y;

	public Coordinate(int x,int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		Coordinate cor = (Coordinate)obj;
		return cor.x==this.x && cor.y==this.y;
	}
	
}
class Circle{
	private Coordinate center;
	private double radius;
	public Circle(int a, int b, double radius) {
		super();
		this.center = new Coordinate(a,b);
		this.radius = radius;
	}
	@Override
	public boolean equals(Object obj) {
		Circle tmp = (Circle)obj;
		return tmp.center.equals(this.center) && tmp.radius == this.radius;
	}
	public Coordinate getCenter() {
		return center;
	}
	public double getRadius() {
		return radius;
	}
}