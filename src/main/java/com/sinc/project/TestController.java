package com.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.test.service.TestServiceImpl;

@Controller
//@RequestMapping("/bbs")
public class TestController {
	
	@Resource(name="testS")
	private TestServiceImpl service;
	
	@RequestMapping("/dependency.sinc")
	public String dependency(Model model) {
		
		System.out.println("test dependency");
		System.out.println(service.sayEcho("HIHIHIHI"));
		model.addAttribute("msg", "HIHIHIHI");
		return "home";
		
	}
	
	@RequestMapping("/index.sinc")
	public String main(Model model) {
		
		
		return "home";
	}
	
	@RequestMapping("/a.sinc")
	public String doA() {
		
		System.out.println("test doA");
		
		return "/test/a";
		
	}
	
	@RequestMapping("/b.sinc")
	public ModelAndView doB() {
		
		System.out.println("test doB");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", "doB model and view");
		
		return mv;
	}
}
