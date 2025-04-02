package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;
@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper mapper;
	@Override
	public List<ReplyVO> getList(int bno) {
		log.info("getListComment..."+bno);
		return mapper.getList(bno);
	}
	@Override
	public ReplyVO get(int rno) {
		log.info("getComment..."+rno);
		return mapper.get(rno);
	}
	@Override
	public int insert(ReplyVO vo) {
		log.info("insertComment..."+vo);
		return mapper.insert(vo);
	}
	@Override
	public int update(ReplyVO vo) {
		log.info("updateComment..."+vo);
		return mapper.update(vo);
	}
	@Override
	public int remove(int rno) {
		log.info("removeComment..."+rno);
		return mapper.remove(rno);
	}
}
