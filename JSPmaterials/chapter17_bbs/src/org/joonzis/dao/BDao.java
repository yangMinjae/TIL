package org.joonzis.dao;

import java.util.List;

import org.joonzis.model.Criteria;
import org.joonzis.vo.BVO;

public interface BDao {
	//public List<BVO> getList();
	public int InsertBBS(BVO bvo);
	public BVO getViewByIdx(int a);
	public int updateBBS(BVO bvo);
	public void removeBBS(int b_idx);
	public int updateHit(BVO bvo);
	public List<BVO> getListWithPaging(Criteria cri);
	public int getTotalRecordCount();
}