package kr.multi.erp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	EmpService service;
	//매핑명이 같으면 원래 안된다. 그렇지만 하나는 get방식, 하나는 post방식이기 때문에 다르게 할 수 있다.
//	@RequestMapping("/view/register")
	@RequestMapping(value = "/emp/insert", method = RequestMethod.GET)
	public String showPage() {
//		return "member/register";
		return "emp/insert";
	}
	
	@RequestMapping(value = "/emp/insert", method = RequestMethod.POST)
	public String insert(EmpDTO user,@RequestParam("deptno") String deptcode, String id) {
		System.out.println(deptcode + "," + id);
		System.out.println(user + "=========회원가입==========");
		return "main/index";
	}
	@RequestMapping("/view/login")
	public String login() {
//		return "member/login";
		System.out.println("로그인 ==> tiles에 설정한 뷰");
		return "emp/login";
	}
	@RequestMapping("/login.do")
	public ModelAndView login(String id, String pass, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		EmpDTO user = service.login(id, pass);
		String view = "";
		if(user != null) {
			//로그인 성공
			HttpSession session = request.getSession(); //세션만들기
			//세션에 데이터 공유하기
			session.setAttribute("loginUser", user);
			view = "main/index";
		}
		else {
			//로그인 실패
			view = "redirect:/view/login";
		}
		mav.setViewName(view);
		return mav;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		if(session != null) {
			//사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/view/login";
	}
}
