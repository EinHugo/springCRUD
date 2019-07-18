package com.sinc.project.board.model.sql;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.project.model.model.vo.BoardVO;
import com.sinc.project.model.model.vo.ReplyVO;

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
		List<ReplyVO> replies = session.selectList("com.sinc.reply.selectAllReply", vo.getSeq());
		BoardVO result = session.selectOne("com.sinc.board.selectOne", vo);
		result.setRlist(replies);
		return result;
	}
	
	@Override 
	public int insertBoard(BoardVO vo) {
		return session.insert("com.sinc.board.insertBoard", vo);
	}

	@Override
	public List<BoardVO> searchRow(Map<String, String> map) {
		return session.selectList("com.sinc.board.searchAjax", map);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return session.update("com.sinc.board.updateBoard", vo);
	}

	@Override
	public int deleteBoard(BoardVO vo) {
		return session.delete("com.sinc.board.deleteBoard", vo);
	}

	@Override
	public int addViewCount(BoardVO vo) {
		System.out.println("addViewCount");
		return session.update("com.sinc.board.addViewCount", vo);
	}
	

}
