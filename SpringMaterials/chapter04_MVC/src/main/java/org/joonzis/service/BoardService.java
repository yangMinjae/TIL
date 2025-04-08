package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardService {
	// 전체 리스트
	public List<BoardVO> getList();
	
	// 데이터 삽입
	public boolean register(BoardVO vo);
	
	// 단일 데이터
	public BoardVO get(int bno);
	
	// 게시글 삭제
	public boolean remove(int bno);
	
	// 게시글 수정
	public boolean modify(BoardVO vo);
	
	// 총 레코드 갯수
	public int getTotal();
	
	public List<BoardVO> getListByPage(Criteria cri);
	
	// 첨부파일 리스트
	public List<BoardAttachVO> getAttachList(int bno);
}
