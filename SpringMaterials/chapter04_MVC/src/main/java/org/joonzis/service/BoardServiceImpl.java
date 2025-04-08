package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.mapper.BoardAttachMapper;
import org.joonzis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardMapper mapper;
	@Autowired
	private BoardAttachMapper attachMapper;
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
	@Transactional
	@Override
	public boolean register(BoardVO vo) {
		log.info("register..."+vo);
		// 1. tbl_board 테이블에 게시글 등록
		int result = mapper.insertTest(vo);
		int bno = vo.getBno();
		// 2. 첨부 파일이 존재하면, 파일 테이블에 데이터 등록
		if(vo.getAttachList()!=null&&vo.getAttachList().size()>0) {
			vo.getAttachList().forEach(attach->{
				attach.setBno(bno);
				attachMapper.insert(attach);
			});
		}
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
	
	@Override
	public int getTotal() {
		return mapper.getTotal();
	}
	
	@Override
	public List<BoardVO> getListByPage(Criteria cri) {
		return mapper.getListByPage(cri);
	}
	
	@Override
	public List<BoardAttachVO> getAttachList(int bno) {
		log.info("getAttachList..."+bno);
		return attachMapper.findByBno(bno);
	}
}
