package org.joonzis.ex;

public class Ex03_polymorphism {
	public static void main(String[] args) {
		Animal[] animals = {new Dog(), new Dolphin(), new Eagle()};
		// 업캐스팅
		for (int i = 0; i < animals.length; i++) {
			animals[i].move();
		}
		// animals[2].fly(); -> Animal에 존재하지 않으므로 호출 불가
		// ((Eagle)animals[2]).fly(); -> 배열에 들어있는 객체가 다를 수 있으므로 안전하지 않음
		if(animals[2] instanceof Eagle) {
			// 다운 캐스팅
			// 1. Eagle 객체 생성
			
			/*
			Eagle eagle = (Eagle)animals[2];
			eagle.fly();
			*/
			
			// 2. 객체 생성 없이 사용
			((Eagle)animals[2]).fly();
		}
		
		System.out.println("--------------------------");
		for (int i = 0; i < animals.length; i++) {
			animals[i].move();
			if(animals[i] instanceof Eagle) {
				((Eagle)animals[i]).fly();
			}
		}
	}
}
class Animal{
	public void move() {}
}
class Dolphin extends Animal{
	@Override
	public void move() {
		System.out.println("돌고래 헤엄친다.");
	}
}
class Eagle extends Animal{
	@Override
	public void move() {
		System.out.println("독수리 움직이고");
	}
	public void fly() {
		System.out.println("난다.");
	}
}
class Dog extends Animal{

	@Override
	public void move() {
		System.out.println("개 움직인다.");
	}
	
}