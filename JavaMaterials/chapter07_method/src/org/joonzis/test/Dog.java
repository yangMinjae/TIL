package org.joonzis.test;

public class Dog {
	String name,breed;
	int age;
	void setDog(String name, int age) {
		this.name=name;
		this.age=age;
		this.breed="푸들";
	}
	void setDog(String name, int age, String breed) {
		this.name=name;
		this.age=age;
		this.breed=breed;
	}
	void info() {
		System.out.println("이름 : "+this.name);
		System.out.println("나이 : "+this.age);
		System.out.println("품종 : "+this.breed);
		System.out.println("============================");
	}
}
