package org.joonzis.ex;

public class Ex01_BookMain {
	public static void main(String[] args) {
		// 1. 객체 생성
		Ex01_Book myBook = new Ex01_Book();
		
		// 2. 생성된 객체 활용
		myBook.title="자바의 정석";
		myBook.writer="남궁성";
		myBook.price = 35000;
		myBook.isBestSeller = true;
		
		myBook.info();
		
		Ex01_Book myBook2 = new Ex01_Book();
		myBook2.title="백설공주";
		myBook2.writer="디즈니";
		myBook2.price = 12000;
		myBook2.isBestSeller = true;
		
		myBook2.info();
		
	}
}
