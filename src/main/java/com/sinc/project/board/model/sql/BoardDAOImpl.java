package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.project.model.model.vo.BoardVO;

@Service("boardDAOImpl")
public class BoardDAOImpl implements BoardDAO {
	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Override
	public List<BoardVO> selectAllBoard() {
		return session.selectList("com.sinc.board.selectAll");
	}
	
	@Override
	public BoardVO selectOneBoard(BoardVO vo) {
		return session.selectOne("com.sinc.board.selectOne", vo);
	}
	
	@Override 
	public int insertBoard(BoardVO vo) {
		return session.insert("com.sinc.board.insertBoard", vo);
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		return session.selectList("com.sinc.board.searchAjax", map);
	}
	

}
