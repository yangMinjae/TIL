package org.joonzis.ex;

public class Ex01_Book {
	// 필드
	String title;
	String writer;
	int price;
	boolean isBestSeller;
	
	// 메소드
	void info() {
		System.out.println("제목 : "+title);
		System.out.println("저자 : "+writer);
		System.out.println("가격 : "+price);
		System.out.println(isBestSeller?"베스트셀러":"일반서적");
	}

}
