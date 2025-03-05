package org.joonzis.ex;

public class Ex07_continue {
	public static void main(String[] args) {
		 // while문을 이용해서 1~10 출력
		// (3의 배수는 제외)
		int i=0;
		while(i<10) {
			i++;
			if(i%3==0)continue;
			System.out.println(i);
		}
	}
}
