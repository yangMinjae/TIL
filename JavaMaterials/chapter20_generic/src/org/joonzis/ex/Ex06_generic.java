package org.joonzis.ex;

import java.util.Arrays;

public class Ex06_generic {

	public static void main(String[] args) {
		Basket<Food> foodBasket = new Basket<>(5);
		foodBasket.add(new Apple());
		foodBasket.add(new Banana());
		foodBasket.add(new Bread());
		System.out.println(Arrays.toString(foodBasket.getfoods()));
	}

}
class Basket<T>{
	private T[] foods;
	
	// 경고 뜨지 않게(노란 밑줄) -> Unchecked -> 명확하지 않은 타입 체크이지만, 경고 ㄴㄴ
	@SuppressWarnings("unchecked")
	public Basket(int capacity) {
		//foods = new T[capacity];		//이렇게 사용 불가
		foods = (T[])(new Object[capacity]);
	}
	public void add(T item) {
		for (int i = 0; i < foods.length; i++) {
			if(foods[i]==null) {
				foods[i]=item;
				return;
			}
		}
	}
	public T[] getfoods() {
		return foods;
	}
	
}
class Food{
	
}
class Apple extends Food{

	@Override
	public String toString() {
		return "Apple";
	}
	
}
class Banana extends Food{
	public String toString() {
		return "Banana";
	}
}
class Bread extends Food{
	public String toString() {
		return "Bread";
	}
}
class Computer{
	
}
