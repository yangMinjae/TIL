package org.joonzis.ex;

import java.util.TreeSet;

public class Ex05_TreeSet {

	public static void main(String[] args) {
		// TreeSet의 메소드를 사용하기 위해 Set 대신 TreeSet 사용
		TreeSet<String> set = new TreeSet<String>();
		
		set.add("airplance");
		set.add("apple");
		set.add("area");
		set.add("disc");
		set.add("dance");
		
		// headSet : 지정된 객체보다 작은 값의 객체들 반환
		// subSet : 범위 내의 검색 결과 반환
		// tailSet : 지정된 객체보다 큰 값의 객체들 반환
		System.out.println(set.headSet("b"));
		System.out.println(set.subSet("a", "aq"));
		System.out.println(set.tailSet("c"));
	}

}
