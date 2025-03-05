package org.joonzis.test;

import java.util.Scanner;

public class Test05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳 입력 : ");
		char a=sc.nextLine().charAt(0);
		if('Z'>=a&&a>='A') {
			System.out.println((char)('a'+(a-'A')));
		}else if('z'>=a&&a>='a') {			
			System.out.println((char)('A'+(a-'a')));
		}else {
			System.out.println(a);
		}
		sc.close();
	}	
}
