package org.joonzis.service;

import org.joonzis.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper Mmapper;
	@Override
	public int getTupleById(String userId) {
		int c = Mmapper.getTupleById(userId);
		return c;
	}
}
