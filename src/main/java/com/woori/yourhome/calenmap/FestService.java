package com.woori.yourhome.calenmap;

import java.util.List;

public interface FestService {
	List<FestDataDto> getList(DateDto dto);
}
