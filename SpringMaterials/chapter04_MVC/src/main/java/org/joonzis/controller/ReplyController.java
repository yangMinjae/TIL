package org.joonzis.controller;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RestController
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	private ReplyService service;
	
	// 1. 등록
	// consumes = 수신 데이터 포맷
	// produces = 출력 데이터 포맷
	@PostMapping(value="/new", 
			consumes = "application/json",
			produces = MediaType.TEXT_PLAIN_VALUE
			)
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		log.info("create..."+vo);
		int insertCount = service.insert(vo);
		log.info("Reply Insert Count..."+insertCount);
		return insertCount == 1? new ResponseEntity<String>("success",HttpStatus.OK): 
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 2. 조회
	@GetMapping(value = "/{rno}",
			produces = {
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno){
		log.info("get...");
		
		return new ResponseEntity<ReplyVO>(service.get(rno),HttpStatus.OK);
	}
	
	// 3. 삭제
	@DeleteMapping(value = "/{rno}/{bno}",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> remove(@PathVariable("rno") int rno, @PathVariable("bno") int bno){
		log.info("remove..."+rno);
		int removeCount = service.remove(bno,rno);
		return removeCount == 1? new ResponseEntity<String>("success",HttpStatus.OK): 
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 4. 수정
	@RequestMapping(method = {
			RequestMethod.PUT,
			RequestMethod.PATCH},
			value = "/{rno}",
			consumes = "application/json",
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> modify(@PathVariable("rno") int rno, @RequestBody ReplyVO vo){
		vo.setRno(rno);
		log.info("rno : "+rno);
		log.info("modify : "+vo);
		int modifyCount = service.update(vo);
		return modifyCount == 1? new ResponseEntity<String>("success",HttpStatus.OK): 
			new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 5. 전체 댓글 리스트
	// 5. 전체 댓글 - /reply/pages/:bno - GET
	@GetMapping(value = "/pages/{bno}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") int bno){
		log.info("getList..."+bno);
		ResponseEntity<List<ReplyVO>> result = new ResponseEntity<List<ReplyVO>>(service.getList(bno), HttpStatus.OK);
		log.info(result);
		return result;
				
	}
}
