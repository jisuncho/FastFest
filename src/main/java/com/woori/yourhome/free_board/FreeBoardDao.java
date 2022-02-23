package com.woori.yourhome.free_board;

import java.util.List;

public interface FreeBoardDao {
	List<FreeBoardDto> getList(FreeBoardDto dto);
	void insert(FreeBoardDto dto);
	void insert_reply(FreeBoardDto dto);
	FreeBoardDto getView(FreeBoardDto dto);
}
