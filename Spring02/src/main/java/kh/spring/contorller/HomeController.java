package kh.spring.contorller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.MoviesDTO;
import kh.spring.repositories.MoviesDAO;

@Controller
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
	public String inputProc(MoviesDTO dto) throws SQLException {
			int result = dao.insert(dto);
			return "redirect:/";
	}
	
	@GetMapping(value = "/toOutput")
	public String outputProc(Model model) throws SQLException {
			List<MoviesDTO> list =  dao.selectAll();
			model.addAttribute("list",list);
			return "list";
	}
	
	@PostMapping(value = "/delete")
	public String Delete(int deleteID) throws SQLException {
			int result = dao.delete(deleteID);
			return "redirect:/toOutput";
	}
	
	@PostMapping(value = "/modify")
	public String Update(MoviesDTO dto) throws SQLException {
			int result = dao.update(dto);
			return "redirect:/toOutput";
	}
	
	@GetMapping("/selectById")
	public String selectById(int id) {
		MoviesDTO dto = dao.selectById(id);
		System.out.println(dto.getId() +" : "+ dto.getTitle() +" : "+ dto.getGenre());
		return "redirect:/";
	}
	
	@GetMapping("/selectCount")
	public String selectCount() {
		int result = dao.selectCount();
		System.out.println(result);
		return "redirect:/";
	}
	
	@ExceptionHandler(SQLException.class)
	public String exceptionHandler(Exception e) {
		e.printStackTrace();
		return "redirect:/error";
	}
//	
//	@ExceptionHandler(Exception.class)
//	public String exceptionHandler() {
//		
//	}
	
//	@PutMapping()
//	public String Put() {
//		return "hello";	
//	}
//	
//	@DeleteMapping(value = "/{id}")
//	public void Delet(@PathVariable int id) {
//		try {
//			int result = dao.delete(id);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
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
