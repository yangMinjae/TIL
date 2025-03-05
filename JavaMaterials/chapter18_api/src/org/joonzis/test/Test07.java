package org.joonzis.test;

import java.util.Calendar;

public class Test07 {
	private static final String[] weeks = {"","일","월","화","수","목","금","토"};
	public static void main(String[] args) {
		printDate();
	}
	public static void printDate() {
		
		Calendar now = Calendar.getInstance();
		StringBuffer sb = new StringBuffer();
		sb.append(now.get(Calendar.YEAR)+"년 ");
		sb.append((now.get(Calendar.MONTH)+1)+"월 ");
		sb.append(now.get(Calendar.DAY_OF_MONTH)+"일 ");
		sb.append(weeks[now.get(Calendar.DAY_OF_WEEK)]+"요일 ");
		sb.append(now.get(Calendar.AM_PM)==0?"오전 ":"오후 ");
		sb.append(now.get(Calendar.HOUR)+"시 ");
		sb.append(now.get(Calendar.MINUTE)+"분 ");
		System.out.println(sb);
	}
}
