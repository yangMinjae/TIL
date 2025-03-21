package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;

public class BDaoImpl implements BDao{
	private static BDaoImpl instance = null;
	private BDaoImpl() {}
	
	public static BDaoImpl getInstance() {
		if(instance==null) {
			instance = new BDaoImpl();
		}
		return instance;
	}
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession==null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	@Override
	public List<BVO> getList() {
		return getSqlSession().selectList("select_all");
	}
}
