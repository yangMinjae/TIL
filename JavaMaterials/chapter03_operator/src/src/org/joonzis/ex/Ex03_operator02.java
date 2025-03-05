package src.org.joonzis.ex;

public class Ex03_operator02 {
	public static void main(String[] args) {
		/*
		 * 3. 증감 연산자
		 * 	1) 증가
		 * 		(1) a++ : a를 사용하고 증가
		 * 		(2) ++a : a를 증가하고 사용
		 * 	2) 감소
		 * 		(1) a-- : a를 사용하고 감소
		 * 		(2) --a : a를 감소하고 사용
		 * 
		 * 4. 시프트 연산자
		 *  1) 왼쪽 시프트
		 *  	(1) <<
		 *  	(2) 왼쪽으로 한 자리씩 밀어낸다.
		 *  	(3) 비트 연산
		 *  	(4) 2를 곱하는 효과가 있다.
		 *  2) 오른쪽 시프트
		 *  	(1) >>
		 *  	(2) 오른쪽으로 한 자리씩 밀어낸다.
		 *  	(3) 비트연산
		 *  	(4) 2로 나누는 효과가 있다.
		 */
		
		// 시프트
		int num = 8;
		System.out.println("왼쪽 시프트 : " + (num << 2));
		System.out.println("오른쪽 시프트 : " + (num >> 1));
		
		// 증감
		int num2 = 10;
		System.out.println(num2);	// 변수 원본 출력
		System.out.println(num2++);	// 출력 후 1증가
		System.out.println(++num2); // 1증가 후 출력
		
		
		
		
		
		
	}
}
