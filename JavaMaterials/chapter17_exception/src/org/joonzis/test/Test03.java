package org.joonzis.test;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		try {
			System.out.println("입력한 주민번호 : "+getPerID());			
		}catch (PerIDException e) {
			System.out.println("에러 코드 : " + e.getErrCode());
			System.out.println("에러 메시지 : " + e.getMessage());
		}
	}
	static String getPerID() throws PerIDException{
		Scanner sc = new Scanner(System.in);
		System.out.print("주민 번호 : ");
		String id = sc.next();
		if(id.length() != 14) {
			sc.close();
			throw new PerIDException(1000, "주민번호가 14자리가 아닙니다.");
		}
		String fp = id.substring(0, 6);
		char hyp = id.charAt(6);
		String lp = id.substring(7,14);
		boolean isIncludeChar = false;
		for (int i = 0; i < fp.length(); i++) {
			if(fp.charAt(i)>'9'||fp.charAt(i)<'0')
				isIncludeChar = true;
		}
		for (int i = 0; i < fp.length(); i++) {
			if(lp.charAt(i)>'9'||lp.charAt(i)<'0')
				isIncludeChar = true;
		}
		if(isIncludeChar||hyp!='-') {
			sc.close();
			throw new PerIDException(1001, "형식에 어긋납니다.\n앞 부분은 6개의 숫자, 뒷부분은 7개의 숫자로 구성되고, 이는 \'-\'으로 구분됩니다. ");
		}
		sc.close();
		return id;
	}
}
class PerIDException extends Exception{
	private int errCode;
	private static final long serialVersionUID = 1L;
	public PerIDException(int errCode, String msg) {
		super(msg);
		this.errCode = errCode;
	}
	public int getErrCode() {
		return errCode;
	}	
}
