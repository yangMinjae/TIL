package org.joonzis.ex;

public class Ex03_TeamMain {
	public static void main(String[] args) {
		Ex03_Team member1 = new Ex03_Team("김씨");
		member1.output();

		Ex03_Team member2 = new Ex03_Team("이씨");
		member2.output();
		
		Ex03_Team member3 = new Ex03_Team("박씨");
		member3.output();
		
		System.out.println("전체 팀원 : "+Ex03_Team.count+"명");
	}
}
