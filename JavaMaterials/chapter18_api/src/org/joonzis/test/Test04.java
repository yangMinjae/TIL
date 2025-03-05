package org.joonzis.test;

public class Test04 {

	public static void main(String[] args) {
		Student st1 = new Student("1111", "홍길동");
		Student st2 = new Student("1111", "홍길동");
		Student st3 = new Student("1113", "박길동");
		Student st4 = new Student("1115", "김길동");
		st1.setScores(100,60,70);
		st2.setScores(100,60,70);
		st3.setScores(40,60,30);
		st4.setScores(90,90,90);
		st1.setAverage();
		st1.setGrade();
		st2.setAverage();
		st2.setGrade();
		st3.setAverage();
		st3.setGrade();
		st4.setAverage();
		st4.setGrade();
		System.out.println(st1);
		System.out.println(st2);
		System.out.println(st3);
		System.out.println(st4);
		
		System.out.println();
		System.out.println(st1.equals(st2)?"같은 학생":"다른 학생");
		System.out.println(st2.equals(st3)?"같은 학생":"다른 학생");
				
	}

}
class Student{
	private String no, name;
	private int[] scores = new int[3];
	private double average;
	private char grade;
	private static final int COURSE_COUNT = 3;
	Student(String no, String name){
		this.no=no;
		this.name=name;
	}
	public void setScores(int kor, int eng, int mat) {
		scores[0]=kor;
		scores[1]=eng;
		scores[2]=mat;
	}
	public void setScores(int[] scores) {
		this.scores=scores;
	}
	public void setAverage() {
		int sum=0;
		for (int i = 0; i < scores.length; i++) {
			sum+=scores[i];
		}
		this.average = (double)sum/COURSE_COUNT;
	}
	public void setGrade() {
		switch ((int)(this.average/10)) {
		case 9:
			this.grade='A';
			break;
		case 8:
			this.grade='B';
			break;
		case 7:
			this.grade='c';
			break;
		case 6:
			this.grade='D';
			break;
		default:
			this.grade='F';
			break;
		}
	}
	@Override
	public boolean equals(Object obj) {
		Student st = (Student)obj;
		return this.no==st.no;
	}
	@Override
	public String toString() {
		return "학번 : "+no+", 성명 : "+name+", 평균 : "+average+"학점 : "+grade;
	}
	
}