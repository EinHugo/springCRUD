package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		// 로그인이 정상적으로 실행되었으면 세션에 유저 정보를 심어준다.
		super.postHandle(request, response, handler, modelAndView);
		
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap();
		
		Object obj = model.get("user");
		
		if(obj != null) {
			
			System.out.println("Interceptor Success");
			session.setAttribute("loginUser", obj);
			// 세션이 중간에 만료될 때를 대비해서 dest 가 빈 값인지 체크한다.
			String dest = checkDestination(request);
			/*
			 * if(dest == null) { dest = request.getHeader("referer"); }
			 */
			String path = (dest == null) ?  "/" : dest;
			
			response.sendRedirect(path);
			
		} else {
			
			response.sendRedirect("/user/loginForm.sinc");
			
		}
		
	}
	
	public String checkDestination(HttpServletRequest request) {
		
		
		HttpSession session = request.getSession();
		String savePath = (String)session.getAttribute("savePath");
		session.removeAttribute("savePath");
		System.out.println("LoginInterceptor#checkDestination >> save path " + savePath );
		
		return savePath;
	}
	
	
}
