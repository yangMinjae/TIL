package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		Student st1 = new Student("홍길동", 15, "초지고");
		st1.output();
		
		Worker wo1 = new Worker("스탈린 동무", 47, "소련 서기장");
		wo1.output();
	}
}
class Student extends Person{
	String school = "학교 정보 없음";
	public Student() {
		super();
	}
	public Student(String name, int age) {
		super(name, age);
	}
	public Student(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}
	void output() {
		super.output();
		System.out.println("학교 : " + this.school);
		System.out.println();
	}
}
class Worker extends Person{
	String job = "직업 정보 없음";
	public Worker() {
		super();
	}
	public Worker(String name, int age, String job) {
		super(name, age);
		this.job = job;
	}
	public Worker(String name, int age) {
		super(name, age);
	}
	void output() {
		super.output();
		System.out.println("직업 : " + this.job);
		System.out.println();
	}
}
class Person{
	String name;
	int age;
	public Person() {
		this("신원미상",0);
	}
	public Person(String name) {
		this(name,0);
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	void output() {
		System.out.println("이름 : " + this.name);
		System.out.println("나이 : " + this.age);
		
	}
}