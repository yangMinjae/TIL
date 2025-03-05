package org.joonzis.ex;

public class Ex02_Local {
	String name;
	int age;
	String sn;			// 주민등록 번호
	boolean isKorean;   // 한국인 유무
	
	// 메소드
	// setLocalInfo
	// 이름, 나이, 주민등록번호를 전달 받아 필드 초기화
	// 주민등록번호 뒷 자리의 첫 번째 값이 1~4일 경우 한국인
	void setLocalInfo(String name, int age, String sn) {
		this.name=name;
		this.age=age;
		this.sn=sn;
		int nat=sn.charAt(6)-'0';
		isKorean=(nat>0&&nat<5);
	}
	
	// setLocalInfo
	// 이름, 나이를 전달 받아 필드 초기화
	void setLocalInfo(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	// output
	// 이름, 나이, 주민등록번호, 한국인 or 외국인 출력
	// 주민등록 번호가 없으면 "없음"으로 출력
	
	void output() {
		System.out.println("<< 인물정보 >>");
		System.out.println("성함 : "+this.name);
		System.out.println("나이 : "+this.age);

		if(sn==null) {
			System.out.println("주민번호 : "+"주민번호 미입력");
			System.out.println("국적 : "+"주민번호를 입력해주세요");
			
		}else {
			System.out.println("주민번호 : "+this.sn);
			System.out.println("국적 : "+(this.isKorean?"한국인":"외국인"));
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Ex02_Local loc = new Ex02_Local();
		loc.setLocalInfo("홍길동", 19, "9908061111111");
		loc.output();
		
		Ex02_Local loc2 = new Ex02_Local();
		loc2.setLocalInfo("김철수", 20);
		loc2.output();
		
	}
}
