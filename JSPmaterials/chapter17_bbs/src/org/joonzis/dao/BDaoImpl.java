package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.model.Criteria;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;

public class BDaoImpl implements BDao{
	// DAO 객체 생성
	private static BDaoImpl instance = null;
	private BDaoImpl() {}
	public static BDaoImpl getInstance() {
		if(instance == null) {
			instance = new BDaoImpl();
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
	
//	@Override
//	public List<BVO> getList() {
//		return getSqlSession().selectList("select_all");
//	}
	
	@Override
	public int InsertBBS(BVO bvo) {
		int result = getSqlSession().insert("insert_bbs", bvo);
		if(result > 0) {
			getSqlSession().commit();
		}
		return result; 
	}
	@Override
	public BVO getViewByIdx(int a) {
		return getSqlSession().selectOne("select_one",a);
	}
	@Override
	public int updateBBS(BVO bvo) {
		int result = getSqlSession().update("update_bbs", bvo);
		if(result>0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public void removeBBS(int b_idx) {
		int result1=0,result2=0;
		List<CVO> list = getSqlSession().selectList("select_comment",b_idx);
		if(list.size()!=0) {
			result1 = getSqlSession().delete("delete_commentByIdx", b_idx);
		}
		result2 = getSqlSession().delete("remove_bbs", b_idx);
		if(result1>0&&result2>0) {
			getSqlSession().commit();
		}
	}
	
	@Override
	public int updateHit(BVO bvo) {
		int result = getSqlSession().update("update_hit",bvo);
		if(result>0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public List<BVO> getListWithPaging(Criteria cri) {
		return getSqlSession().selectList("select_page", cri);
	}
	@Override
	public int getTotalRecordCount() {
		return getSqlSession().selectOne("select_total_count");
	}
}





