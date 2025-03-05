package org.joonzis.ex;

public class Ex03_System {

	public static void main(String[] args) {
		
		// 반복 중 특정 회차가 되었을때 시스템 종료
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			try {
				if(i == 4) {
											// ** 객체 소멸, 자료(메모리) 정리 선행 후 종료!!**
					System.exit(i);
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			}

		}
	}

}
