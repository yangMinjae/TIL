package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.BDao;
import org.joonzis.dao.BDaoImpl;
import org.joonzis.vo.BVO;

public class BServiceImpl implements BService{
	private BDao bdao = BDaoImpl.getInstance();
	@Override
	public List<BVO> getList() {
		// TODO Auto-generated method stub
		return bdao.getList();
	}
}
