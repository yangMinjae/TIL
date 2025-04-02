package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.domain.ReplyVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	//@Test
	public void getGetList() {
		List<ReplyVO> list = mapper.getList(454);
		for(ReplyVO vo : list) {
			log.info("\n=========결과 : "+vo+"==========");
		}
	}
	//@Test
	public void getInsert() {
		ReplyVO vo = new ReplyVO();
		vo.setBno(454);
		vo.setReply("정말 집에가고 싶습니다. 진심입니다.");
		vo.setReplyer("노숙자");
		int result = mapper.insert(vo);
		log.info("\n=========결과 : "+result+"==========");
	}
	//@Test
	public void getGet() {
		ReplyVO vo = mapper.get(1);
		log.info("======================");
		log.info(vo);
		log.info("======================");
	}
	//@Test
	public void getRemove() {
		int result = mapper.remove(1);
		log.info("\n=========결과 : "+result+"==========");
	}
	//@Test
	public void getUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setReply("장난입니다.");
		vo.setRno(2);
		int result = mapper.update(vo);
		log.info("\n=========결과 : "+result+"==========");
	}
}
