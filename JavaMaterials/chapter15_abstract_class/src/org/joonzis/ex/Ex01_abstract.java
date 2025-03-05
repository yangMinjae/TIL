package org.joonzis.ex;

public class Ex01_abstract {
	public static void main(String[] args) {
		// Animal animalx = new Animal();	->객체 생성 불가
		Animal animal = new Dog();
		animal.eat("사료");
		animal.move();
	}
}
abstract class Animal{					// 추상 클래스 - 일반 메서드와 추상 메서드 모두 가질 수 있다.
	public void eat(String food) {
		System.out.println("먹는다");
	}
	abstract public void move();
}
class Dog extends Animal{
	@Override
	public void move() {
	System.out.println("강아지 산책한다.");
		
	}
}