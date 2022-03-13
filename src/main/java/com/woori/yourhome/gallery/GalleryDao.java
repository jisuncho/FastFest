package com.woori.yourhome.gallery;

import java.util.List;

public interface GalleryDao {
	List<GalleryDto> getList(GalleryDto dto);
	int getTotal(GalleryDto dto);
	void insert(GalleryDto dto );
	void update(GalleryDto dto );
	void delete(GalleryDto dto );
	GalleryDto getView(GalleryDto dto);
}
