package org.joonzis.ex;

public class Ex02_Inheritance {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.eat("급식");
		stu.study();
		stu.sleep();
		
		System.out.println("-----------------");
		
		Worker wor = new Worker();
		wor.eat("점심");
		wor.work();
		wor.sleep();
	}
}
class Person{
	void sleep() {
		System.out.println("잔다");
	}
	void eat(String food) {
		System.out.println(food+"먹는다");
	}
}
class Student extends Person{
	void study() {
		System.out.println("공부한다.");
	}
}
class Worker extends Person{
	void work() {
		System.out.println("일한다");
	}
}