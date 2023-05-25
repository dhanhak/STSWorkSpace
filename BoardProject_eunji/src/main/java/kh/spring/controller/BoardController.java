package kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.BoardDTO;
import kh.spring.repositories.BoardDAO;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
//	@Autowired
//	private BoardDAO dao;
//	
//	@Autowired
//	private HttpSession session;
//	
//	@RequestMapping("boardlist")
//	public String boardlist(Model model) {
//		List<BoardDTO> list = dao.selectAll();
//		model.addAttribute("list", list);
//		return "/board/board";
//	}
//	
//	@RequestMapping("toWriteForm")
//	public String toWriteForm() {
//		return "board/writeForm";
//	}
//	
//	@RequestMapping("writeContent")
//	public String writeContent(BoardDTO dto) {
//		String loginId = (String) session.getAttribute("loginId");
//		dto.setWriter(loginId);
//		int result = dao.insertContent(dto);
//		return "redirect:boardlist";
//	}
//	
//	@RequestMapping("toContentView")
//	public String toContentView(int seq) {
//		return "/board/contentView";
//	}
	
	
	
}
