package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper mapper1;
	@Autowired
	BoardMapper mapper2;
	@Override
	public List<ReplyVO> getList(int bno) {
		log.info("getListComment..."+bno);
		return mapper1.getList(bno);
	}
	@Override
	public ReplyVO get(int rno) {
		log.info("getComment..."+rno);
		return mapper1.get(rno);
	}
	@Transactional
	@Override
	public int insert(ReplyVO vo) {
		log.info("insertComment..."+vo);
		int result = mapper1.insert(vo);
		mapper2.updateReplyCnt(vo.getBno(), 1); 
		return result;
	}
	@Transactional
	@Override
	public int remove(int bno, int rno) {
		log.info("removeComment..."+rno);
		int result = mapper1.remove(rno);
		mapper2.updateReplyCnt(bno, -1); 
		return result;
	}
	@Override
	public int update(ReplyVO vo) {
		log.info("updateComment..."+vo);
		return mapper1.update(vo);
	}
}
