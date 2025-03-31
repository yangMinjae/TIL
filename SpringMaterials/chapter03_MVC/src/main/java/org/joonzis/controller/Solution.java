package org.joonzis.controller;

public class Solution {
    public static int solution(int n, int w, int num) {    	
        int answer = 0;
        int yIdx=-1,xIdx=-1;			// num의 위치
        
        // 박스를 규칙에따라 쌓는 부분
        int[][] boxs = new int[(int)Math.ceil(n*1.0/w)][w];
        outer:
        for(int i = 0; i<boxs.length;i++) {
        	for(int j = 0; j<boxs[i].length;j++) {
        		if(i%2==0) {
        			boxs[i][j]=(j+1)+(w*i);
        		}else {
        			boxs[i][boxs[i].length-1-j]=(j+1)+(w*i);
        		}
        		if(j+1+w*i==n) {
        			break outer;
        		}
        	}
        }
        for(int i = 0; i<boxs.length;i++) {
        	for(int j = 0; j<boxs[i].length;j++) {
        		if(boxs[i][j]==num) {
        			yIdx=i;
        			xIdx=j;
        		}
        		if(i>=yIdx && j==xIdx &&boxs[i][j]!=0) {
        			answer++;
        		}
        	}
        }
        System.out.printf("xIdx=%d, yIdx=%d\n",xIdx,yIdx);
        for(int i = 0; i<boxs.length;i++) {
        	for(int j = 0; j<boxs[i].length;j++) {
        		System.out.printf(" | %5d | ",boxs[boxs.length-1-i][j]);
        	}
        	System.out.println();
        }
        return answer;
    }
    public static void main(String[] args) {
		System.out.println(solution(13,3,6));

	}
}
