package org.zerock.mapper;

import org.zerock.domain.BoardVO;

public interface BoardMapper {	//BoardMapper.xml을 함수 이름으로 부르면 그쪽에서 id로 받음
	public void insert(BoardVO board);
}
