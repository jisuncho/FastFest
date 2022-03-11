package com.woori.yourhome.main;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("MainService")
public class MainServiceImpl implements MainService{
	
	@Resource(name="MainDao")
	MainDao dao;

	@Override
	public List<MainDto> getList(MainDto dto) {
		
		return dao.getList(dto);
	}

	
	
	
}
