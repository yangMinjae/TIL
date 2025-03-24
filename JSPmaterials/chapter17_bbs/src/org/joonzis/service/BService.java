package org.joonzis.service;

import java.util.List;

import org.joonzis.vo.BVO;

public interface BService {
	// 전체 게시글
	public List<BVO> getList();
	// 게시글 등록
	public int InsertBBS(BVO bvo);
	
	public BVO getViewByIdx(int a);
	public int removeBBS(int a);
	public int updateBBS(BVO bvo);
	public int updateHit(BVO bvo);
}






