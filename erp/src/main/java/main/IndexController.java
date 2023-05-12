package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/index.do")
	public String showIndexPage() {
		System.out.println("index");
		return "index";
	}

	
	@RequestMapping("/menu/board.do")
	public String showBoardPage() {
		System.out.println("board");
		return "menu/board";
	}
}
