package kh.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private HttpSession session;
	
	@RequestMapping("Login")
	public String login() {
		session.setAttribute("loginID", "jung");
		return "redirect:/";
	}
	
	@RequestMapping("Logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
}
