package org.joonzis.ex;

public class Ex01_if {
	public static void main(String[] args) {
		int num =20;
		//변수의 값이 양수인지, 음수인지, 0인지 판단
		if(num>0) {
			System.out.println("양수");
		}else if(num==0) {
			System.out.println(0);
		}else {
			System.out.println("음수");
		}
		
		double avg = 82.3;// 평균점수
		// 평균 점수가 90 이상이면 A
		// 80점이상이면 B
		// 70점이상이면 C
		// 60점이상이면 D
		// 60전미만이면 F 출력
		if(avg>=90) {
			System.out.println("A");
		}else if(avg>=80) {
			System.out.println("B");
		}else if(avg>=70) {
			System.out.println("C");
		}else if(avg>=60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
