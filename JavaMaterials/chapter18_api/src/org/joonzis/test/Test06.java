package org.joonzis.test;

import java.math.BigDecimal;

public class Test06 {

	public static void main(String[] args) { 
		for (int i = 1; i < 100; i++) {
			System.out.println(i+"! = "+factorial(i));
		}
	}
	public static BigDecimal factorial(int a) {
		if(a==1)return new BigDecimal(1);
		return new BigDecimal(a).multiply(factorial(a-1));
	}
}
