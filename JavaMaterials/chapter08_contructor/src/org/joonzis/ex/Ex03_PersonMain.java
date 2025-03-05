package org.joonzis.ex;

public class Ex03_PersonMain {
	public static void main(String[] args) {
		Ex03_Person person = new Ex03_Person();
		/*
		 * 개발자가 생성자를 하나도!! 구현하지 않았다면
		 * 자바가 디폴트 생성자를 만들어서 호출
		 * 
		 * 개발자가 생성자를 하나라도!! 구현했다면
		 * Person(){} 형태의 생성자가 없을 때 오류 발생
		 */
		Ex03_Person person1 = new Ex03_Person(10, "홍길동", 182, '남');
		person1.output();
	}
}
