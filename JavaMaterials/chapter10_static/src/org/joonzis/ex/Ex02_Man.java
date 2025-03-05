package org.joonzis.ex;

public class Ex02_Man {
	String name;
	int age;
	static final char GENDER = '남';	// 상수는 대문자로 쓰는게 관례
	
	public Ex02_Man(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void output() {
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("성별 : "+GENDER);
	}
}
