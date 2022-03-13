package com.woori.yourhome.score;

import java.util.List;

public interface ScoreDao {
	List<ScoreDto> getList();
	void insert(ScoreDto dto);
	ScoreDto getView(int id);
}
