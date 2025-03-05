package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		SmartPhone smp = new SmartPhone("홍길동");
		smp.sendCall();
		smp.receiveCall();
		smp.connectInternet();
		smp.playApp();
	}
}
interface Computable{
	void connectInternet();
	void playApp();
}
class Phone{
	String owner;
	public Phone() {}
	public Phone(String owner) {
		super();
		this.owner = owner;
	}
	public void sendCall() {
		System.out.println(owner + "에게 전화를 겁니다.");
	}
	public void receiveCall() {
		System.out.println(owner + "가 전화를 받습니다.");
	}
}
class SmartPhone extends Phone implements Computable{
	public SmartPhone(String owner) {
		super(owner);
	}
	@Override
	public void connectInternet() {
		System.out.println("인터넷에 연결합니다.");
		
	}
	@Override
	public void playApp() {
		System.out.println("앱을 실행합니다.");
		
	}
}