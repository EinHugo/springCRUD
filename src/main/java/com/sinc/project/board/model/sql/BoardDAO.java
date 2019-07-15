package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.BoardVO;

public interface BoardDAO {
	public List<BoardVO> selectAllBoard();

	BoardVO selectOneBoard(BoardVO vo);

	int insertBoard(BoardVO vo);
	
	List<BoardVO> searchRow(Map<String, String> map);
}
