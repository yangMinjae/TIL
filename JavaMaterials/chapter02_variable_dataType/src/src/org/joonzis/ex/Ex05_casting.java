package src.org.joonzis.ex;

public class Ex05_casting {
	public static void main(String[] args) {
		/*
		 *	형 변환(casting)
		 *
		 * 	1. 자동 형 변환(묵시적)
		 * 		1) java 스스로 형 변환
		 * 		2) 타입이 섞인 경우 작은 크기의 타입을 
		 * 				큰 크기의 타입으로 통일시키는 
		 * 					방향으로 형 변환
		 * 			ex) short와 int의 연산 -> 
		 *				 둘 다 int로 변환된 뒤에 연산
		 * 		3) 정수와 실수가 섞인 경우 정수를 실수로 변환
		 * 
		 * 	2. 강제 형 변환(명시적)
		 * 		1) 개발자가 직접 형 변환
		 * 		2) 타입 상관없이 원하는 타입으로 변환
		 * 		3) (자료형)변수, (자료형)값
		 * 			ex) int num = 10;
		 * 				(double)num : 실수로 처리
		 */
		
		
		// 1. 자동 형 변환
		System.out.println( 1 + 1.5 );
		// java 스스로 1.0 + 1.5 변환 후 연산
		
		double a = 10;
		System.out.println(a);
		// java 스스로 a = 10.0 변환 후 연산
		
		
		// 2. 강제 형 변환
		int b = (int)20.9;
		System.out.println(b);
		
		int c = 1;
		int d = 2;
		double e = (double)c/d; // 강제 형 변환(c) + 자동 형 변환(d)
		System.out.println(e);
		
		
		// 국,영,수 3 과목의 평균을 화면에 출력
		// 국어( kor )
		// 영어( eng )
		// 수학( mat )
		// 점수는 각각 70, 42, 96 으로 초기화
		// 평균을 저장하는 변수( result )
		int kor = 70;
		int eng = 42;
		int mat = 96;
		double result = (double)(kor + eng + mat) / 3;
		System.out.println(result);
		
		
		
	}
}
