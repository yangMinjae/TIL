package org.joonzis.ex;
// 자식 클래스의 생성자는 부모 클래스의 생성자를 먼저 호출한다.
// 자식을 만드려면 부노 먼저만들어야 한다.
public class Ex03_Constructor {
	public static void main(String[] args) {
		Son son = new Son();
		son.doSon();
	}
}
class Mother{
	public Mother() {
		System.out.println("Mother 객체 생성");
	}
}
class Son extends Mother{
	public Son() {
		System.out.println("Son 객체 생성");
	}
	void doSon() {
		System.out.println("doSon() 호출");
	}
}
