package org.joonzis.service;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.mapper.BoardAttachMapper;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.ReplyMapper;
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
	@Autowired
	private ReplyMapper replyMapper;
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
	
	@Transactional
	@Override
	public boolean modify(BoardVO vo, boolean changed) {
		log.info("modify..."+vo);
		int result = mapper.update(vo);
		int bno = vo.getBno();
		if(changed) {	// 파일시스템, db에서 파일 삭제
			List<BoardAttachVO> list = attachMapper.findByBno(bno);
			for (BoardAttachVO attach : list) {
				String path = "C:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName();
				File file = new File(path);
				if(file.exists()) {
					file.delete();
				}else {
					log.warn("<!!파일이 존재하지 않습니다.!!>");
				}
				//--------------------------------------------
				deleteEmptyFolder(attach.getUploadPath());		
				//--------------------------------------------
			}
			int a =attachMapper.deleteByBno(bno);	//db 삭제
			if(a==0) {
				log.warn("db에서 삭제된 파일이 없습니다.");
			}
		}
		if(vo.getAttachList()!=null&&vo.getAttachList().size()>0) {
			vo.getAttachList().forEach(attach->{
				log.warn("attach..."+attach.getFileName());
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
	@Transactional
	@Override
	public boolean register(BoardVO vo) {
		log.warn("register..."+vo.getContent());
		// 1. tbl_board 테이블에 게시글 등록
		int result = mapper.insertTest(vo);
		int bno = vo.getBno();
		// 2. 첨부 파일이 존재하면, 파일 테이블에 데이터 등록
		if(vo.getAttachList()!=null&&vo.getAttachList().size()>0) {
			vo.getAttachList().forEach(attach->{
				log.warn("attach..."+attach.getFileName());
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
	@Transactional
	@Override
	public void remove(int bno) {
		log.info("remove..."+bno);
		replyMapper.removeByBno(bno);
		List<BoardAttachVO> list = attachMapper.findByBno(bno);
		for (BoardAttachVO attach : list) {
			String path = "C:\\upload\\"+attach.getUploadPath()+"\\"+attach.getUuid()+"_"+attach.getFileName();
			File file = new File(path);
			if(file.exists()) {
				file.delete();
			}else {
				log.warn("<!!파일이 존재하지 않습니다.!!>");
			}
			deleteEmptyFolder(attach.getUploadPath());
		}
		attachMapper.deleteByBno(bno);
		mapper.delete(bno);

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
	@Override
	public void deleteByBno(int bno) {
		attachMapper.deleteByBno(bno);
	}
	private void deleteEmptyFolder(String uploadPath) {
		String[] folderDepth = uploadPath.split("\\\\");
		String  rootFolder = "C:\\upload\\";
		String fullPath = rootFolder+uploadPath;
		String currentPath=new String(fullPath);
		File file=null;
		for (int i = 0; i < folderDepth.length; i++) {
			file=new File(currentPath);
			if(file.exists()) {
				if(!file.delete()) {
					log.warn("폴더 내부에 파일 존재");
				}
			}
			currentPath=currentPath.substring(0,currentPath.lastIndexOf("\\"));
		}
	}
}
