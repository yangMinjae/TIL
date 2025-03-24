package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.BDao;
import org.joonzis.dao.BDaoImpl;
import org.joonzis.vo.BVO;

public class BServiceImpl implements BService{
	private BDao bdao = BDaoImpl.getInstance();
	
	@Override
	public List<BVO> getList() {
		return bdao.getList();
	}
	@Override
	public int InsertBBS(BVO bvo) {
		return bdao.InsertBBS(bvo);
	}
	@Override
	public BVO getViewByIdx(int a) {
		return bdao.getViewByIdx(a);
	}
	@Override
	public int removeBBS(int a) {
		return bdao.removeBBS(a);
	}
	@Override
	public int updateBBS(BVO bvo) {
		return bdao.updateBBS(bvo);
	}
	@Override
	public int updateHit(BVO bvo) {
		return bdao.updateHit(bvo);
	}
}


