package org.zerock.domain;

public class Criteria {
	private int pageNum=1;
	private int amount=5; //한 화면에 보이는 게시물 수
	private String type; // filed 
	private String keyword; //검색어
	private String[] typeArr;
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNum, int amount) {
		// TODO Auto-generated constructor stub
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String[] getTypeArr() {
		return type ==null? new String[] {}:type.split("");
	}
	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

}
