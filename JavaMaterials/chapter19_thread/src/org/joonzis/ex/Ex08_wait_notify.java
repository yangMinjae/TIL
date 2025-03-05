package org.joonzis.ex;

public class Ex08_wait_notify {
	static void threadSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Market m = new Market();
		ProducerThread pt = new ProducerThread(m);
		ConsumerThread ct = new ConsumerThread(m);
		
		pt.start();
		ct.start();
		
		try {
			pt.join();
			ct.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%nResult: " + m.getCount_product());
	}
	
}
class Market {
	private int count_product = 0;
	final private int MAX = 3; 
	final private int MIN = 0;
	
	synchronized public void add() {
		System.out.print("[추가전" + count_product + "]");
		while (count_product >= MAX) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		count_product++;
		notifyAll();
		System.out.print("[추가후" + count_product + "]");
	}
	
	synchronized public void remove() {
		System.out.print("[삭제전" + count_product + "]");
		while (count_product <= MIN) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count_product--;
		notifyAll();
		System.out.print("[삭제후" + count_product + "]");
		
	}

	synchronized public int getCount_product() {
		return count_product;
	}
}

class ProducerThread extends Thread {
	Market m;
	
	public ProducerThread(Market m) {
		this.m = m;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {	
			Ex08_wait_notify.threadSleep((int)(Math.random()*10));
			m.add();
		}
	}
}

class ConsumerThread extends Thread {
	Market m;
	
	public ConsumerThread(Market m) {
		this.m = m;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			Ex08_wait_notify.threadSleep((int)(Math.random()*10));
			m.remove();
		}
	}
}
