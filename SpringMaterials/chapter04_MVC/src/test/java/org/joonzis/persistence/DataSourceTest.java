package org.joonzis.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// 스프링 컨테이너와 매핑
public class DataSourceTest {
	
	@Autowired		// new 안해도 ContextConfiguration의 경로의 bean을 통해 객체가자동 생성됨
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			log.info(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testMyBatis() {
		try (SqlSession session = sqlSessionFactory.openSession()){
			log.info(session);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
