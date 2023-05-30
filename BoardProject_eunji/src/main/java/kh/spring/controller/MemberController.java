package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.commons.EncryptionUtils;
import kh.spring.dto.MemberDTO;
import kh.spring.repositories.MemberDAO;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberDAO dao;

	@Autowired
	private HttpSession session;

	@RequestMapping("signup")
	public String signup() {

		return "member/signup";
	}

	@ResponseBody // forward,redirect 하지말고 값 그대로 보내라
	@RequestMapping(value="idCheck",produces="text/html;charset=utf8")
	public String idCheck(String id) {
		boolean result = dao.isMember(id);
		return String.valueOf(result); // boolean형 -> String형 으로 전환해 리턴
		// dispatcher에게 리턴 -> ViewResolver 소환
		// but viewresolver 거치면 안됨 그냥 그 값만 그대로 보내야 (forward, redirect x)
	}

	@RequestMapping("insertMember")
	public String insertMember(MemberDTO dto) {
		try {
			String shaPw = EncryptionUtils.sha512(dto.getPw());
			dto.setPw(shaPw);
			int result = dao.insertMember(dto);
			return "redirect:/";
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/error";
		}
	}
	
//	@RequestMapping("login")
//	public String login(Model model, String userID, String userPW) {
//		boolean result = dao.loginMember(userID, userPW);
//		if(result) {
//			session.setAttribute("loginId", userID);
//		}
//		model.addAttribute("loginResult", result);
//		return "redirect:/";
//	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, MemberDTO dto) throws Exception {
		
		boolean result = dao.loginMember(dto);
		System.out.println(result);
		if(result) {
			session.setAttribute("loginId", dto.getId());
		}
//		model.addAttribute("loginResult", result);
		return "redirect:/";
	}

	@RequestMapping("logout")
	public String logout() {
		session.removeAttribute("loginId");
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("memberout")
	public String memberout() {
		String loginId = (String) session.getAttribute("loginId");
		int result = dao.deleteMember(loginId);
		session.removeAttribute("loginId");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("mypage")
	public String mypage(Model model) {
		String loginId = (String) session.getAttribute("loginId");
		MemberDTO dto = dao.myInfo(loginId);
		model.addAttribute("my", dto);
		return "/member/myPage"; // jsp로 감
	}
	
	@RequestMapping("updateMyInfo")
	public String updateMyInfo(MemberDTO dto) {
		String loginId = (String) session.getAttribute("loginId");
		dto.setId(loginId);
		int result = dao.updateMyInfo(dto);
		return "redirect:/member/mypage"; // mypage라는 명령으로 감
	}
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/error";
	}
}
