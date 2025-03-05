package org.joonzis.ex;

public class Ex05_yield {

	public static void main(String[] args) {
		WorkThread workThreadA = new WorkThread("workThreadA");
		WorkThread workThreadB = new WorkThread("workThreadB");
		workThreadA.start();
		workThreadB.start();
		
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
		workThreadA.work=false;
		try {
			Thread.sleep(5000);
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
		workThreadA.work=true;
	}
}
class WorkThread extends Thread{
	public boolean work = true;
	
	public WorkThread(String name) {
		setName(name);
	}
	
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName()+": 작업처리");
				try {
					Thread.sleep(1000);
				}catch (InterruptedException e) {
					// TODO: handle exception
				}
			}else {
				Thread.yield();
			}
		}
	}
}