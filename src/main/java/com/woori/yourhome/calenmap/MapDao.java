package com.woori.yourhome.calenmap;

import java.util.List;

public interface MapDao {
	List<FestDataDto> getList(MapDto dto);
}
