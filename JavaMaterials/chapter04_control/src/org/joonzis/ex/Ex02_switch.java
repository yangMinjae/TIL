package org.joonzis.ex;

public class Ex02_switch {

	public static void main(String[] args) {
		
		String gender = "남";
		
		if(gender.equals("남")) {
			System.out.println("남자 입니다.");
		}else {			
			System.out.println("여자 입니다.");
		}
		
		switch(gender) {
			case "남":
				System.out.println("남자 입니다.");
				break;
			default:
				System.out.println("여자 입니다.");
			
		}
	}

}
