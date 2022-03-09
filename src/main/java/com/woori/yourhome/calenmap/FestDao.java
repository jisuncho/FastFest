package com.woori.yourhome.calenmap;

import java.util.List;

public interface FestDao {
	List<FestDataDto> getList(DateDto dto);
}
