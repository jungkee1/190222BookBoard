package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zerock.book.HomeController;
import org.zerock.domain.BoardVO;


public interface BoardService {

	
	public void register(BoardVO board); //추가
	
	public BoardVO get(Long bno); // 상세보기
	
	public boolean modify(BoardVO board); //수정
	
	public boolean remove(Long bno); //삭제
	
	public List<BoardVO> getList(); //전체보기
	
//	public List<BoardVO> getList(Criteria cri);
//	public int getTotal(Criteria cri);
	
	public int getTotal(); //개수

}
