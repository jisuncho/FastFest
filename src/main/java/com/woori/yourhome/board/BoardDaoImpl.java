package com.woori.yourhome.board;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDao")  //없으면 안된다. 스프링이 이거 보고 객체를 만들어서 관리한다 
public class BoardDaoImpl implements BoardDao{
	
	@Autowired 
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기 

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		//dto Board.xml파일에 parameterType 에 전달된다. 
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public BoardDto getView(String id) {
		
		return sm.selectOne("Board_getView", id);
	}

	@Override
	public int getTotal(BoardDto dto) {
		
		return sm.selectOne("Board_getTotal", dto);
	}

	@Override
	public void delete(String id) {
		sm.delete("Board_delete", id);
	}

	@Override
	public void update(BoardDto dto) {
		sm.update("Board_update", dto);
	}
}




