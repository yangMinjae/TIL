package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardMapper {
	// 전체 리스트
	public List<BoardVO> getList();
	// 이제부터는 메소드명이 매퍼 xml의 아이디에 매핑됨
	
	// 데이터 삽입
	public int insert(BoardVO vo);
	
	// 게시글 상세 페이지
	public BoardVO read(int bno);
	
	// 데이터 삭제
	public int delete(int bno);
	
	// 게시글 수정
	public int update(BoardVO vo);
	
	// 총 레코드 개수
	public int getTotal();
	
	// 페이징 적용 레코드 반환
	public List<BoardVO> getListByPage(Criteria cri);
}
