package src.org.joonzis.ex;

import java.util.Scanner;

public class Ex01_input {
	public static void main(String[] args) {
		/*
		 * 1. Scanner 클래스
		 * 
		 *  1) console창을 통한 입력
		 *  
		 *  2) java.util.Scanner 클래스로 존재
		 *  	(1) java.util.Scanner 로 사용
		 *  	(2) import 후 사용
		 *  		import 대상 : java.lang 이외의 모든 클래스
		 *  
		 *  3) Scanner 클래스의 객체 생성 방법
		 *  	Scanner 객체명 = new Scanner(입력스트림);
		 *  
		 *  4) Scanner 클래스의 객체 소멸 방법
		 *  	객체명.close();
		 *  
		 *  5) Scanner 클래스의 메소드
		 *  	(1) 문자열 입력
		 *  		- next() : 공백 전까지 입력
		 *  		- nextLine() : 엔터 전까지 입력
		 *  	(2) 정수 입력
		 *  		- nextInt(), nextByte(), nextShort(), nextLong()
		 *  	(3) 실수 입력
		 *  		- nextDouble(), nextFloat()
		 *  	(4) 논리 이력
		 *  		- nextBoolean()
		 *  	(5) 문자 입력
		 *  		- 문자열 입력(next(),nextLine()) 받은 뒤 첫번째 값(charAt(0))만 사용
		 *  		ex) String s = "happy"; -> s.charAt(0) == 'h'
		 */
		
		// 1. Scanner 객체(인스턴스) 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine(); // 문자열(엔터까지)
		
		System.out.print("나이 입력 >> ");
		int age = sc.nextInt();
		
		System.out.print("키 입력 >> ");
		double height = sc.nextDouble();
		
		sc.nextLine();	// nextInt(), nextDouble()의 개행 문자 삭제
		
		System.out.print("성별 입력 >> ");
		String gender = sc.nextLine();
		
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("성별 : " + gender);
		
		
		
		// 스캐너 객체 소멸
		sc.close();
		
		
	}
}
