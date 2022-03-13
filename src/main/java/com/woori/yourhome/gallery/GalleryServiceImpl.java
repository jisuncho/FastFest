package com.woori.yourhome.gallery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService{
	
	@Resource(name="galleryDao")
	GalleryDao galleryDao;

	@Override
	public List<GalleryDto> getList(GalleryDto dto) {
		
		return galleryDao.getList(dto);
	}

	@Override
	public int getTotal(GalleryDto dto) {
		// TODO Auto-generated method stub
		return galleryDao.getTotal(dto);
	}

	@Override
	public void insert(GalleryDto dto) {
		galleryDao.insert(dto);
	}

	@Override
	public void update(GalleryDto dto) {
		galleryDao.update(dto);
	}

	@Override
	public void delete(GalleryDto dto) {
		galleryDao.delete(dto);		
	}

	@Override
	public GalleryDto getView(GalleryDto dto) {
		
		return galleryDao.getView(dto);
	}
	
	
}
