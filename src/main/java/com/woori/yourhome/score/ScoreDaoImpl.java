package com.woori.yourhome.score;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("scoreDao")
public class ScoreDaoImpl implements ScoreDao {

	@Autowired
	SqlSessionTemplate sm;
	
	//sm - selectList("쿼리아이디", dto);   List<ScoreDto>  
	//     parameterType="ScoreDto"     resultType="ScoreDto"
	//     insert
	//     selectOne 
	
	@Override
	public List<ScoreDto> getList() {
		//id="Score_getList"  parameterType="ScoreDto"  resultType="ScoreDto"
		//xml파일의 쿼리 id 값 
		return sm.selectList("Score_getList", null);
	}

	@Override
	public void insert(ScoreDto dto) {
		dto.calc();
		sm.insert("Score_insert", dto);
	}

	@Override
	public ScoreDto getView(int id) {
		
		return sm.selectOne("Score_getView", id+"");
	}

}




