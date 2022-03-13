package com.woori.yourhome.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("galleryDao")
public class GalleryDaoImpl implements GalleryDao{

	@Autowired 
	SqlSessionTemplate sm;
	
	
	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		return sm.selectList("Gallery_getList", dto);
	}

	@Override
	public int getTotal(GalleryDto dto) {
		
		return sm.selectOne("Gallery_getTotal", dto);
	}

	@Override
	public void insert(GalleryDto dto) {
		sm.insert("Gallery_insert", dto);
	}

	@Override
	public void update(GalleryDto dto) {
		sm.update("Gallery_update", dto);		
	}

	@Override
	public void delete(GalleryDto dto) {
		sm.delete("Gallery_delete", dto);		
	}

	@Override
	public GalleryDto getView(GalleryDto dto) {
		return sm.selectOne("Gallery_getView", dto);
	}

}
