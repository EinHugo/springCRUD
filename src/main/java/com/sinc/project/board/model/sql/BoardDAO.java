package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.BoardVO;
import com.sinc.project.pagination.Criteria;

public interface BoardDAO {
	public List<BoardVO> selectAllBoard(Criteria cri);

	BoardVO selectOneBoard(BoardVO vo);

	int insertBoard(BoardVO vo);
	
	int updateBoard(BoardVO vo);
	
	int deleteBoard(BoardVO vo);
	
	int addViewCount(BoardVO vo);
	
	int totalCount();
	
	List<BoardVO> searchRow(Map<String, String> map);
}
