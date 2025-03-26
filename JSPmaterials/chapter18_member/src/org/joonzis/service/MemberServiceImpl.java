package org.joonzis.service;

import org.joonzis.dao.MemberDao;
import org.joonzis.dao.MemberDaoImpl;
import org.joonzis.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDao mdao = MemberDaoImpl.getInstance();
	
	@Override
	public int validateId(String mId) {
		return mdao.validateId(mId);
	}
	@Override
	public int insertMember(MemberVO mvo) {
		return mdao.insertMember(mvo);
	}
	@Override
	public int login(MemberVO mvo) {
		return mdao.login(mvo);
	}
}
