package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyMapper {
	//´ñ±Û Ãß°¡
	public int insert(ReplyVO vo);
	
	//´ñ±Û ÀüÃ¼º¸±â
	public List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno); 
	
	//´ñ±Û °³¼ö
	public int getCountByBno(Long bno);	
	
	//´ñ±Û »ó¼¼º¸±â
	public ReplyVO read(Long bno);
	
	//´ñ±Û »èÁ¦
	public int delete(Long rno);
	
	//´ñ±Û ¼öÁ¤
	public int update(ReplyVO vo);
	

}
