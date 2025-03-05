package org.joonzis.test;

public class Test02 {
	public static void main(String[] args) {
		Customer cus = new Customer(500, 6);
		cus.buy(new Tv("아날로그md1", 10));
		cus.buy(new Tv("디지털 md1", 25));
		cus.buy(new Tv("oled md1", 70));
		cus.buy(new Tv("oled md2", 75));
		cus.buy(new Computer("rtx2070", 100));
		cus.buy(new Computer("rtx3070", 150));
		cus.output();
		
		Customer cus2 = new Customer(500, 3);
		cus2.buy(new Tv("아날로그md1", 10));
		cus2.buy(new Tv("디지털 md2", 35));
		cus2.buy(new Computer("rtx4080", 300));
		cus2.output();
	}
}
class Product{
	private String model;
	private int price;
	public Product() {}
	public Product(String model, int price) {
		super();
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public int getPrice() {
		return price;
	}
}
class Tv extends Product{
	public Tv() {super();}
	public Tv(String model, int price) {
		super(model, price);
	}
}
class Computer extends Product{
	public Computer() {super();}
	public Computer(String model, int price) {
		super(model, price);
	}
}
class Customer{
	private int money, startMoney, numOfProduct;
	private Product[] cart;
	private static int count = 0;
	public Customer(int startMoney, int numOfProduct) {
		this.money = startMoney;
		this.startMoney = startMoney;
		this.numOfProduct = numOfProduct;
		this.cart = new Product[this.numOfProduct];
	}
	
	public void buy(Product pr) {
		if(money>pr.getPrice()) {
			money-=pr.getPrice();
			for (int i = 0; i < cart.length; i++) {
				if(cart[i]==null) {
					cart[i] = pr;
					return;
				}
			}
		}else {
			System.out.println("금액 한도 초과 ! ");
			System.out.println(pr.getModel()+" 제품 구매 취소");
		}
		
	}
	public void output() {
		System.out.println("고객 "+(++count)+" 구매 상품 : ");
		System.out.println();
		for (int i = 0; i < cart.length; i++) {
			if(cart[i] instanceof Tv) {
				System.out.println("<< TV >>");
			}else if(cart[i] instanceof Computer) {				
				System.out.println("<< 컴퓨터 >>");
			}
			System.out.println("모델 명 : "+cart[i].getModel());
			System.out.println("가격 : "+cart[i].getPrice());
			System.out.println("-----------------------------");
			System.out.println();
		}
		System.out.println("예산 : " + this.startMoney);
		System.out.println("총 사용 금액 : " + (this.startMoney - this.money));
		System.out.println("남은 금액 : " + this.money);
		System.out.println("===============================");
		System.out.println();
		System.out.println();
	}
}