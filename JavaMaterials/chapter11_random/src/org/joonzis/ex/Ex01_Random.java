package org.joonzis.ex;

import java.util.Random;

public class Ex01_Random {
	public static void main(String[] args) {
		// 1.Random 클래스 이용
		Random ran = new Random();
		// 난수 발생(모든범위)
		System.out.println(ran.nextInt());
		// 난수 발생(0~9)
		System.out.println(ran.nextInt(10));
		
		// 0~5
		System.out.println(ran.nextInt(6));
		// 1~6
		System.out.println(ran.nextInt(6)+1);
		
		// 0~0.999
		System.out.println(ran.nextDouble());
		// 0~9.999
		System.out.println(ran.nextDouble()*10);
		// 0~9
		System.out.println((int)ran.nextDouble()*10);
		// 1~6
		System.out.println((int)(ran.nextDouble()*6)+1);
		
		// 2. Math.random() 이용
		// 1~6까지의 값
		System.out.println((int)(Math.random()*6)+1);
		
	}
}
