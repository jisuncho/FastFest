package com.woori.yourhome.calenmap;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// MapDaoImpl mapDao = new MapDaoImpl();
// MapDao mapDao = new MapDao();
@Repository("festDao")  //없으면 안된다. 스프링이 이거 보고 객체를 만들어서 관리한다 
public class FestDaoImpl implements FestDao{
	
	@Autowired 
	SqlSessionTemplate sm; //sm객체를 통해서 디비 데이터를 읽고 쓰기 

	@Override
	public List<FestDataDto> getList(DateDto dto) {
		
		//dto Calenmap.xml파일에 parameterType 에 전달된다. 
		// Calenmap_getList
		return sm.selectList("Calenmap_getList", dto);
	}
}
