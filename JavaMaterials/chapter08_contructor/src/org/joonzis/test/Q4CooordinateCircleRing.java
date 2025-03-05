package org.joonzis.test;

public class Q4CooordinateCircleRing {
	public static void main(String[] args) {
		Circle cir1 = new Circle(new Coordinate(5, 4), 6);
		Circle cir2 = new Circle(new Coordinate(5, 4), 9);
		
		Ring ring1 = new Ring(cir1, cir2);
		ring1.output();
		
		Circle cir3 = new Circle(new Coordinate(0, 3), 9);
		Circle cir4 = new Circle(new Coordinate(3, 2), 3);
		Ring ring2 = new Ring(cir3, cir4);
		
		ring2.output();
		
		Circle cir5 = new Circle(new Coordinate(8, 2), 2);
		Circle cir6 = new Circle(new Coordinate(3, 4), 3);
		Ring ring3 = new Ring(cir5, cir6);
		
		ring3.output();
	}
}
class Coordinate{
	int x, y;

	public Coordinate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	void output(){
		System.out.printf("좌표 : (%d, %d)%n",this.x, this.y);
	}
	
}
class Circle{
	Coordinate center;
	double radius;
	public Circle(Coordinate center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	void output() {
		center.output();
		System.out.println("반지름 : "+this.radius);
	}
	
}
class Ring{
	static int count=0;
	Circle inner;
	Circle outer;
	public Ring(Circle inner, Circle outer) {
		super();
		this.inner = inner;
		this.outer = outer;
	}
	void output() {
		System.out.println("원"+(++count));
		System.out.println("<< 내측 원 >>");
		inner.output();
		System.out.println();
		
		System.out.println("<< 외측 원 >>");
		outer.output();
		System.out.println("=====================");
		System.out.println();
		
	}
}