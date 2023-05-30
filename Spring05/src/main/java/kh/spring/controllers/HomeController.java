package kh.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
//		session.setAttribute("ip", request.getRemoteAddr());
		return "index";
	}
	
	@RequestMapping("/toChat")
	public String toChat(String ID) {
		session.setAttribute("loginID", ID);
		return "home";
	}
	
}
