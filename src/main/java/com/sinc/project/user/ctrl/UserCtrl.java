package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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

	@RequestMapping(value = "logout.sinc")
	public String logout(SessionStatus status) {
		System.out.println("UserCtrl#logout");
		
		status.setComplete();
		return "redirect:/index.sinc";
	}
	
	@RequestMapping(value = "/login.sinc", method = RequestMethod.POST)
	public String login(UserVO user, Model model) {

		UserVO result = service.loginService(user);
		if (result != null) {
			model.addAttribute("loginUser", result);
			return "redirect:/";
		} else {
			System.out.println("result fail");
			model.addAttribute("user", user);
			return "user/login";
		}
	}
}
