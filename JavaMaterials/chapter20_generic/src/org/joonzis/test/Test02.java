package org.joonzis.test;

public class Test02 {

	public static void main(String[] args) {
		System.out.println(sum(new Integer[] {1,2,3,4,5}));
		System.out.println(sum(new Long[] {1l,2l,3l,4l,5l}));
		System.out.println(sum(new Double[] {1.1,2.2,3.3,4.4,5.5}));
		System.out.println(sum(new Short[] {1,2,3,4,5,6}));
		
	}
	static <T extends Number>double sum(T[] arr){
		double sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i].doubleValue();
		}
		return sum;
	}
}
