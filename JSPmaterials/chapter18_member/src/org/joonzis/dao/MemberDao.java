package org.joonzis.dao;

import org.joonzis.vo.MemberVO;

public interface MemberDao {
	public int validateId(String mId);
	public int insertMember(MemberVO mvo);
	public int login(MemberVO mvo);
}
