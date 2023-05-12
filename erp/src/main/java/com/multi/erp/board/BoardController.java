package com.multi.erp.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.member.MemberDTO;

@Controller
public class BoardController {
	BoardService service;

	public BoardController() {

	}

	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}

	@GetMapping("/board/write") // boardlist.jsp에서 a태그 href속성 값이랑 똑같음 즉, 매핑을 버튼이나 링크에 해주는 것이 아닐까??
	public String writePage() {

		return "board/writepage"; // board-tiles의 name속성이랑 똑같음.
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board) {
		System.out.println(board);
		service.insert(board); // 이렇게 함으로써 db에 값이 들어간다..??
		return "redirect:/board/list.do?category=all"; // 컨트롤러 요청재지
	}

	@RequestMapping("/board/list.do")
	public ModelAndView list(String category) {
		System.out.println("=====" + category);
		// ModelAndView로 데이터 공유
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDTO> boardlist = service.findByCategory(category);
//		List<BoardDTO> boardlist = service.boardList();
		mav.addObject("category", category);
		mav.addObject("boardlist", boardlist);
		System.out.println(boardlist);
		return mav; // view
	}

	/*
	 * 즉, 매핑명은 버튼이나 하이퍼링크 경로 속성에, return은 view일 경우 tiles의 name속성이랑 똑같이.
	 */
	@RequestMapping("/board/search.do")
	public ModelAndView search(String tag, String search) {
		// ModelAndView로 데이터 공유
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDTO> boardlist = service.search(tag, search);
		mav.addObject("boardlist", boardlist);
		System.out.println(boardlist);
		return mav;
	}
	
	

	// 파라미터 이름 오타없이 적기. 매핑돼서 넘어오기 때문에.
	// 매개변수를 허용된 범위 안에서 적을 수 있다는 게 무슨 뜻일까??
	@RequestMapping("/board/read.do")
	public String read(String board_no, String state, Model model) {
		BoardDTO board = service.getBoardInfo(board_no);
		String view = "";
		if (state.equals("READ")) {
			view = "board/read";
		} else {
			view = "board/update";
		}
		model.addAttribute("board", board);

		return view;
	}

	// 삭제는 인증절차를 2번한다.
	// 1.로그인이 되어있는지
	// 2.내가쓴 글인지
	// redirect: 는 클라이언트부터 다시 시작? 즉, 새로운작업을 시작하기 위해 ? view이름을 주는 경우는
	// 데이터를 공유하는 경우는 view이름만 주고
	// 전혀 새롭게 요청이 들어가는 경우 redirect: 가 들어간다,
	@RequestMapping("/board/delete.do")
	public String delete(String board_no, HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String view = "";
		if (user == null) { // 로그인 하지 않은상태
			view = "redirect:/emp/login.do"; // view
		} else { // 로그인이 된 상태
			int result = service.delete(board_no); // 로그인이 된 상태에서만 삭제
			view = "redirect:/emp/list.do?category=all"; // action
		}
		return view;
	}

	@PostMapping("/board/update.do")
	public String update(BoardDTO board) {
		System.out.println(board);
		service.update(board);
		return "redirect:/board/list.do?category=all";// 컨트롤러 요청재지정
	}
}
