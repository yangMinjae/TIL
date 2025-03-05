package org.joonzis.test;

public class DogMain {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.setDog("뽀삐", 3);
		dog1.info();
		
		Dog dog2 = new Dog();
		dog2.setDog("초코", 2, "요크셔테리어");
		dog2.info();
	}
}
