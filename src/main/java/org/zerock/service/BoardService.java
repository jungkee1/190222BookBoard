package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;



public interface BoardService {

	
	public void register(BoardVO board); //추가
	
	public BoardVO get(Long bno); // 상세보기
	
	public boolean modify(BoardVO board); //수정
	
	public boolean remove(Long bno); //삭제
	
	public List<BoardVO> getList(); //전체보기
	
	public List<BoardVO> getList(Criteria cri); //검색포함 전체보기
	public int getTotal(Criteria cri);	//검색포함 게시물 수
	
	public int getTotal(); //개수

}
