package src.org.joonzis.ex;

public class Ex03_PrimitiveType {
	public static void main(String[] args) {
		
		/*
		 * 변수 선언
		 * 1. 아무 곳에서 선언 가능
		 * 2. 변수 이름의 첫 글자는 소문자로 하고, camel case 방식을 따른다.
		 * 	(각 단어의 첫 글자만 대문자로 하고, 나머지는 소문자로 한다.)
		 * 	ex) myAge(o), MyAge(x)
		 * 3. 영문, 숫자, 언더바(_), 한글(사용 가능하지만 사용x)
		 */
		
		byte var1 = 127;
		short var2 = 32767;
		int var3 = 210000;
		long var4 = 10000000000L;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		
		
		float var5 = 3.14f;
		double var6 = 3.14;
		
		System.out.println(var5);
		System.out.println(var6);
		
		char ch1 = 'A';
		char ch2 = '한';
		// int형일 때 ASCII Code 값 반환
		
		System.out.println(ch1);
		System.out.println(ch2);
		
		System.out.println(ch1 + ch2);
		System.out.println("" + 100 + 100);
		System.out.println("Hello" + " Java");
		
		boolean isPositive;
		isPositive = true;
		
	}
}
