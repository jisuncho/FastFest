package com.woori.yourhome.free_board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("freeboardService")
public class FreeBoardServiceImpl implements FreeBoardService{
	
	@Resource(name="freeboardDao")
	FreeBoardDao dao;

	@Override
	public List<FreeBoardDto> getList(FreeBoardDto dto) {
		
		return dao.getList(dto);
	}

	@Override
	public void insert(FreeBoardDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void insert_reply(FreeBoardDto dto) {
		dao.insert_reply(dto);
	}

	@Override
	public FreeBoardDto getView(FreeBoardDto dto) {
		
		return dao.getView(dto);
	}
	
	
}
