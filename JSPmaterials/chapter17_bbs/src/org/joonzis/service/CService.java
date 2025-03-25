package org.joonzis.service;

import java.util.List;

import org.joonzis.vo.CVO;

public interface CService {
	public int insertComment(CVO cvo);
	public List<CVO> getCommList(int b_idx);
	public int removeComment(int b_idx);
}
