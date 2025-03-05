package org.joonzis.ex;

public class Ex04_ObjectShare {

	public static void main(String[] args) {
		MusicBox mb = new MusicBox();
		MusicPlayer ms1 = new MusicPlayer(1, mb);
		MusicPlayer ms2 = new MusicPlayer(2, mb);
		MusicPlayer ms3 = new MusicPlayer(3, mb);
		
		ms1.start();
		ms2.start();
		ms3.start();
	}

}
/*
 * synchronized( 동기화 )
 * 1. 메소드에 붙여서 사용
 *  - 여러개의 Thread들이 공유 객체의 메소드를 사용할때
 *  	메소드에 synchronized가 붙어 있을 경우 먼저 호출한 메소드가
 *  	객체의 사용권(Monitoring Lock)을 얻는다
 *  - 메소드가 길어지게 될 경우 대기 시간이 증가할 수 있다.
 * 2. synchronized 블럭 사용
 */
class MusicBox{
	public synchronized void rock() {					// synchronized 사용 1)
		for (int i = 0; i < 5; i++) {
			System.out.println("play the rock");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void ballad() {
		synchronized (this) {							// synchronized 사용 2)
			for (int i = 0; i < 5; i++) {				// synchronized를 사용 하면 일단 해당 메서드가 실행되면 
														// 해당 작업이 끝날때까지 실행흐름을 점유한다. 어떤 스레드가 먼저 호출될 지는 모름
				System.out.println("play the ballad");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}
	public synchronized void dance() {
		for (int i = 0; i < 5; i++) {
			System.out.println("play the dance");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
class MusicPlayer extends Thread{
	private int type;
	private MusicBox box;
	public MusicPlayer(int type, MusicBox box) {
		super();
		this.type = type;
		this.box = box;
	}
	@Override
	public void run() {
		switch (type) {
		case 1:
			box.rock();
			break;
		case 2:
			box.ballad();
			break;
		case 3:
			box.dance();
			break;
		}
	}
	
}