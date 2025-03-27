package org.joonzis.dao;

import org.joonzis.vo.MemberVO;

public interface MemberDao {
	public int validateId(String mId);
	public int insertMember(MemberVO mvo);
	public MemberVO login(MemberVO mvo);
}
