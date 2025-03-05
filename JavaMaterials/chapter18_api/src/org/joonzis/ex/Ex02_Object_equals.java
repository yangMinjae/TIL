package org.joonzis.ex;

public class Ex02_Object_equals {

	public static void main(String[] args) {
		Computer com1 = new Computer("삼성", 100);
		Computer com2 = new Computer("삼성", 100);
		
		// 1. == : 참조 비교 ( 주소 비교 )
		if(com1 == com2) {
			System.out.println("같은 컴퓨터");
		}else {
			System.out.println("다른 컴퓨터");
		}
		
		// 2. equals()
		if(com1.equals(com2)) {
			System.out.println("같은 컴퓨터");
		}else {
			System.out.println("다른 컴퓨터");
		}
	}

}
class Computer{
	private String model;
	private int price;
	public Computer(String model, int price) {
		this.model = model;
		this.price = price;
	}
	@Override
	public String toString() {
		return "모델 : " + model + ", 가격 : " + price;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Computer) {
			return this.price == ((Computer)obj).price && this.model.equals(((Computer)obj).model);
		}
		return super.equals(obj);
	}
}