package org.joonzis.ex;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_Date_SimpleDateFormat {

	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		
		// Date와 SimpleDateFormat은 짝꿍으로 쓰자
		// SimpleDateFormat
		// 년 : yy, yyyy
		// 월 : M, MM
		// 일 : d, dd
		// 요일 : E
		// 오전오후 :a
		// 시 :hh(12시각제), HH(24시각제)
		// 분 : mm
		// 초 : ss
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		SimpleDateFormat format4 = new SimpleDateFormat("M월 W번 째 주 d번째 날, F번 째 E요일");
		
		System.out.println(format1.format(now));
		System.out.println(format2.format(now));
		System.out.println(format3.format(now));
		System.out.println(format4.format(now));
	}

}
