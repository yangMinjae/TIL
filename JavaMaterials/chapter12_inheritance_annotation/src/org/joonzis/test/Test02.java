package org.joonzis.test;

public class Test02 {
	public static void main(String[] args) {
		NoteBook nt1 = new NoteBook("LG그램1", 1000, 20, false);
		NoteBook nt2 = new NoteBook("LG그램2", 1000, 20, true);
		nt1.output();
		nt2.output();
		
		Tablet tb1 = new Tablet("갤럭시 탭", 1200, 17, "S펜");
		Tablet tb2 = new Tablet("아이패드", 1400, 16, "애플펜");
		tb1.output();
		tb2.output();
		
	}
}
class Computer{
	String model;
	int price;
	public Computer() {}
	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}
	void output() {
		System.out.println("모델명 : "+this.model);
		System.out.println("가격 : "+this.price+"$");
	}
}
class PortableComputer extends Computer{
	int battery;
	public PortableComputer() {}
	public PortableComputer(String model, int price, int battery) {
		super(model, price);
		this.battery = battery;
	}
	void output() {
		super.output();
		System.out.println("배터리 : "+this.battery+"Ah");		
	}
}
class NoteBook extends PortableComputer{
	boolean wifi;
	public NoteBook(){}
	public NoteBook(String model, int price, int battery, boolean wifi) {
		super(model, price, battery);
		this.wifi = wifi;
	}
	void output() {
		super.output();
		System.out.println("wifi : "+(wifi?"내장":"비 내장"));
		System.out.println();
	}
}
class Tablet extends PortableComputer{
	String pen;
	public Tablet() {}
	public Tablet(String model, int price, int battery, String pen) {
		super(model, price, battery);
		this.pen = pen;
	}
	void output() {
		super.output();
		System.out.println("펜 : "+this.pen);		
		System.out.println();
	}
}