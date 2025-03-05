package org.joonzis.ex;

public class Ex05_exception {
	public static void main(String[] args) {
		// 예외 처리
		// 1. try-catch
		try {
			verifyDog(new Dog());
			verifyDog(new Crocodile());
			
		} catch (ClassCastException e) {
			System.out.println("강아지가 아니라서 같이 잘 수 없다.");
		}

	}
	public static void verifyDog(Animal animal) {
		animal.walk();
		// 2. 
		/*
		 if(animal instanceof Dog) {
			((Dog) animal).sleepTogether();
		  }
		 */

		((Dog)animal).sleepTogether();
	}
}
interface Animal{
	public void walk();
}
class Dog implements Animal{
	@Override
	public void walk() {
		System.out.println("산책한다.");
	}
	public void sleepTogether() {
		System.out.println("같이 잔다.");
	}
}
class Crocodile implements Animal{
	@Override
	public void walk() {
		System.out.println("악어 피해 도망간다.");
	}
}