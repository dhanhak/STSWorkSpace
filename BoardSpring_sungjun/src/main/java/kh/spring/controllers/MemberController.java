package kh.spring.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import commons.EncryptionUnits;
import kh.spring.dto.MembersDTO;
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

	@RequestMapping("join")
	public String join(MembersDTO dto) throws Exception {
		dto.setPw(EncryptionUnits.sha512(dto.getPw()));
		int result = dao.join(dto);
		return "redirect:/";
	}

	@ResponseBody // return으로 돌려보내는 값을 데이터 그대로 보내고, viewresolve를 거치지 않음.
	@RequestMapping(value="IdCheck",produces="text/html;charset=utf8") // 
	public String IdCheck(String id) {
		System.out.println("중복검사ID="+id);
		MembersDTO result = dao.IdCheck(id);
		//ajax는 페이지 전환없이 소스코드를 보냄
		return String.valueOf(result);
		//dispatcher가 return을 받음 String이 리턴될경우 viewresolver한테 보냄 > 페이지로 넘어가려함.
	}

	@RequestMapping("login")
	public String login(MembersDTO dto, RedirectAttributes rdat) throws Exception {
		String shapw = EncryptionUnits.sha512(dto.getPw());
		dto.setPw(shapw);
		boolean result = dao.login(dto);
		if (result) {
			session.setAttribute("loginId", dto.getId());
			rdat.addFlashAttribute("status","LS");
		}
		return "redirect:/";
	}

	@RequestMapping("logout")
	public String logout(String id, String pw) {
		session.invalidate();
		return "redirect:/";
	}

	@RequestMapping("out")
	public String out (String loginId) {
		
		int result = dao.memberOut(loginId);
		if(result == 1) {
			session.invalidate();
		}
		return "redirect:/";
		}


//	@RequestMapping("myPage")
//	public String myPage(String loginId,Model model) {
//		
//		MembersDTO dto = dao.memberInfo(loginId);
//		model.addAttribute("dto", dto);
//		
//		return "/member/myPage";
//	}
//	
//	@RequestMapping("updateMyInfo")
//	public String updateMyInfo(MembersDTO dto) {
//		
//		int result = dao.updateMyInfo(dto);
//		
//		return "redirect:/member/myPage?loginId="+dto.getId();
//	}
	
	
}
