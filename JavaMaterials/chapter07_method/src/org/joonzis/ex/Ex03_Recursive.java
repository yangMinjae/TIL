package org.joonzis.ex;

public class Ex03_Recursive {
	static int count = 0;
	static void recursive() {
		System.out.println("recursive() call");
		count++;
		if(count==5) {
			return;
		}
		recursive();
	}
	public static void main(String[] args) {
		
	}
}
