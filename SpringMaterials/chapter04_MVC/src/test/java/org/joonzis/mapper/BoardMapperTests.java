package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	// @Test
	public void getGetList() {
		List<BoardVO> list = mapper.getList();
		for(BoardVO vo : list) {
			log.info(vo);
		}
	}
	@Test
	public void getInsert() {
		//BoardVO vo = new BoardVO(0,3,"졸려","졸립니다.","나",null,null);
		//int result = mapper.insert(vo);
		//log.info("\n=========결과 : "+result+"==========");
	}
	//@Test
	public void getRead() {
		BoardVO vo = mapper.read(7);
		log.info("======================");
		log.info(vo);
		log.info("======================");
	}
	//@Test
	public void getDelete() {
		int result = mapper.delete(7);
		log.info("\n=========결과 : "+result+"==========");
	}
	//@Test
	public void getUpdate() {
		//BoardVO vo = new BoardVO(9,3,"커피","커피마심","나",null,null);
		//int result = mapper.update(vo);
		//log.info("\n=========결과 : "+result+"==========");
	}
}
