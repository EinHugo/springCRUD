package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("AuthInterceptor#preHandle");
		HttpSession session = request.getSession();
		String path = "/user/loginForm.sinc";
		
		if(session.getAttribute("loginUser") == null) {
			response.sendRedirect(path);
			return false;
		}
		
		return true;
	}
	
}
