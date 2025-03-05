package org.joonzis.ex;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01_FileOutput {

	public static void main(String[] args) {
		
		// 바이트 기반 스트림
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			/*
			 * FileOutputStream(생성할 파일의 경로 및 이름)
			 * -경로 지정을 안하면 현재 디렉토리에 파일 생성(상대 경로)
			 * -c:/dev/file/alphabet.txt (절대 경로)
			 */
			fos = new FileOutputStream("alphabet.txt");
			bos = new BufferedOutputStream(fos);
			
			char ch = 'A';	// 아스키 코드 시작 문자
			while(true) {
				bos.write(ch);
				if(ch=='z') {	// 아스키 코드 종료 문자
					break;
				}
				ch++;
			}
			bos.flush();	// 버퍼 비우기
			System.out.println("alphabet.txt 파일 생성!!!");
			} catch (IOException e) {
			// TODO: handle exception
		}finally {
			try {
				if(bos!=null) {
					bos.close();
				}
				if(fos!=null) {
					fos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			} finally {
				try {
					if(bos!=null)bos.close();
					if(fos!=null)fos.close();		// 생성의 역순으로 닫음
				} catch (Exception e3) {
					// TODO: handle exception
				}

			}
		}
	}
}
