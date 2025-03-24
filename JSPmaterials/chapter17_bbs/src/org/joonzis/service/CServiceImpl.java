package org.joonzis.service;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class CServiceImpl implements CService{
	private CDao cdao = CDaoImpl.getInstance();
	@Override
	public int insertComment(CVO cvo) {
		return cdao.insertComment(cvo);
	}
}
