package org.joonzis.mapper;

import org.joonzis.domain.BoardAttachVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardAttachMapperTests {
	@Autowired
	private BoardAttachMapper mapper;
	private BoardAttachVO vo =null;
	
	@Test
	public void getInsert() {
		log.info("getInsert...");
		vo.setBno(454);
		vo.setFileName("testName");
		vo.setUploadPath("testPath");
		vo.setUuid("testUUID");
	}
}
