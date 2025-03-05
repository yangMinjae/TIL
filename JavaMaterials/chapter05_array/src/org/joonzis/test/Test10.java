package org.joonzis.test;

import java.util.Scanner;

public class Test10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a[]=new int[5];
		int b[][]= new int[5][]; 
		for (int i = 0; i < a.length; i++) {
			System.out.print((i+1)+"줄 : ");
			a[i]=sc.nextInt();
			int[] c=new int[a[i]];
			for (int j = 0; j < c.length; j++) {
				c[j]=1;
			}
			b[i]=c;
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]+"\t");
			}
			System.out.println();
		}
		sc.close(); 
	}
}
