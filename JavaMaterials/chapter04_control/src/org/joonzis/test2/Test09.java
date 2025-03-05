package org.joonzis.test2;

public class Test09 {
	public static void main(String[] args) {
		System.out.print("짝수의 합 >>");
		int sumEven = 0, sumOdd=0;
		for(int i =1;i<101;i++) {
			if(i%2==0)sumEven+=i;
			else sumOdd+=i;
		}
		System.out.println(sumEven);
		System.out.println("홀수의 합 >>"+sumOdd);
	}
}
