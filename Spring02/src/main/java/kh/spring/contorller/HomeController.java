package kh.spring.contorller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kh.spring.dto.MoviesDTO;
import kh.spring.repository.MoviesDAO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired	// Annotation DI
	private MoviesDAO dao;
	
	@GetMapping(value = "/")
	public String get() {
		return "home";
	}
	
	@GetMapping(value = "/toInput")
	public String toInput() {
		return "inputForm";
	}
	
	@PostMapping(value = "/inputProc")
	public String inputProc(MoviesDTO dto) {
		try {
			int result = dao.insert(dto);
			return "redirect:/";
		} catch (SQLException e) {
			e.printStackTrace();
			return "redirect:/error";
		}
	}
	
	@GetMapping(value = "/toOutput")
	public String outputProc(Model model) {
		try {
			List<MoviesDTO> list =  dao.selectAll();
			model.addAttribute("list",list);
			return "list";
		} catch (SQLException e) {
			e.printStackTrace();
			return "ridirect:/error";
		}
	}
	
	@PutMapping()
	public String Put() {
		return "hello";	
	}
	
	@DeleteMapping()
	public String Delete() {
		return "del";	
	}
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.POST)
//	public String homes() {
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.PUT)
//	public String homess() {
//		
//		return "home";
//	}
//	
//	@RequestMapping(value = "/", method = RequestMethod.DELETE)
//	public String homesss() {
//		
//		return "home";
//	}
}
