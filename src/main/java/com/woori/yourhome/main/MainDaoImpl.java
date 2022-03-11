package com.woori.yourhome.main;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MainDao")
public class MainDaoImpl implements MainDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<MainDto> getList(MainDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Main_getList", dto);
	}

	
	
}
