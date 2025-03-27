package org.joonzis.dao;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.MemberVO;

public class MemberDaoImpl implements MemberDao {
	// DAO 객체 생성
	private static MemberDaoImpl instance = null;
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if(instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}

	// 필드
	private static SqlSession sqlsession = null;
	private synchronized static SqlSession getSqlSession() {
		if(sqlsession == null) {
			sqlsession = DBService.getFactory()
					.openSession(false);
		}
		return sqlsession;
	}
	
	@Override
	public int validateId(String mId) {
		return getSqlSession().selectOne("validateId", mId);
	}
	
	@Override
	public int insertMember(MemberVO mvo) {
		int result = getSqlSession().insert("insert_member", mvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public MemberVO login(MemberVO mvo) {
		return getSqlSession().selectOne("login",mvo);
	}
}







