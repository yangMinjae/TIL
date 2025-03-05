package org.joonzis.ex;

public class Ex06_join {

	public static void main(String[] args) {
		SumThread sum = new SumThread();
		Thread th1 = new Thread(sum);
		th1.start();
		/*
		try {
			th1.join();			
		}catch (InterruptedException e) {
			// TODO: handle exception
		}*/		//-> 이코드는 메인스레드를 th1스레드가 종료할때까지 일시정지 상태로 만든다.
		System.out.println("합 : "+sum.getSum());
	}
}
class SumThread implements Runnable{
	private long sum;
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
	}
	
}