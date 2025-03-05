package org.joonzis.ex;

public class Ex05_Method_override {
	public static void main(String[] args) {
		Latte latte1 = new Latte();
		latte1.taste();
		
		Latte latte2 = new Latte("서울우유", "콜롬비아");
		latte2.taste();
	}
}
class Espresso{
	String origin;
	public Espresso() {}
	public Espresso(String origin) {
		this.origin=origin;
	}
	void taste() {
		System.out.println("쓰다");
	}
}
class Latte extends Espresso{
	String milk;
	public Latte() {}
	public Latte(String milk,String origin) {
		super(origin);
		this.milk = milk;
	}
	@Override
	void taste() {
		System.out.println("원산지 : "+origin + ", 우유 : " + milk);
		System.out.println("부드럽다");
	}
	
}
