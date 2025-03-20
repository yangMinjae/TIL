package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.EmployeeVO;


public class EmployeeDaoImpl implements EmployeeDao{
	
	
	// DAO 객체 생성
	private static EmployeeDaoImpl instance = null;
	private EmployeeDaoImpl(){}
	
	public static EmployeeDaoImpl getInstance(){
		if(instance==null) {
			instance = new EmployeeDaoImpl();
		}
		return instance;
	};
	
	// 필드
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession==null) {
			sqlsession = DBService.getFactory().openSession(false); 
		}
		return sqlsession;
	}
	
	@Override
	public List<EmployeeVO> getAll() {
		return getSqlSession().selectList("select_all");
	}
	@Override
	public List<EmployeeVO> getDeptList(EmployeeVO vo) {
		return getSqlSession().selectList("select_dept", vo);
	}
	@Override
	public List<EmployeeVO> getDynamicList(Map<String, String> map) {
		return getSqlSession().selectList("select_dynamic",map);
	}
}
