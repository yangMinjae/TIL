package org.joonzis.ex;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ex07_Big_number {

	public static void main(String[] args) {
		// int형 최대 값
		System.out.println(Integer.MAX_VALUE);
		// long형 최대 값
		System.out.println(Long.MAX_VALUE);
		
		// BigInteger 클래스를 활용해서 long타입 이상/이하 사용가능
		// 반드시 문자열 처리
		BigInteger a = new BigInteger("1234567890");
		BigInteger b = new BigInteger("123456789012345678901234567890");
		
		// BigInteger 필드
		System.out.println(BigInteger.ZERO);
		System.out.println(BigInteger.ONE);
		System.out.println(BigInteger.TEN);
		
		// 사칙연산
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));
		
		// BigDecimal 클래스로 실수의 소수 자릿수를 제한 없이 사용 가능
		double d = 1.23456789123456789;
		BigDecimal e = new BigDecimal("1.23456789123456789123456789");
		System.out.println(e);
		
	}

}
