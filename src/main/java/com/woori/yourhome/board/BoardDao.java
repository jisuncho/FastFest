package com.woori.yourhome.board;

import java.util.List;
//클래스와의 결합력을 약화시키기 위해서 
public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	int getTotal(BoardDto dto);
	void insert(BoardDto dto);
	BoardDto getView(String id);
	void delete(String id);
	void update(BoardDto dto);
}
