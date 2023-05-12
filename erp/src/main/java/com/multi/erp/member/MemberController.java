package com.multi.erp.member;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.board.BoardService;


@Controller
public class MemberController {
	
	MemberService service;

	public MemberController() {

	}

	@Autowired
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/emp/login.do")
	public String showLoginPage() {
		System.out.println("login");
		return "login";
	}
	
	@PostMapping("/emp/login.do")
	public ModelAndView login(MemberDTO loginUserInfo, HttpServletRequest request) {
		System.out.println("==========loginUserInfo======" + loginUserInfo);
		ModelAndView mav = new ModelAndView();
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if(user != null) {
			//로그인 성공
			HttpSession session = request.getSession(); //세션만들기
			//세션에 데이터 공유하기
			session.setAttribute("user", user);
			view = "redirect:/index.do";
		}
		else {
			//로그인 실패
			view = "redirect:/emp/login.do";
		}
		mav.setViewName(view);
		return mav;
	}
	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession session) {
		if(session != null) {
			//사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/emp/login.do";
	}
	
}
