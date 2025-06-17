package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.Board2VO;

public interface Board2Mapper {
	public List<Board2VO> getAllList();
	public Board2VO getBoard(int idx);
	public int register(Board2VO vo);
	public int remove(int idx);
	public int update(Board2VO vo);
}
