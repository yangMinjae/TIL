package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.Board2VO;
import org.joonzis.mapper.Board2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Board2ServiceImpl implements Board2Service{
	
	@Autowired
	Board2Mapper bMapper;
	@Override
	public List<Board2VO> getAllList() {
		
		return bMapper.getAllList();
	}
	
	@Override
	public Board2VO getBoard(int idx) {
		
		return bMapper.getBoard(idx);
	}
	
	@Override
	public boolean register(Board2VO vo) {
		
		return bMapper.register(vo)>=1?true:false;
	}
	
	@Override
	public boolean remove(int idx) {
		
		return bMapper.remove(idx)>=1?true:false;
	}
	
	@Override
	public boolean update(Board2VO vo) {
		
		return bMapper.update(vo)>=1?true:false;
	}
	
}
