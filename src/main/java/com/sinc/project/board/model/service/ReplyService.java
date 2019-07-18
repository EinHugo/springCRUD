package com.sinc.project.board.model.service;

import java.util.List;
import java.util.Map;

import com.sinc.project.model.model.vo.ReplyVO;

public interface ReplyService {
	public List<? extends Object> selectAll(int seq);
	public int insert(ReplyVO obj);
	public int update(ReplyVO obj);
	public int delete(ReplyVO obj);
}
