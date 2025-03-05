package org.joonzis.ex;

public class Ex05_StringBuffer {
	public static void main(String[] args) {
		//StringBuffer나 StringBuilder나 똑같다
		
		StringBuffer sb1 = new StringBuffer("apple");
		StringBuffer sb2 = new StringBuffer("apple");
		
		System.out.println(
				"sb1 해시코드값(주소값) = " + sb1.hashCode());
		System.out.println(
				"sb2 해시코드값(주소값) = " + sb2.hashCode());
		
		StringBuffer sb = new StringBuffer();
		System.out.println("기본 버퍼 크기 : " + sb.capacity());
		// .capacity() : 버퍼 크기 알아 볼 때 ! 기본 16문자
		
		// sb에 문자열 추가
		// .append(추가할 값)
		sb.append("Hello");
		sb.append(" Java").append(" World");
		System.out.println(sb.toString());
		
		// 삭제
		StringBuffer phone = new StringBuffer();
		phone.append("010-1234-5678");
		phone.deleteCharAt(3);
		phone.deleteCharAt(7);
		System.out.println(phone.toString());
		
	}
}
