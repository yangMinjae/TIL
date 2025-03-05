package org.joonzis.ex;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Ex02_FileInput {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("alphabet.txt");
			bis = new BufferedInputStream(fis);
			
			int ch = 0;
			while(true) {
				ch=bis.read();		// read()의 리턴이 int 타입
				if(ch==-1) {
					break;
				}
				System.out.println((char)ch);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(bis!=null)bis.close();
				if(fis!=null)fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
