package com.example.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.domain.BoardVO;
import com.example.domain.Criteria;
import com.example.mapper.BoardMapper;
import com.example.mapper.MysqlMapper;

@RunWith(SpringJUnit4ClassRunner.class) //먼저 SpringJUnit4ClassRunner.class import한다.
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class MysqlTest {
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void list() {
		Criteria cri=new Criteria();
		cri.setPage(2);
		mapper.list(cri); 
	}
	
	@Test
	public void insert(){
		BoardVO vo=new BoardVO();
		vo.setTitle("제목입니다...");
		vo.setContent("내용입니다...");
		vo.setWriter("user01");
		mapper.insert(vo);
		mapper.addAttach("d.jpg");
	}
}
