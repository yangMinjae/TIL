package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class CServiceImpl implements CService{
	private CDao cdao = CDaoImpl.getInstance();
	@Override
	public int insertComment(CVO cvo) {
		return cdao.insertComment(cvo);
	}
	@Override
	public List<CVO> getCommList(int b_idx) {
		return cdao.getCommList(b_idx);
	}
	@Override
	public int removeComment(int b_idx) {
		return cdao.removeComment(b_idx);
	}
}
