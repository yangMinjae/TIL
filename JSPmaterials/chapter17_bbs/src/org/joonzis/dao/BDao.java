package org.joonzis.dao;

import java.util.List;

import org.joonzis.vo.BVO;

public interface BDao {
	public List<BVO> getList();
	public int InsertBBS(BVO bvo);
	public BVO getViewByIdx(int a);
	public int updateBBS(BVO bvo);
	public int removeBBS(int a);
	public int updateHit(BVO bvo);
}