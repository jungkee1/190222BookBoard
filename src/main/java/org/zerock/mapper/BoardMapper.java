package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {	//BoardMapper.xml을 함수 이름으로 부르면 그쪽에서 id로 받음
	//public void insert(BoardVO board); // 추가인데 밑에껄로 대신함
	public Integer insertSelectKey(BoardVO board); //seq 추가해서 글 추가
	public List<BoardVO> getList(); // 전체보기
	public int getTotal(); 			//게시글 개 수
	public BoardVO get(Long bno); //상세보기

	public int delete(Long bno);
	public int update(BoardVO board);
	
	//페이징
	public List<BoardVO> getListWithPaging(Criteria cri); //@Param = map 대신에 쓰는것. 값을 map 안담고 그냥 같이 보내버리는것. RequestParam이랑은 다름
	public int getTotalCount(Criteria cri);
	
	//댓글수 추가됨에 따라 댓글 count +1
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount); 
		// TODO Auto-generated method stub
		
	
}
