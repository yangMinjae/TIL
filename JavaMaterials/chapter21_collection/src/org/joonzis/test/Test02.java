package org.joonzis.test;
import java.util.*;
public class Test02 {
	private static int[][] bingo = new int[5][5];
	private static int bingoCount=0;
	public static void main(String[] args) {
		Set<Integer> ranSet = new HashSet<Integer>();
		Random rand = new Random();
		while(ranSet.size()<25) {
			ranSet.add((rand.nextInt(25)+1));
		}
		
		Iterator<Integer> itr = ranSet.iterator();
		int index=0;
		while(itr.hasNext()) {
			do{
				index=rand.nextInt(25);
			}while(bingo[index/5][(index%5)]!=0);
			bingo[index/5][index%5]=itr.next();
		}
		for (int[] is : bingo) {
			for (int is2 : is) {
				System.out.printf("%15d",is2);
			}
			System.out.println();
			System.out.println();
		}
		PlayBingo(ranSet);
	}
	public static void PlayBingo(Set<Integer> b) {
		Scanner sc = new Scanner(System.in);
		int c;
		
		for (int i = 1; ; i++) {
			System.out.print(i+"회차 숫자 입력(종료시 999) : ");
			c=sc.nextInt();
			if(c==999) {
				System.out.println("게임 종료");
				System.out.println("최종 결과");
				System.out.println("=================================================================================");
				print();
				System.out.println("=================================================================================");
				System.out.println("빙고 : "+bingoCount+"회");
				break;
			}
			if(!b.contains(c)) {
				i--;
				System.out.println();
				System.out.println("이전에 입력한/범위밖의 숫자 입력 !! ");
				System.out.println();
				continue;
			}
			b.remove(c);
			remove(c);
			print();
			checkBingo();
		}
		sc.close();
	}
	public static void remove(int a) {
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(bingo[i][j]==a) {
					bingo[i][j]=0;
					
			}
		}
		}
	}
	public static void print() {
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(bingo[i][j]==0) {
					System.out.printf("%15c",'*');
			}else {
				System.out.printf("%15d",bingo[i][j]);
			}
		}
			System.out.println();
			System.out.println();
		}
	}
	public static void checkBingo() {
		int a = checkVerBingo()+checkHorBingo()+checkdiagBingo();
		if(a>bingoCount) {
			bingoCount=a;
			System.out.println("-------------------------------");
			System.out.println("빙고!!!");
			System.out.println("현재 빙고 : "+bingoCount+"회");
			System.out.println("-------------------------------");
		}
	}
	public static int checkVerBingo() {
		boolean[] flag = new boolean[bingo.length];	// false -> 해당 라인 bingo
		int count=0;
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(bingo[j][i]!=0)flag[i]=true;
			}
		}
		for (int i = 0; i < flag.length; i++) {
			if(flag[i]==false) {
				count++;
			}
		}
		return count;
	}
	public static int checkHorBingo() {
		boolean[] flag = new boolean[bingo.length];	// false -> 해당 라인 bingo
		int count=0;
		for (int i = 0; i < bingo.length; i++) {
			for (int j = 0; j < bingo[i].length; j++) {
				if(bingo[i][j]!=0)flag[i]=true;
			}
		}
		for (int i = 0; i < flag.length; i++) {
			if(flag[i]==false) {
				count++;
			}
		}
		return count;
	}
	public static int checkdiagBingo() {
		boolean[] flag = new boolean[2];	// false -> 해당 라인 bingo
		int count=0;
		for (int i = 0; i < bingo.length; i++) {
			if(bingo[i][i]!=0)flag[0]=true;			
		}
		for (int i = 0; i < bingo.length; i++) {
			if(bingo[i][4-i]!=0)flag[1]=true;			
		}
		for (int i = 0; i < flag.length; i++) {
			if(flag[i]==false) {
				count++;
			}
		}
		return count;
	}
}
