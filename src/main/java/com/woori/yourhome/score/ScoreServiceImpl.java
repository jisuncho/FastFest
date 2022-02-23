package com.woori.yourhome.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{

	@Resource(name="scoreDao")
	ScoreDao dao;
	
	@Override
	public List<ScoreDto> getList() {
		return dao.getList();
	}

	@Override
	public void insert(ScoreDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public ScoreDto getView(int id) {
		// TODO Auto-generated method stub
		return dao.getView(id);
	}

}
