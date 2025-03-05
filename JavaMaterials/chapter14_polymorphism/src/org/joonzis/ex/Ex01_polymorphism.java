package org.joonzis.ex;

public class Ex01_polymorphism {
	public static void main(String[] args) {
		Product pro = new Product();
		pro.info();
		
		Product com = new Computer();
		com.info();
		
		Product note = new Notebook();
		note.info();
		System.out.println("------------------------");
		// 객체배열 이용
		Product[] product = new Product[20];
		product[0] = new Computer();
		product[1] = new Notebook();
		
		product[0].info();
		product[1].info();
	}
}
class Product{
	void info() {
		System.out.println("Product");
	}
}
class Computer extends Product{
	void info() {
		System.out.println("Computer");
	}
}
class Notebook extends Computer{

	@Override
	void info() {
		System.out.println("Notebook");
	}
	
}