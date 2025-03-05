package src.org.joonzis.ex;

public class Ex02_operator01 {
	public static void main(String[] args) {
		/*
		 * 1. 산술연산자
		 * 			정수		실수
		 *  	+   덧셈		덧셈
		 * 	 	-	뺄셈		뺄셈
		 *  	*	곱셈		곱셈
		 *  	/	  몫		나누기
		 *  	%	나머지	 X
		 */
		
		/*
		 * 2. 대입연산자
		 * 
		 *  =  : 대입
		 *  += : 더해서 대입
		 *  -= : 빼서 대입
		 * 	*= : 곱해서 대입
		 *  /= : 몫으로 대입(정수), 나눠서 대입(실수)
		 *  %= : 나머지를 구해서 대입
		 */
		
		// Q. 카프리카 수를 구하기 위해 2자리 정수를 앞뒤로 분리, 4자리 정수를 앞뒤로 분리
		//	어떤 수의 제곱수를 두 부분으로 나누어 더했을 때, 다시 원래의 수가 되는 수
		//	앞뒤로 분리해서 (앞+뒤)*(앞+뒤) == 자신
		//	ex. 81 : (8+1)*(8+1) == 81
		//  ex. 3025 : (30+25)*(30+25) = 3025
		
		int num = 81;
		int front = num / 10;
		int end = num % 10;
		
		System.out.println(front);
		System.out.println(end);
		
		int num2 = 3025;
		int front2 = num2 / 100;
		int end2 = num2 % 100;
		
		System.out.println(front2);
		System.out.println(end2);
		
	}
}
