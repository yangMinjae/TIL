package org.joonzis.ex;
class Person{
	char gender;
	int age;
	double height;
	String name;
	
	void info() {
		System.out.println("성별 : "+gender);
		System.out.println("나이 : "+age);
		System.out.println("키 : "+height);
		System.out.println("이름 : "+name);
		System.out.println();
	}
}
public class Ex02_PersonMain {
	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		
		person1.gender='여';
		person1.age=20;
		person1.height=160.5;
		person1.name="영희";
		
		person2.gender='남';
		person2.age=21;
		person2.height=180.5;
		person2.name="철수";
		
		person1.info();
		person2.info();
	}
}
