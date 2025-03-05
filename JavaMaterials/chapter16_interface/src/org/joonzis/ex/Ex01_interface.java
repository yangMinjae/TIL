package org.joonzis.ex;

public class Ex01_interface {
	public static void main(String[] args) {
		Animal animal = new Dog();				//인터페이스도 업캐스팅 가능
		animal.move();
		animal.eat("사료");
	}
}
interface Animal{
	public void move();
	public void eat(String food);
}
class Dog implements Animal{
	@Override
	public void eat(String food) {		
		System.out.println(food +"먹고");
	}
	@Override
	public void move() {
		System.out.println("강아지 산책");	
	}
}