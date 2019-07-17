package com.sinc.project.reply.mode.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.sinc.project.model.model.vo.ReplyVO;

@Service("replyDAOImpl")
public class ReplyDAOImpl implements ReplyDAO {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public List<ReplyVO> selectAllReply(int seq) {
		return session.selectList("com.sinc.reply.selectAllReply", seq);
	}

	@Override
	public int insertReply(ReplyVO vo) {
		System.out.println(vo);
		return session.insert("com.sinc.reply.insertReply", vo);
	}

	@Override
	public int updateReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(ReplyVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
