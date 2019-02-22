package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.zerock.book.HomeController;
import org.zerock.domain.BoardVO;


public interface BoardService {

	
	public void register(BoardVO board); //�߰�
	
	public BoardVO get(Long bno); // �󼼺���
	
	public boolean modify(BoardVO board); //����
	
	public boolean remove(Long bno); //����
	
	public List<BoardVO> getList(); //��ü����
	
//	public List<BoardVO> getList(Criteria cri);
//	public int getTotal(Criteria cri);
	
	public int getTotal(); //����

}
