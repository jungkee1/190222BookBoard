package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl  implements ReplyService{
	private static final Logger logger = LoggerFactory.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	private ReplyMapper mapper;
	
	@Autowired //(inject�ص��� )
	private BoardMapper boardMapper;

	//�߰��ϱ�� ���ÿ� �θ��� ��۰��� +1 ������Ʈ
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		logger.info("register...."+vo);
		boardMapper.updateReplyCnt(vo.getBno(),1);
		return mapper.insert(vo);
	}
	
	//�󼼺���
	@Override
	public ReplyVO get(Long rno) {
		logger.info("get......" + rno);

		return mapper.read(rno);

	}
	
	//��� �����ϱ�
	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub

		logger.info("modify......" + vo);

		return mapper.update(vo);
	}
	
	//��� �����ϱ�
	@Transactional
	@Override
	public int remove(Long rno) {
		logger.info("remove....."+ rno);
		ReplyVO vo = mapper.read(rno); //���� �ڵ���..? �ϴ� ����� ���߿� �ּ�ó���ϰ� �� �Ǵ��� ������
		boardMapper.updateReplyCnt(vo.getBno(), -1); // �Խñ��� �޸� ��� count -1��Ű�°� �۾���..�̶�� ���������� �̹� �߰��Ҷ����� db�� +1�Ѱ� �ƴ϶� ������ ������ +1�س��� ���⼭ �׳� -1���ڰ����� �ָ� �ٷ� �ڵ����� ��
		return mapper.delete(rno); // ���� ��� ����
	}
	
	//����¡�� ������ ��ü����
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
		
	}
	
	

}
