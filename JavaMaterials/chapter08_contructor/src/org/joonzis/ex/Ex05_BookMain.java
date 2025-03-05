package org.joonzis.ex;

public class Ex05_BookMain {
	public static void main(String[] args) {
		Ex05_Book book1 = new Ex05_Book();
		Ex05_Book book2 = new Ex05_Book("흥부와 놀부",18000);
		Ex05_Book book3 = new Ex05_Book("돈의 속성","김승호", 16000);
		Ex05_Book book4 = new Ex05_Book("지루한 책","홍길동", 150000);
		book2.setSalesVolume(1000000);
		book3.setSalesVolume(20000);
		book4.setSalesVolume(10);
		
		book1.output();
		book2.output();
		book3.output();
		book4.output();

	}
}
