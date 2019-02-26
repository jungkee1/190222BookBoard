package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {	//BoardMapper.xml�� �Լ� �̸����� �θ��� ���ʿ��� id�� ����
	//public void insert(BoardVO board); // �߰��ε� �ؿ����� �����
	public Integer insertSelectKey(BoardVO board); //seq �߰��ؼ� �� �߰�
	public List<BoardVO> getList(); // ��ü����
	public int getTotal(); 			//�Խñ� �� ��
	public BoardVO get(Long bno); //�󼼺���

	public int delete(Long bno);
	public int update(BoardVO board);
	
	//����¡
	public List<BoardVO> getListWithPaging(Criteria cri); //@Param = map ��ſ� ���°�. ���� map �ȴ�� �׳� ���� ���������°�. RequestParam�̶��� �ٸ�
	public int getTotalCount(Criteria cri);
	
	//��ۼ� �߰��ʿ� ���� ��� count +1
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount); 
		// TODO Auto-generated method stub
		
	
}
