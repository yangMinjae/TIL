package org.joonzis.ex;

public class Ex02_ManMain {
	public static void main(String[] args) {
		Ex02_Man man = new Ex02_Man("김씨", 100);
		
		man.output();
		
		char a = man.GENDER;	// 노란줄 이유- static인데 객체 변수명 통해 호출해서
	}
}
