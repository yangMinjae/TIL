package org.joonzis.ex;

import java.io.*;

public class Ex03_FileOutput {

	public static void main(String[] args) {
		// 스캐너 객체 등으로 입력 받아도 가능
		String msg = "가나다라마바사아자차카타파하";
		// 문자 기반 스트림(파일 작성시 주로 사용)
		File file = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		// 저용량의 파일 시 FileWriter만 사용해도 무방
		
		try {
			file = new File("hangeul.txt");
			fw = new FileWriter(file,false);
			// true : 이어쓰기, false : 덮어쓰기
			// 옵션 미선택 시 기본값 false
			bw = new BufferedWriter(fw);
			bw.write(msg);
			bw.flush();
			System.out.println("hangeul.txt 파일 생성!");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
