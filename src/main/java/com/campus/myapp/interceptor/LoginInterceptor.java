package com.campus.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session=request.getSession(); // 로그인 유무
		
		String logStatus=(String)session.getAttribute("logStatus"); //로그인 시, 가져올 정보
		
		if(logStatus!=null && logStatus.equals("Y")) { //로그인이 되면, 계속 진행
			return true;
		}
		else { //로그인 안 되면, 진행 안 됨
			response.sendRedirect("/member/login");
			return false;
		}
		
	}
	
}
