package org.joonzis.test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test01 {

	public static void main(String[] args) {
		List<Board> list = new ArrayList<Board>();
		list.add(new Board("구인공고", "사람구합니다.",new Date(115,5,6)));
		list.add(new Board("광고", "화장품 광고.",new Date(118,8,6)));
		list.add(new Board("광고", "홍삼 광고",new Date(111,4,6)));
		
		Iterator<Board> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
class Board{
	private String title, content;
	private Date register;
	public Board(String title, String content, Date register) {
		super();
		this.title = title;
		this.content = content;
		this.register = register;
	}
	@Override
	public String toString() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 M월 d일");
		return "\n제목 : " + title + "\n내용 : " + content + "\n날짜 : " + format1.format(register)+"\n==========================";
	}
	
}
