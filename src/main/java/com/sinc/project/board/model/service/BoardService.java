package com.sinc.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.BoardVO;
import com.sinc.project.pagination.Criteria;

public interface BoardService {
	public List<BoardVO> selectAll(Criteria cri);
	public Object selectOne(BoardVO obj);
	public int insert(BoardVO obj);
	public int update(BoardVO obj);
	public int delete(BoardVO obj);
	public int addViewCnt(BoardVO obj);
	public int totalCount();
	public List<? extends Object> searchService(Map<String, String> map);
}
