package kh.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginValidator implements HandlerInterceptor {
	
	@Autowired
	private HttpSession session;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String loginID = (String) session.getAttribute("loginID");
		if(loginID != null) return true;	// 세션에 id값이 존재한다면 controller로 진행
		
		response.sendRedirect("/error");	// 그렇지 않다면 error로 redirect
		return false;
		
	}
	
}
