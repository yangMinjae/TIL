package org.joonzis.test;

import java.util.Arrays;

public class Test01 {

	public static void main(String[] args) {
		TypeCheckClass<Integer> tcI = new TypeCheckClass<>(new Integer[] {1,2,3,4,5,6});
		TypeCheckClass<Double> tcD = new TypeCheckClass<>(new Double[] {1.4, 3.2, 4.5, 5.6});
		TypeCheckClass<String> tcS = new TypeCheckClass<>(new String[] {"가","나", "다", "라"});
		System.out.println(tcI.checkType());
		System.out.println(tcD.checkType());
		System.out.println(tcS.checkType());
		System.out.println(tcI);
		System.out.println(tcD);
		System.out.println(tcS);
	}

}
class TypeCheckClass<T>{
	private T[] arr;
	public String checkType() {
		if(arr instanceof Integer[]) {
			return "정수 입니다.";
		}else if(arr instanceof Double[]) {
			return "실수 입니다.";
		}else if(arr instanceof String[]) {
			return "문자열 입니다.";
		}else {
			return "???????????";
		}
	}
	public TypeCheckClass(T[] arr) {
		super();
		this.arr = arr;
	}
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
	
}