package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.board.model.service.BoardServiceImpl;
import com.sinc.project.model.model.vo.BoardVO;
import com.sinc.project.pagination.Criteria;
import com.sinc.project.pagination.PageDTO;
import com.sinc.project.test.model.vo.UserVO;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	@Resource(name="boardServiceImpl")
	private BoardServiceImpl service;
	
	@RequestMapping("/listPage.sinc")
	public String listPage(Model model, Criteria cri) {
		List<BoardVO> list = service.selectAll(cri);
		int total = service.totalCount();
		PageDTO page = new PageDTO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		
		/*
		 * Map<String, Integer> param = new HashMap(); param.put("firstPageNo", 1);
		 * param.put("prevPageNo", 2); param.put("startPageNo", 4);
		 * param.put("endPageNo", 8); param.put("nextPageNo", 9);
		 * param.put("finalPageNo", 10);
		 */
		
		return "/board/listPage";
	}
	
	@RequestMapping("/readPage.sinc")
	public String detailPage(@RequestParam int seq, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {
			model.addAttribute("userSignedIn", true);
			model.addAttribute("currentUser", (UserVO)(session.getAttribute("loginUser")));
		} else {
			model.addAttribute("userSignedIn", false);
		}
		
		
		
		BoardVO vo = new BoardVO(seq);
		BoardVO board = service.selectOne(vo);
		service.addViewCnt(board);
		System.out.println();
		
		model.addAttribute("board", board);
		return "/board/readPage";
		
	}
	
	@RequestMapping(value="/register.sinc", method=RequestMethod.GET)
	public void register() {}
	
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.POST)
	public String registerBoard(BoardVO vo) {
		
		String content = vo.getContent();
		content = content.replace("script", "");
		content = content.replace("onerror", "");
		content = content.replace("textarea", "");
		vo.setContent(content);
		
		int result = service.insert(vo);
		
		if(result != 0 ) {
			return "redirect:/board/listPage.sinc";
		} else {
			return "/board/register.sinc";
		}
	}
	
	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.GET)
	public String modifyPage(BoardVO vo, Model model) {
		System.out.println("modifyPage.sinc");
		BoardVO board = service.selectOne(vo);
		model.addAttribute("board", board);
		return "/board/modifyPage";
	}
	
	@RequestMapping(value="/modifyPage.sinc", method=RequestMethod.POST)
	public String modifyPage(BoardVO vo) {
		
		int result = service.update(vo);
		if(result != 0) {
			return "redirect:/board/readPage.sinc?seq=" + vo.getSeq();
		} else {
			return "redirect:/board";
		}
	}
	
	@RequestMapping("/removePage.sinc")
	public String removePage(BoardVO vo) {
		System.out.println("removePage.sinc");
		int result = service.delete(vo);
		if(result != 0) {
			return "redirect:/board/listPage.sinc";
		} else {
			return "redirect:/board/readPage.sinc?seq=" + vo.getSeq();
		}
		
	}
	
	@RequestMapping(value="/search.sinc", method=RequestMethod.POST)
	public @ResponseBody List<BoardVO> search(String type, String keyword, HashMap<String, String> map) {
		map.put("type", type); map.put("keyword", keyword);
		List<BoardVO> result = service.searchService(map);
		System.out.println(result);
		return result;
	}
	
}
