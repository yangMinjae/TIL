package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		Score sc1 = new Score(100, 94, 82);
		Score sc2 = new Score(100, 94, 82);
		Score sc3 = new Score(40, 30, 82);
		System.out.println(sc1);
		System.out.println(sc2);
		System.out.println(sc1.equals(sc2)? "같은 점수":"다른 점수");
		System.out.println();
		System.out.println(sc1);
		System.out.println(sc3);
		System.out.println(sc1.equals(sc3)? "같은 점수":"다른 점수");
		
	}
}
class Score{
	private int kor, eng, mat;

	public Score(int kor, int eng, int mat) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	@Override
	public String toString() {
		return "국어 : "+kor+", 영어 : "+ eng + ", 수학 : "+mat;
	}

	@Override
	public boolean equals(Object obj) {
		Score tmp = (Score)obj;
		return this.kor == tmp.kor && this.eng == tmp.eng && this.mat == tmp.mat;
	}
	
	
	
}