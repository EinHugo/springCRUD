package com.sinc.project.reply.mode.dao;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> selectAllReply(int seq);

	int insertReply(ReplyVO vo);
	
	int updateReply(ReplyVO vo);
	
	int deleteReply(ReplyVO vo);
	
}
