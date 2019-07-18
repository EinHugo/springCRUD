package com.sinc.project.reply.ctrl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.board.model.service.ReplyServiceImpl;
import com.sinc.project.model.model.vo.ReplyVO;
import com.sinc.project.test.model.vo.UserVO;

@Controller
@RequestMapping("/board")
public class ReplyCtrl {
	@Resource(name="replyServiceImpl")
	ReplyServiceImpl service;
	
	@RequestMapping("/replyInsert.sinc")
	public @ResponseBody List<ReplyVO> replyInsert(ReplyVO vo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("ReplyCtrl#replyInsert");
		// 로그인 처리는 LoginInterceptor 에서 처리하였음
		
		HttpSession session = request.getSession();
		Object loginUser = session.getAttribute("loginUser");
		if(loginUser != null) {
			vo.setRwriter(((UserVO)loginUser).getId());
		} else {
			System.out.println("!!Not Logged in!!");
		}
		
		int result = service.insert(vo);
		if(result != 0) {
			// success
			System.out.println("Reply insert Success");
			int seq = vo.getSeq();
			List<ReplyVO> replies = (List<ReplyVO>) service.selectAll(seq);
			return replies;
			
		} else {
			System.out.println("Reply insert Fail");
			
			
		}
		
		return null;
	}
	
	public List<ReplyVO> replySelect(int seq) {
	
		
		
		return null;
	}
}
