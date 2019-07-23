package com.sinc.project.board.model.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.board.model.sql.BoardDAO;
import com.sinc.project.model.model.vo.BoardVO;
import com.sinc.project.pagination.Criteria;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDAOImpl")
	private BoardDAO dao;
	
	public List<BoardVO> selectAll(Criteria cri) {
		return dao.selectAllBoard(cri);
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

	@Override
	public int update(BoardVO vo) {
		return dao.updateBoard(vo);
	}

	@Override
	public int delete(BoardVO vo) {
		return dao.deleteBoard(vo);
	}

	@Override
	public int addViewCnt(BoardVO obj) {
		return dao.addViewCount(obj);
	}

	@Override
	public int totalCount() {
		return dao.totalCount();
	}
	

}
