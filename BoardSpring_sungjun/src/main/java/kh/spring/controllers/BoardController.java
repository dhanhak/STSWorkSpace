package kh.spring.controllers;

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
	
	@Autowired
	private BoardDAO dao;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("toWrite")
	public String toWrite() {
		return "board/write";
	}
	
	
	@RequestMapping("boardlist")
	public String boardlist(Model model) {
		
		List<BoardDTO> list = dao.boardList();
		model.addAttribute("list", list);
		
		
//		session.setAttribute("currentPage", currentPage);
		
		return "/board/boardlist";
	}
	
	@RequestMapping("write")
	public String write(BoardDTO dto) {
		
		int result = dao.write(dto);
		return "redirect:/board/boardlist";
	}
	
	
}
