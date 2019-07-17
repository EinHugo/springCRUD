package com.sinc.project.board.ctrl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.board.model.service.BoardServiceImpl;
import com.sinc.project.model.model.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardCtrl {
	@Resource(name="boardServiceImpl")
	private BoardServiceImpl service;
	
	@RequestMapping("/listPage.sinc")
	public String listPage(Model model) {
		List<BoardVO> list = service.selectAll();
		model.addAttribute("list", list);
		return "/board/listPage";
	}
	
	@RequestMapping("/readPage.sinc")
	public String detailPage(@RequestParam int seq, Model model) {
		
		BoardVO vo = new BoardVO(seq);
		BoardVO board = service.selectOne(vo);
		model.addAttribute("board", board);
		return "/board/readPage";
		
	}
	
	@RequestMapping(value="/register.sinc", method=RequestMethod.GET)
	public void register() {}
	
	@RequestMapping(value="/registerBoard.sinc", method=RequestMethod.POST)
	public String registerBoard(BoardVO vo) {
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
