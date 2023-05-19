package kh.spring.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MessageDTO;
import kh.spring.repository.MessageDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MessageDAO dao;
	
	@GetMapping(value = "/")
	public String Get() {
		return "home";
	}
	
	@GetMapping(value = "/input")
	public String input() {
		return "input";
	}
	
	@PostMapping(value = "/inputProc")
	public String inputProc(MessageDTO dto) throws SQLException {
		dao.insert(dto);
		return "redirect:/";
	}
	
	@GetMapping(value = "/list")
	public String read(Model model) throws SQLException {
		List<MessageDTO> list = dao.read();
		model.addAttribute("list",list);
		return "list";
	}
	
	@PostMapping(value = "/delete")
	public String delete(int seq) throws SQLException {
		dao.delete(seq);
		return "redirect:/list";
	}
	
	@PostMapping(value = "/modify")
	public String update(MessageDTO dto) throws SQLException {
		dao.update(dto);
		return "redirect:/list";
	}
	
	
	@ExceptionHandler(SQLException.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/error";
	}
	
}
