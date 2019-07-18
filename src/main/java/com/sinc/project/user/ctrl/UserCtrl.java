package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sinc.project.test.model.vo.UserVO;
import com.sinc.project.test.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
@SessionAttributes({"loginUser"}) 
public class UserCtrl {

	@Resource(name = "userServiceImpl")
	private UserServiceImpl service;

	@RequestMapping("/loginForm.sinc")
	public String loginForm() {
		return "/user/login";
	}

	@RequestMapping(value="/join.sinc", method=RequestMethod.POST)
	public String join(UserVO vo, Model model, RedirectAttributes redirectAttributes) {
		int result = service.join(vo);
		
		if(result > 0) {
			
			model.addAttribute("loginUser", vo);
			System.out.println("회원가입 성공");
			return "redirect:/";
			
		} else {
			redirectAttributes.addAttribute("msg", "같은 아이디가 이미 존재합니다.");
			return "redirect:/user/joinForm.sinc";
		}
	}
	
	@RequestMapping(value = "logout.sinc")
	public String logout(SessionStatus status, HttpSession session) {
		
		System.out.println("UserCtrl#logout");
		status.setComplete();
		session.invalidate();
		return "redirect:/index.sinc";
		
	}
	
	@RequestMapping(value="/joinForm.sinc")
	public String joinForm() {
		return "/user/join";
	}
	
	@RequestMapping(value = "/login.sinc", method = RequestMethod.POST)
	public void login(UserVO user, Model model) {

		UserVO result = service.loginService(user);
		if (result != null) {
			model.addAttribute("user", result);
			
		} else {
			System.out.println("result fail");
		}
	}
}
