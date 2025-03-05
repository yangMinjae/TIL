package src.org.joonzis.ex;

public class Ex02_Variable_boundary {
	
	// PI 같은 상수는 이런 식으로 사용하지는 않으나,
	// 아직 배우지 않았으니 일단 진행
	static double PI = 3.14;
	
	public static void main(String[] args) {
		int value = 10;	// 메인 메소드의 지역 변수
		int sum = value + 20;	// 메인 메소드의 지역 변수
		
		System.out.println(sum);
		//System.out.println(result);	// 다른 메소드의 변수를 사용 하지 못함
		System.out.println(PI);
	}
	
	public void local() {
		int result = 100;	// local 메소드의 지역 변수
	}
}
