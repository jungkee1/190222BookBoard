package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.book.HomeController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private BoardMapper mapper;
	
	//추가
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		logger.info("log...추가");
		mapper.insertSelectKey(board);
		//mapper.insert(board); //위에걸로 대신함
		
	}
	//상세보기
	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		logger.info("log...상세보기");
		return mapper.get(bno);
	}
	//수정하기
	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		logger.info("modify...."+ board);
		return mapper.update(board) == 1;
	}
	//삭제하기
	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		logger.info("remove...."+ bno);
		return mapper.delete(bno) == 1;
	}
	//전체보기
	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
		
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}
	//검색포함 전체보기
	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		logger.info("get List with crieria:" +cri);
		return mapper.getListWithPaging(cri);
	}
	//검색포함 게시물 수
	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		logger.info("get total count");
		return mapper.getTotalCount(cri);
	}

}
