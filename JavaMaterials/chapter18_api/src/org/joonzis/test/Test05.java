package org.joonzis.test;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		System.out.print("성 : ");
		sb1.append(sc.next());
		System.out.print("이름 : ");
		sb1.append(sc.next());
		System.out.println(sb1);
		System.out.println("------------------------");
		
		System.out.print("성 : ");
		sb2.append(sc.next());
		System.out.print("이름 : ");
		sb2.append(sc.next());
		System.out.println(sb2);
		System.out.println("========================");
		System.out.println(sb1.toString().equals(sb2.toString())?"같은이름":"다른이름");
		sc.close();
	}
}
