package com.sinc.project.board.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.model.model.vo.ReplyVO;
import com.sinc.project.reply.mode.dao.ReplyDAOImpl;

@Service("replyServiceImpl")
public class ReplyServiceImpl implements ReplyService {
	
	@Resource(name="replyDAOImpl")
	ReplyDAOImpl dao;
	
	@Override
	public List<? extends Object> selectAll(int seq) {
		return dao.selectAllReply(seq);
	}

	@Override
	public int insert(ReplyVO obj) {
		return dao.insertReply(obj);
	}

	@Override
	public int update(ReplyVO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ReplyVO obj) {
		// TODO Auto-generated method stub
		return 0;
	}


}
