package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList...");
		return mapper.getList();
	}
	
	@Override
	public BoardVO get(int bno) {
		log.info("get..."+bno);		
		return mapper.read(bno);
	}
	
	
	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify..."+vo);
		int result = mapper.update(vo);
		if(result==1) {
			return true;
		}else {
			return false;			
		}
	}
	
	@Override
	public boolean register(BoardVO vo) {
		log.info("register..."+vo);
		int result = mapper.insert(vo);
		if(result==1) {
			return true;
		}else {
			return false;			
		}
	}
	
	@Override
	public boolean remove(int bno) {
		log.info("remove..."+bno);
		int result = mapper.delete(bno);
		if(result==1) {
			return true;
		}else {
			return false;			
		}
	}
	
}
