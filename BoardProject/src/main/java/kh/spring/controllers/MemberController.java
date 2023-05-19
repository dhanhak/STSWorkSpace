package kh.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.dto.MemberDTO;
import kh.spring.repositries.MemberDAO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	private MemberDAO dao;

	@RequestMapping("/signup")
	public String sigup() {

		return "member/signup";
	}
	
	@ResponseBody
	@RequestMapping(value="/idCheck", produces="text/html;charset=utf8")
	public String idCheck(String id) {
		System.out.println("전달 된 ID : " + id);
		boolean result = dao.isMember(id);
		return String.valueOf(result);
	}
}
