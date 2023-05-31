package kh.spring.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@RequestMapping("/guest")
	public String guest() {
		
		return "guest";
	}

	@RequestMapping("/member")
	public String member() {
		return "member";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
}
