package org.joonzis.ex;

public class Ex04_polymorphism {
	public static void main(String[] args) {
		Person persons[] = {new Student(), new Worker()};
		for (int i = 0; i < persons.length; i++) {
			if(persons[i] instanceof Student) {
				((Student)persons[i]).study();
				persons[i].eat("급식");
			}else if(persons[i] instanceof Worker) {
				((Worker)persons[i]).work();
				persons[i].eat("구내식당");
			}
			persons[i].sleep();
			System.out.println();
		}
	}
}
class Person{
	public void eat(String food) {
		System.out.println(food + "먹는다.");
	}
	public void sleep() {
		System.out.println("잔다");
	}
}
class Student extends Person{
	public void study() {
		System.out.println("공부한다.");
	}
}
class Worker extends Person{
	public void work() {
		System.out.println("일한다.");
	}
}