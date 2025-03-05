package org.joonzis.test2;

public class Test04 {

	public static void main(String[] args) {
		for(int i =1;i<10;i++) {
			for(int j = 2 ;j<10;j++) {
				System.out.printf("%dx%d = %-5d  ",j,i,i*j);
			}
			System.out.println();
		}
	}

}
