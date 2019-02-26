package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//�߰��ϱ�
	public int register(ReplyVO vo);
	
	//�󼼺���
	public ReplyVO get(Long rno);
	
	//�����ϱ�
	public int modify(ReplyVO vo);
	
	//�����ϱ�
	public int remove(Long rno);


	//����¡�� ������ ��ü����
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
