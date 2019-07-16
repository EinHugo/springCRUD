package com.sinc.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.BoardVO;

public interface BoardService {
	public List<? extends Object> selectAll();
	public Object selectOne(BoardVO obj);
	public int insert(BoardVO obj);
	public int update(BoardVO obj);
	public int delete(BoardVO obj);
	public List<BoardVO> searchService(Map<String, String> map);
}
