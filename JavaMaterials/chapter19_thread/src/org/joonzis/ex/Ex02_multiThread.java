package org.joonzis.ex;

class MyThread extends Thread{
	// 1. Thread 클래스를 상속 받아 정의
	// run() 메소드를 재정의하여 스레드가 실행할 코드를 작성
	private String str;
	public MyThread(String str) {
		this.str = str;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(500);											// 밀리초 단위
				System.out.println(str);				
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		super.run();
	}
	
}

public class Ex02_multiThread {

	public static void main(String[] args) {
		// run() 메소드를 호출하면 단순히 클래스에 속한 메소드를 호출
		// start() 메소드는 스레드 작업을 실행할때에
		// 필요한 호출 스택을 생성한 다음 run()호출
		System.out.println("Main Thread Start");
		
		MyThread mt1 = new MyThread("*");
		MyThread mt2 = new MyThread("-");
		
		mt1.start();
		mt2.start();
		
		System.out.println("Main Thread End");
		// -> 쓰레드 3개 운영
		
	}

}
