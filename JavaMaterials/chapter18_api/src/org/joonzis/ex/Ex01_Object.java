package org.joonzis.ex;

public class Ex01_Object {

	public static void main(String[] args) {
		Object object = new Object();
		System.out.println(object);
		
		object = 10;						// 모든 클래스의 부모이므로 모든 자료형이 다 들어갈 수 있음. 기본형도!!
		System.out.println(object);

		object = "Hello";
		System.out.println(object);
		
		object = new Sample();
		System.out.println(object.toString());
		// 객체만 출력해도 자동으로 toString()변환
		System.out.println(object);
		// ->결과적으로 위의 두 코드는 같다.
	}

}
class Sample{
	@Override
	public String toString() {
		return "Sample 클래스입니다.";
	}
}