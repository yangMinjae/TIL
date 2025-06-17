package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.Board2VO;

public interface Board2Service {
	public List<Board2VO> getAllList();
	public Board2VO getBoard(int idx);
	public boolean register(Board2VO vo);
	public boolean remove(int idx);
	public boolean update(Board2VO vo);
}
