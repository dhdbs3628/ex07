package com.example.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Criteria;
import com.example.domain.PageMaker;
import com.example.domain.ReplyVO;
import com.example.mapper.ReplyMapper;
import com.example.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	@Autowired
	ReplyMapper mapper;
	
	@Autowired
	ReplyService service;
	
	@RequestMapping("/list")
	public HashMap<String, Object> list(int bno, int page){
		HashMap<String, Object> map = new HashMap();
		
		Criteria cri = new Criteria();
		cri.setPage(page);
		cri.setPerPageNum(5);
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(mapper.totalCount(bno));
		
		map.put("pm", pm);
		map.put("list", mapper.list(cri, bno));
		return map;		
	}
	
	@RequestMapping("/insert")
	public void insert(ReplyVO vo){
		service.insert(vo);
	}
	
	@RequestMapping("/delete")
	public void delete(int rno){
		service.delete(rno);
	}
}
