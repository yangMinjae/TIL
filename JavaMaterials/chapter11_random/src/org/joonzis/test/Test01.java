package org.joonzis.test;

import java.util.Arrays;
import java.util.Scanner; 

public class Test01 {
	public static void main(String[] args) {
		LottoMachine m = new LottoMachine();												// main 클래스, LottoMachine 클래스를 생성하고, 멤버 메서도 gameStart() 만을 호출
		m.gameStart();
	}
}
class LottoMachine{
	int[] machine = new int[6];
	int[] person = new int[6];
	int[] match = new int[6];
	int count=0;
	
	{																						// 초기화 블록 : 멤버변수 machine[] 배열을 초기화
		for (int i = 0; i < machine.length; i++) {											// 1~45의 값이 들어가며 중복값은 들어갈 수 없다.
			machine[i]=this.randNum();
			if(i!=0) {
					for(int j=0;j<i;j++) {
						if(machine[j]==machine[i]) {
							j=-1;
							machine[i]=this.randNum();
						}
					}

			}
		}
	}
	
	void gameStart() {																		// 주된 실행 흐름
		personInput();
		match();
		result();
	}
	
	int randNum() {																			// 1~45의 랜덤값을 리턴
		return (int)(Math.random()*45)+1;
	}
	
	void printArr(int arr[]) {																// int 배열을 받아 출력
		System.out.println(Arrays.toString(arr));
	}
	
	int inputInRange(int index, Scanner sc) {												// 입력값이 범위 밖에 있다면 범위안의 숫자를 입력할때 까지 반복 입력
		System.out.print((index+1)+"번째 숫자 : ");											// 범위 안의 값을 입력 받으면 이를 리턴
		int num = sc.nextInt();
		System.out.println();
		while(num>45||num<1) {
			System.out.println("범위에 벗어나는 수를 입력했습니다. (1~45입력)");
			System.out.print((index+1)+"번째 숫자 : ");
			num=sc.nextInt();
			System.out.println();
		}
		return num;
	}
	void personInput() {																	// 사용자가 입력한 번호를 받아 저장
		Scanner sc = new Scanner(System.in);												// 입력시 inputInRange를 호출하여, 범위 내의 값만이 person[]배열에 저장되게 함
		System.out.println("<< 로또 번호를 맞춰보세요! >>");									// 중복된 값을 받지 않는다.
		for (int i = 0; i < person.length; i++) {
			person[i]=inputInRange(i,sc);
			System.out.println();
			if(i!=0) {
				for(int j=0;j<i;j++) {
					if(person[j]==person[i]) {
						j=-1;
						System.out.println("동일한 값을 입력한 이력이 있습니다. 다시 입력해 주세요");
						person[i]=inputInRange(i,sc);
						System.out.println();
					}
				}
			}
		}
		System.out.println("=============================");
		sc.close();
	}
	
	void match() {																			// 사람이 입력한 값이 기계 추출한 번호와 몇개 일치 하는지 count에 저장
		System.out.print("로또 번호 : ");													// 일치하는 값의 배열 match[]를 채움
		printArr(machine);
		System.out.print("기입 한 번호 : ");
		printArr(person);
		System.out.println();
		for(int i=0;i<person.length;i++) {
			for (int j = 0; j < machine.length; j++) {
				if(person[i]==machine[j]) {
					match[count++]=person[i];
					break;
				}
			}
		}
	}
	
	void result() {																			// 결과 출력: 맞춘 갯수와 맞춘 번호의 집합을 출력 
		if(count==0) {
			System.out.println("ㅠ하나도 못맞췄습니다ㅠ");
		}else {
			System.out.println("맞춘 갯수 : "+count);
			System.out.println();
			System.out.println("맞춘 번호 >> ");
			System.out.print("(");
			for (int i = 0; i < count; i++) {
				if(i<count-1) {				
					System.out.print(match[i]+", ");
				}else {
					System.out.print(match[i]);
				}
			}
			System.out.print(")");
		}
	}
}