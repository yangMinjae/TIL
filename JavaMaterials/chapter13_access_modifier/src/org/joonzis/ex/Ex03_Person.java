package org.joonzis.ex;

public class Ex03_Person {
	public static void main(String[] args) {
		Person ps1 = new Person();
		ps1.setName("김씨");
		ps1.setAge(30);
		ps1.setGender('남');
		ps1.setHeight(152.2);
		
		System.out.println(ps1.getName());
	}
}
class Person{
	private String name;
	private int age;
	private double height;
	private char gender;
	
	public Person() {}
	public Person(String name, int age, double height, char gender) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
}
