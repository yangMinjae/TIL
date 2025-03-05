package org.joonzis.test2;

public class Test03 {

	public static void main(String[] args) {
		System.out.println("구구단을 외자");
		System.out.println();
		for(int i =2;i<10;i++) {
			System.out.println(i+"단");
			for(int j = 1 ;j<10;j++) {
				System.out.printf("%dx%d = %d%n",i,j,i*j);
			}
			System.out.println();
		}
	}

}
