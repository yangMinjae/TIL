package org.joonzis.ex;
// DepositException		: 마이너스 입금 처리, 예외 코드 1000
// WithdrawException	: 잔액 초과 출금 처리, 예외 코드 2000
// 						: 마이너스 출금 처리, 예외 코드 2001
public class Ex08_exception {
	public static void main(String[] args) {
		BankAccount parent = 
				new BankAccount("123-456", 0);
		BankAccount child = 
				new BankAccount("789-012", 0);
		
		// 1. 부모 계좌에 10,000원 입금
		try {
			parent.transaction("deposit", 10000);		
		} catch (DepositException e) {
			System.out.println("에러 코드 : " + e.getErrCode());
			System.out.println("에러 메시지 : " + e.getMessage());
			System.out.println("거래가 취소 됐습니다.");
			System.out.println();
		} catch(Exception e) {
		}
		
		// 2. 부모 계좌에서 5,000원 출금 - 출금 예외
		try {
			parent.transaction("withdraw", 5000);
		} catch (WithdrawException e) {
			System.out.println("에러 코드 : " + e.getErrCode());
			System.out.println("에러 메시지 : " + e.getMessage());
			System.out.println("거래가 취소 됐습니다.");
			System.out.println();
		}catch (Exception e) {
		}
		// 3. 부모 계좌에서 자식 계좌로 3,000원 이체;
		// - 입금, 출금 예외
		
		try {
			parent.transaction("transfer",child ,3000);				// 정상 작동
			//parent.transaction("transfer",child ,-5000);			// 에러코드:2001 발생시키는 코드
			//parent.transaction("transfer",child ,6000);			// 에러코드:2000 발생시키는 코드
		}catch (WithdrawException e) {
			System.out.println("에러 코드 : " + e.getErrCode());
			System.out.println("에러 메시지 : " + e.getMessage());
			System.out.println("거래가 취소 됐습니다.");
			System.out.println();
		}catch (DepositException e) {
			System.out.println("에러 코드 : " + e.getErrCode());
			System.out.println("에러 메시지 : " + e.getMessage());
			System.out.println("거래가 취소 됐습니다.");
			System.out.println();
		}		
	}
}
class BankAccount{
	// 필드
	private String no;			// 계좌 번호
	private long balance;	// 계좌 잔액
	private int tranCount;
	public BankAccount(String no, long balance) {
		this.no = no;
		this.balance = balance;
	}
	// 입금
	public void deposit(long money) throws DepositException{
		if(money < 0) {
			tranCount--;
			throw new DepositException("0보다 작은 금액 입금 불가", 1000);
		}
		System.out.println(no+"에 "+money + "원 입금");
		balance += money;
	}
	// 출금
	public void withdraw(long money) throws WithdrawException{
		if(money < 0) {
			tranCount--;
			throw new WithdrawException("0보다 작은 금액 출금불가", 2001);
		}
		if(money > balance) {			
			tranCount--;
			throw new WithdrawException("계좌 잔액이 부족합니다.", 2000);
		}
		
		System.out.println(no+"에서 "+money + "원 인출");
		balance -= money;		
	}
	// 조회
	public void inquire() {
		System.out.println("계좌 번호 : " + no);
		System.out.println("계좌 잔액 : " + balance);
		System.out.println();
	}
	// 이체
	public void transfer(BankAccount account, long money) throws DepositException, WithdrawException{
		this.withdraw(money);
		System.out.println(account.no+"로 송금");
		account.deposit(money);
	}
	public void transaction(String kind, long money) throws DepositException, WithdrawException{
		switch(kind) {
		case "deposit":
			System.out.println("<< 트랜잭션 : "+(++tranCount)+" >>");
			deposit(money);
			inquire();
			System.out.println("------------------------------------------");
			break;
		case "withdraw":
			System.out.println("<< 트랜잭션 : "+(++tranCount)+" >>");
			withdraw(money);
			inquire();
			System.out.println("------------------------------------------");
			break;
		}
	}
	public void transaction(String kind, BankAccount ac ,long money) throws DepositException, WithdrawException{
		if(kind.equals("transfer")){
			System.out.println("<< 트랜잭션 : "+(++tranCount)+" >>");
			transfer(ac,money);
			System.out.println();
			inquire();
			ac.inquire();
			System.out.println("------------------------------------------");
		}

	}
}
class DepositException extends Exception{
	private static final long serialVersionUID = 1L;
	private int errCode;
	public DepositException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	
}
class WithdrawException extends Exception{
	private static final long serialVersionUID = 1L;
	private int errCode;
	public WithdrawException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	
}
