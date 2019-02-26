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
	
	@Autowired //(inject해도됨 )
	private BoardMapper boardMapper;

	//추가하기와 동시에 부모굴의 댓글개수 +1 업데이트
	@Transactional
	@Override
	public int register(ReplyVO vo) {
		// TODO Auto-generated method stub
		logger.info("register...."+vo);
		boardMapper.updateReplyCnt(vo.getBno(),1);
		return mapper.insert(vo);
	}
	
	//상세보기
	@Override
	public ReplyVO get(Long rno) {
		logger.info("get......" + rno);

		return mapper.read(rno);

	}
	
	//댓글 수정하기
	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub

		logger.info("modify......" + vo);

		return mapper.update(vo);
	}
	
	//댓글 삭제하기
	@Transactional
	@Override
	public int remove(Long rno) {
		logger.info("remove....."+ rno);
		ReplyVO vo = mapper.read(rno); //무슨 코드지..? 일단 써놓고 나중에 주석처리하고 잘 되는지 봐야지
		boardMapper.updateReplyCnt(vo.getBno(), -1); // 게시글의 달린 댓글 count -1시키는거 작업중..이라고 쓸려했으니 이미 추가할때부터 db에 +1한게 아니라 저렇게 변수로 +1해놔서 여기서 그냥 -1인자값으로 주면 바로 자동으로 됨
		return mapper.delete(rno); // 실제 댓글 삭제
	}
	
	//페이징을 포함한 전체보기
	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		
		return new ReplyPageDTO(mapper.getCountByBno(bno), mapper.getListWithPaging(cri, bno));
		
	}
	
	

}
