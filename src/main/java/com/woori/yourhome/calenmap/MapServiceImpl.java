package com.woori.yourhome.calenmap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


// MapServiceImpl mapService = new MapServiceImpl();
// MapService mapService = new MapService();
@Service("mapService")
public class MapServiceImpl implements MapService{

	//@Autowired
	
	// MapDao dao = mapDao;
	@Resource(name="mapDao")
	MapDao dao;
	
	@Override
	public List<FestDataDto> getList(MapDto dto) {
		return dao.getList(dto);
	}

}
