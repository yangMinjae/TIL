package org.joonzis.ex;

public class Ex07_synchronized2 {

	public static void main(String[] args) {
		StringDisplay sd = new StringDisplay();
		MyThread55[] mts = new MyThread55[5];
		for (int i=0; i<mts.length; i++) {
			mts[i] = new MyThread55(sd, Integer.toString(i));	
			mts[i].start();
		}
	}

}
class StringDisplay {
	synchronized void display(String s) {
		for (int i=0; i<5; i++) {
			System.out.print(s);
		}
		System.out.println("");
	}
}

class MyThread55 extends Thread {
	StringDisplay sd;
	String s = "";
	
	public MyThread55(StringDisplay sd, String s) {
		this.sd = sd;
		this.s = s;
	}
	
	@Override
	public void run() {
		sd.display(s);
	}
}
