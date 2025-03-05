package org.joonzis.ex;

public class Ex02_Student {
	public static void main(String[] args) {
		Student st1 = new Student("김천재", "컴공",100,100);
		Student st2 = new Student("김바보", "건축",40,50);
		st1.output();
		st2.output();
	}
}
class Student{
	private String name, dpt;
	private int score1, score2;
	private double average;
	private boolean isPass;
	public Student() {}
	public Student(String name, String dpt, int score1, int score2) {
		super();
		this.name = name;
		this.dpt = dpt;
		this.score1 = score1;
		this.score2 = score2;
	}
	private boolean isPass() {
		this.average=(score1+score2)/2.0;
		this.isPass = average>=80;
		return isPass;
	}
	public void output() {
		System.out.println("이름 : " + this.name);
		System.out.println("학과 : " + this.dpt);
		System.out.println("과목 1 점수 : "+this.score1);
		System.out.println("과목 2 점수 : "+this.score2);
		System.out.println("평균 : "+this.average);
		System.out.println(this.isPass()?"합격":"불합격");
		System.out.println();
	}
	
}
