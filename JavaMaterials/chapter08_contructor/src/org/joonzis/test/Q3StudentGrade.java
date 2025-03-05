package org.joonzis.test;

public class Q3StudentGrade {
	public static void main(String[] args) {
		Student st1 = new Student("홍길동", "컴공", new Grade(100,50,70));
		st1.output();
		Student st2 = new Student("김철수", "국문", new Grade(60,70,80));
		st2.output();
		Student st3 = new Student("박수학", "수학", new Grade(100,60,40));
		st3.output();
		
		Student st4 = new Student("김바보", "머저리", new Grade(40,30,40));
		st4.output();
	}
}
class Grade{
	int kor, eng, mat;
	double average;
	char grade;
	public Grade(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.average=(kor+eng+mat)/3.0;
		
		switch((int)this.average/10) {
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';
		}
	}
	double getAverage() {
		return this.average;
	}
	char getGrade() {
		return this.grade;
	}
	
}
class Student{
	String name;
	String dept;
	Grade grade;
	public Student(String name, String dept, Grade grade) {
		super();
		this.name = name;
		this.dept = dept;
		this.grade = grade;
	}
	void output() {
		System.out.println("이름 : "+this.name);
		System.out.println("학과 : "+this.dept);
		System.out.printf("성적평균 : %.2f%n",grade.getAverage());
		System.out.printf("학점 : %c%n",grade.getGrade());
		System.out.println();
	}
}
