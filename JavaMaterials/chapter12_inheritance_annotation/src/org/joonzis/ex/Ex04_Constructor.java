package org.joonzis.ex;

public class Ex04_Constructor {
	public static void main(String[] args) {
		Dog dog1 = new Dog();
		dog1.whoAmI();
		System.out.println("-------------------------");
		
		Dog dog2 = new Dog("김씨");
		dog2.whoAmI();
		System.out.println("-------------------------");
		
		Dog dog3 = new Dog("이씨","김쿠키");
		dog3.whoAmI();
		System.out.println("-------------------------");
	}
}
class Animal{
	String name;
	public Animal() {
	}
	public Animal(String name) {
		this.name = name;
	}
}
class Dog extends Animal{
	String personName;
	public Dog() {}
	public Dog(String personName) {
		super();
		this.personName = personName;
	}
	public Dog(String personName, String name) {
		super(name);
		this.personName = personName;
	}
	void whoAmI() {
		System.out.println("내 이름은 "+name+"이고, 주인은 "+personName+"입니다.");
	}
}