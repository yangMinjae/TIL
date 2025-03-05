package org.joonzis.ex;

public class Ex05_generic {

	public static void main(String[] args) {
		Container<Gun> con = new Container<>(10);
		con.add(new Gun("AK47"));
		con.add(new Gun("Vector"));
		con.add(new Gun("Glock"));
		con.add(new Gun("Magnum"));
		con.add(new Gun("Vss"));
		con.add(new Gun("Kar 98-k"));
		con.add(new Gun("M-16"));
		con.add(new Gun("M4"));
		Object[] a = con.getItems();
		for (int i = 0; i < a.length; i++) {
			if(a[i]!=null) {				
				System.out.println((Gun)a[i]);
			}
		}
		
	}

}
class Container<T>{
	private T[] items;
	
	// 경고 뜨지 않게(노란 밑줄) -> Unchecked -> 명확하지 않은 타입 체크이지만, 경고 ㄴㄴ
	@SuppressWarnings("unchecked")
	public Container(int capacity) {
		//items = new T[capacity];		//이렇게 사용 불가
		items = (T[])(new Object[capacity]);
	}
	public void add(T item) {
		for (int i = 0; i < items.length; i++) {
			if(items[i]==null) {
				items[i]=item;
				return;
			}
		}
	}
	public T[] getItems() {
		return items;
	}
	
}
class Gun{
	private String model;

	public Gun(String model) {
		super();
		this.model = model;
	}

	@Override
	public String toString() {
		return model;
	}
	
}