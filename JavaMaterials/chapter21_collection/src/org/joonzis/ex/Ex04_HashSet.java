package org.joonzis.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Ex04_HashSet {
	public static void main(String[] args) {
		
		Set<String> set = new HashSet<>();
		
		set.add("C");
		set.add("Spring");
		set.add("Java");
		set.add("DB");
		set.add("JSP");
		set.add("Web");
		set.add("Java");	// 중복 저장 시도 - 안 늘어남
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			if(str.equals("Spring")) {
				itr.remove();	// set이 아닌 itr에서 줄임 - 주소값을 연계해서 공유
			}
		}
		// set.remove("Spring");	// set을 이용한 특정 객체 삭제
		// set.removeAll(set);		// set을 이용한 전체 객체 삭제
		
		System.out.println(set);
		
	}
}
