package com.woori.yourhome.free_board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("freeboardDao")
public class FreeBoardDaoImpl implements FreeBoardDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<FreeBoardDto> getList(FreeBoardDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("FreeBoard_getList", dto);
	}

	@Override
	public void insert(FreeBoardDto dto) {
		sm.insert("FreeBoard_insert", dto);
	}

	@Override
	public void insert_reply(FreeBoardDto dto) {
		sm.update("FreeBoard_updateLevel", dto);
		sm.insert("FreeBoard_reply", dto);
	}

	@Override
	public FreeBoardDto getView(FreeBoardDto dto) {

		return sm.selectOne("FreeBoard_getView", dto);
	}
	
}
