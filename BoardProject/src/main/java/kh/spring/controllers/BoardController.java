package kh.spring.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@RequestMapping("/")
	public String Get() {
		
		return "";
	}
}
