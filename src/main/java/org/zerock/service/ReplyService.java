package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//추가하기
	public int register(ReplyVO vo);
	
	//상세보기
	public ReplyVO get(Long rno);
	
	//수정하기
	public int modify(ReplyVO vo);
	
	//삭제하기
	public int remove(Long rno);


	//페이징을 포함한 전체보기
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
