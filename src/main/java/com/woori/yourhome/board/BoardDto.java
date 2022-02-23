package com.woori.yourhome.board;

import com.woori.yourhome.common.BaseDto;

public class BoardDto extends BaseDto{
	
	private String id="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private String username="";
	 
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	public BoardDto(String id, String title, String writer, String contents, String wdate) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.contents = contents;
		this.wdate = wdate;
	}
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
