package org.joonzis.test;

public class Q2SingerSong {
	public static void main(String[] args) {
		Singer s1= new Singer("김광석");
		s1.setSong(new Song("먼지가 되어", "한국"));
		s1.output();
		
		Singer s2= new Singer("마이클 잭슨");
		s2.setSong(new Song("billie jean", "미국"));
		s2.output();
		
		Singer s3= new Singer("요네즈 켄시");
		s3.setSong(new Song("lemon", "일본"));
		s3.output();
	}
}
class Song{
	String title;
	String country;
	Song(){}		// 기본 생성자는 내용이 없어도 꼭 추가! (오류 발생 방지)
	public Song(String title, String country) {
		super();
		this.title = title;
		this.country = country;
	}
	void output() {
		System.out.println("곡 이름 : "+this.title);
		System.out.println("국가 : "+this.country);
		System.out.println();
	}
}
class Singer{
	String name;
	Song song;
	public Singer(String name) {
		super();
		this.name = name;
	}
	void output() {
		System.out.println("가수 이름 : "+this.name);
		this.song.output();
	}
	void setSong(Song song) {
		this.song=song;
	}
}
