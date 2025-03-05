package org.joonzis.ex;

public class Ex02_generic {

	public static void main(String[] args) {
		Bag<Ball> bag = new Bag<>();
		//Bag<Ball> bag = new Bag<Ball>();		//둘다 가능
		
		bag.setObj(new Ball());
		Ball ball = bag.getObj();
	}

}
// <T> : 자료형 ex) int형을 넣고 싶으면 Integer를 사용해야 함
class Bag<T>{
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
}
class Ball{}
class Pen{}
