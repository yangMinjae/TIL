package org.joonzis.ex;

public class Ex01_generic {

	public static void main(String[] args) {
		Box box = new Box();
		box.setObj(new Ballpen());
		box.setObj(11);
		box.setObj(new Pencil());
		Ballpen mypen = (Ballpen)box.getObj(); 	// -> 비 제네릭 클래스 Box의 단점. 이렇게 미리 들어간 클래스의 종류를 알고, 다운캐스팅시켜줘야한다. 
												// -> ClassCastException 발생 가능
	}

}
class Box{
	private Object obj;
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
}
class Ballpen{
	
}
class Pencil{
	
}