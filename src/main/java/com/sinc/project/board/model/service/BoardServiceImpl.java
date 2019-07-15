package com.sinc.project.board.model.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDAO;
import com.sinc.project.model.model.vo.BoardVO;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAOImpl")
	private BoardDAO dao;
	
	public List<BoardVO> selectAll() {
		return dao.selectAllBoard();
	}
	
	public BoardVO selectOne(BoardVO vo) {
		return dao.selectOneBoard(vo);
	}

	@Override
	public int insert(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> searchService(Map<String, String> map) {
		return dao.searchRow(map);
	}
	

}
