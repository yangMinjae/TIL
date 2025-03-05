package org.joonzis.test;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Updown ud = new Updown();
		ud.play();
	}

}
class NumberOutOfBoundsException extends Exception{

	private static final long serialVersionUID = 1L;
	public NumberOutOfBoundsException(String msg) {
		super(msg);
	}
}
class Updown{
	private Scanner sc = new Scanner(System.in);
	private int answer;
	private int count;
	Random ran;
	public Updown() {
		ran = new Random();
		answer = ran.nextInt(100)+1;
	}
	public void play() {
		while(true) {
			try {				
				int selNum = challenge();
				System.out.println(answer);
				if(selNum>answer) {
					System.out.println("Down!!");
				}else if (selNum<answer) {					
					System.out.println("UP!!");
				}else {
					System.out.println("정답!");
					break;
				}
			} catch (NumberOutOfBoundsException e) {
				System.out.println(e.getMessage());
				continue;
			} catch (InputMismatchException e) {
				System.out.println("정수만 입력하세요");
				sc.next();
				continue;
			}
			
		}
	}
	public int challenge() throws NumberOutOfBoundsException, InputMismatchException{
		System.out.print("1~100 사이의 정수 입력 >> ");
		int selNum = sc.nextInt();
		if (selNum <1|| selNum>100) {
			throw new NumberOutOfBoundsException("1~100사이의 정수 입력!!!!!");
		}
		count++;
		return selNum;
	}
}