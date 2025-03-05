package org.joonzis.test;

import java.util.Scanner;

public class Test08 {
	public static void main(String[] args) {
		int a[] = new int[5];
		String[] names= new String[5];
		Scanner sc = new Scanner(System.in);
		int max=0, min=0, sum=0;
		for (int i = 0; i < names.length; i++) {
			System.out.print("이름 >>");
			names[i]=sc.nextLine();
			System.out.print(names[i]+"의 점수 >>");
			a[i]=Integer.parseInt(sc.nextLine());
			System.out.println("========================");
			if(i==0) {
			max=a[0];
			min=a[0];
			}
			sum+=a[i];
			if(a[i]>max) {
				max=a[i];
			}else if(a[i]<min) {
				min=a[i];
			}
		}
		System.out.println("최대 : "+max);
		System.out.println("최소 : "+min);
		System.out.printf("평균 : %.2f",((double)sum/a.length));
		sc.close();
	}
}
