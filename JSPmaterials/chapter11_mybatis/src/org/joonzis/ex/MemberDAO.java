package org.joonzis.ex;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.joonzis.mybatis.DBService;

public class MemberDAO {
	// 필드
	private SqlSessionFactory factory = null;
	
	// 싱글톤
	// 기본 생성자(외부에서 접근할 수 없게 private 처리)
	private MemberDAO() {
		factory = DBService.getFactory();
	}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	
	// 테이블 전체 목록을 가져오는 메소드 - getAllList
	public List<MemberVO> getAllList(){
		SqlSession session = factory.openSession();
		List<MemberVO> list = session.selectList("select_all");
		session.close();
		
		return list;
	}
	// 회원 추가
	public int insert(MemberVO vo) {
		int result = 0;
		SqlSession session = factory.openSession(false);	// 오토 커밋 끄기
		result = session.insert("insert", vo);
		if(result>0) {
			session.commit();
		}
		session.close();
		return result;
	}
	public int remove(MemberVO vo) {
		int result = 0;
		SqlSession session = factory.openSession(false);	// 오토 커밋 끄기
		result = session.delete("delete", vo);
		if(result>0) {
			session.commit();
		}
		session.close();
		return result;
	}
	public MemberVO getUpdateView(MemberVO vo) {
		MemberVO result;
		SqlSession session = factory.openSession(false);	// 오토 커밋 끄기
		result = session.selectOne("select_one", vo);
		if(result!=null) {
			session.commit();
		}
		session.close();
		return result;
	}
	public int update(MemberVO vo) {
		int result = 0;
		SqlSession session = factory.openSession(false);	// 오토 커밋 끄기
		result = session.update("update", vo);
		if(result>0) {
			session.commit();
		}
		session.close();
		return result;
	}

	public MemberVO getUserInfoByid(MemberVO vo) {
		MemberVO result = null;
		SqlSession session = factory.openSession();
		result = session.selectOne("view_one", vo);
		session.close();
		return result;
	}
}
