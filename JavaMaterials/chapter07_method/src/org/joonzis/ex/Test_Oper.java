package org.joonzis.ex;

public class Test_Oper {
	double val1,val2;
	// 두 값을 이용하여 사칙연산을 하는 클래스
	double plus() {
		return val1+val2;
	}
	double minus() {
		
		return val1-val2;
	}
	double multi() {
		
		return val1*val2;
	}
	double div() {
		
		return val1/val2;
	}
	public static void main(String[] args) {
		Test_Oper ex = new Test_Oper();
		ex.val1=15;
		ex.val2=12;
		System.out.println("덧셈 : "+ex.plus());
		System.out.println("뺄셈 : "+ex.minus());
		System.out.println("곱셈 : "+ex.multi());
		System.out.println("나눗셈 : "+ex.div());
	}
}
