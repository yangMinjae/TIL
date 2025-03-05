package org.joonzis.test;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Student st = new Student();
		st.input();
		st.output();
	}
}
class Student{
	String name, dept, score1, score2;
	double average;
	boolean isPass;
	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		this.name =sc.nextLine();
		
		System.out.print("학과 : ");
		this.dept =sc.nextLine();
		
		System.out.print("과목 1 점수 : ");
		this.score1 =sc.nextLine();
		
		System.out.print("과목 2 점수 : ");
		this.score2 =sc.nextLine();
		System.out.println();
		sc.close();
	}
	void output() {
		this.average=(Integer.parseInt(this.score1)+Integer.parseInt(this.score2))/2.0;
		System.out.println("이름 : "+this.name);
		System.out.println("학과 : "+this.dept);
		System.out.println("평균 : "+average);
		this.isPass=this.average>=80;
		System.out.println(isPass?"합격":"불합격");
	}

}
