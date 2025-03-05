package org.joonzis.test;

public class RecursiveCall {
	static void recursive(int n) {
		System.out.println("hello");
		if(n==1)return;
		recursive(n-1);
	}
	public static void main(String[] args) {
		recursive(4);
	}
}
