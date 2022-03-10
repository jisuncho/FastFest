package com.woori.yourhome.calenmap;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


// MapServiceImpl mapService = new MapServiceImpl();
// MapService mapService = new MapService();
@Service("festService")
public class FestServiceImpl implements FestService{

	//@Autowired
	
	// MapDao dao = mapDao;
	@Resource(name="festDao")
	FestDao dao;
	
	@Override
	public List<FestDataDto> getList(DateDto dto) {
		return dao.getList(dto);
	}

}
