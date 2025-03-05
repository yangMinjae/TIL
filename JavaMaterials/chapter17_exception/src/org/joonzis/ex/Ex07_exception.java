package org.joonzis.ex;
// 예외 클래스 : Exception을 상속받아서 만든다
// 예외 클래스를 만드는 이유 : 사용자 친화적인 예외 처리를 위해
// 예외가 아는것도 예외로 만들 수 있다.
public class Ex07_exception {
	public static void main(String[] args) {
		try {
			throw new MyException("내가 만든 예외");		// 예외 강제 발생
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
class MyException extends Exception{
	// 경고 없애려고 넣은거니까 신경 안써도 된다.
	private static final long serialVersionUID = 1L;
	public MyException(String msg) {
		super(msg);
	}
}