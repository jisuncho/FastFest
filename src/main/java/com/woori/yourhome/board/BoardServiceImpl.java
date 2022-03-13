package com.woori.yourhome.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woori.yourhome.comment.CommentDao;
import com.woori.yourhome.comment.CommentDto;


@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	//@Autowired
	@Resource(name="boardDao")
	BoardDao boardDao;
	
	@Resource(name="commentDao")
	CommentDao commentDao;
	

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return boardDao.getList(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		
		boardDao.insert(dto);
		
	}

	@Override
	public BoardDto getView(String id) {
		
		return boardDao.getView(id);
	}

	@Override
	public int getTotal(BoardDto dto) {
		
		return boardDao.getTotal(dto);
	}

	@Override
	public void delete(String id) {
		boardDao.delete(id);
		
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
		
	}

	@Override
	public void comment_insert(CommentDto dto) {
		commentDao.insert(dto);
		
	}

	@Override
	public List<CommentDto> getCommentList(CommentDto dto) {
		return commentDao.getList(dto);
	}

	@Override
	public CommentDto getCommentView(CommentDto dto) {
		
		return commentDao.comment_getView(dto);
	}

	@Override
	public void comment_update(CommentDto dto) {
		commentDao.comment_update(dto);
		
	}

	@Override
	public void comment_delete(CommentDto dto) {
		commentDao.comment_delete(dto);
		
	}
	
}
