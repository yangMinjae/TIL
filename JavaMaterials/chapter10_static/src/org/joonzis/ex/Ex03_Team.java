package org.joonzis.ex;

public class Ex03_Team {
	String name;
	static int count = 0;
	{count++;}
	public Ex03_Team(String name) {
		super();
		this.name = name;
	}
	
	void output() {
		System.out.println("이름 : "+name);
		System.out.println("현재 팀원 : "+count+"명");
		System.out.println();
	}
}
