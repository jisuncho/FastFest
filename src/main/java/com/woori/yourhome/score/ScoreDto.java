package com.woori.yourhome.score;

public class ScoreDto {
	private int id=1;
	private String name="";
	private int kor=0;
	private int eng=0;
	private int mat=0;
	private int sci=0;
	private int total=0;
	private int average=0;
	private String wdate="";
	
	
		
	public String getWdate() {
		return wdate;
	}



	public void setWdate(String wdate) {
		this.wdate = wdate;
	}



	public void calc()
	{
		this.total = this.kor + this.eng + this.mat + this.sci;
		this.average = this.total/4;
	}
	


	public int getAverage() {
		return average;
	}



	public void setAverage(int average) {
		this.average = average;
	}



	public int getSci() {
		return sci;
	}



	public void setSci(int sci) {
		this.sci = sci;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
		
}
