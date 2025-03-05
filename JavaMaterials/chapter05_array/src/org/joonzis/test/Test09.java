package org.joonzis.test;

import java.util.Scanner;

public class Test09 {
	public static void main(String[] args) {
		String[] subjectArr = {"Java", "Python", "Android", "JSP", "Javascript"};
		int[] scoreArr = {95, 88, 78, 62, 55};
		Scanner sc = new Scanner(System.in);
		String tmp;
		while(true) {
			System.out.println("종료시 \"그만\"입력");
			System.out.print("과목 : ");
			tmp=sc.nextLine();
			int i=0;
			for (; i < subjectArr.length; i++) {
				if(subjectArr[i].equals(tmp))break;
			}
			if(i==5) {
				if(tmp.equals("그만")) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("일치하는 과목명이 없습니다. 오타를 확인하세요");
					System.out.println("=============================");
					continue;
				}
			}
			System.out.println("점수는"+scoreArr[i]+"점입니다.");
			System.out.println("================================");
		}
		sc.close();
	}
}
