package com.multi.erp.member;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.multi.erp.common.FileUploadLogicService;

import kr.multi.erp.dept.DeptDTO;
import kr.multi.erp.dept.DeptService;

//@SessionAttributes("user")user라는 것은 세션에 저장하는 어트리뷰트명
//컨트롤러에서 user라는 이름으로 Model객체 저장된 어트리뷰트가 있으면 이를 세션에도 저장해준다.

@Controller
@RequestMapping("/emp") // emp가 중복되기 때문에 위에 선언
@SessionAttributes("user") // 데이터 공유명을 적어주면 됨.
public class MemberController {

	MemberService service;
	DeptService deptservice;
	FileUploadLogicService fileuploadservice;

	public MemberController() {

	}

	@Autowired
	public MemberController(MemberService service, DeptService deptservice, FileUploadLogicService fileuploadservice) {
		super();
		this.service = service;
		this.deptservice = deptservice;
		this.fileuploadservice = fileuploadservice;
	}

//	<view-controller path="/emp/insert" view-name="member/insertPage" />
	@RequestMapping("/insert")
	public String insertPage(Model model) {
		// DeptService등록하고 부서명을 register.jsp에서 사용할 수 있는도록 attribute로 추가하기
		List<DeptDTO> deptnamelist = deptservice.select();
		//데이터 공유
		model.addAttribute("deptnamelist", deptnamelist);
		return "member/insertPage";
	}
	
	@PostMapping("/insert.do")
	public String insert(MemberDTO user, HttpSession session) throws IllegalStateException, IOException {
		//파일업로드
		MultipartFile file = user.getUserImage();
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/static/images");
		System.out.println("====================");
		System.out.println(user);
		System.out.println("====================");
		//파일업로드 서비스의 메소드를 호출해서 직접 업로드
		String storeFilename = fileuploadservice.uploadFile(file, path);
		user.setProfile_photo(storeFilename);
		if(user.getMarry() == null) { //체크박스 선택하지 않았다는 의미.
			user.setMarry("0");
		}
		user.setGender(user.getSsn().substring(6,7));
		System.out.println("=========***===========");
		System.out.println(user);
		System.out.println("=========***===========");
		service.insert(user);
		return "redirect:/index.do";
	}

	@GetMapping("/login.do")
	public String showLoginPage() {
		System.out.println("login");
		return "login";
	}

	@PostMapping("/login.do")
	public ModelAndView login(MemberDTO loginUserInfo, HttpServletRequest request) {
		System.out.println("==========loginUserInfo======" + loginUserInfo);
		ModelAndView mav = new ModelAndView();
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if (user != null) {
			// 로그인 성공
			HttpSession session = request.getSession(); // 세션만들기
			// 세션에 데이터 공유하기
			session.setAttribute("user", user);
			// 서비스에서 가공한 뷰의 이름 - 로그인한 사용자가 어떤 job이냐에 따라 작업할 수 있는 메뉴가 달라질 수 있도록
//			view = "redirect:/index.do";
			view = user.getMenupath();
		} else {
			// 로그인 실패
			view = "redirect:/emp/login.do";
		}
		mav.setViewName(view);
		return mav;
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		if (session != null) {
			// 사용하던 세션을 메모리에서 제거하기
			session.invalidate();
		}
		return "redirect:/emp/login.do";
	}

	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		// 나중에는 제일 복잡한 컨트롤러가 될 수 있다.
		// 결제에 대한 진행상황
		// 스케줄표 - 업무스케줄, 미팅일정, 휴가일정
		// 진행중인 메인업무에 대한 내용
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		return user.getMenupath();

	}

	// 스프링에서 제공되는 기능을 이용한 로그인
	@RequestMapping("/spring/login") // login.jsp에서 이렇게 사용함 <form name="login_frm" action="/erp/emp/spring/login"
										// method="post">
	public String springlogin(MemberDTO loginUserInfo, Model model) {
		System.out.println("스프링에서 제공하는 @SessionAttributes를 이용해서 세션처리하기");
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if (user != null) {
			model.addAttribute("user", user);
			view = user.getMenupath();

		} else {
			view = "redirect:/index.do";
		}
		return view;
	}

	// 스프링에서 제공되는 기능을 이용한 로그아웃
	@RequestMapping("/spring/logout") // 즉 jsp에서 action속성에서의 값이랑 같다. top.jsp에서 <a href="/erp/emp/spring/logout"> 이렇게
										// 사용함
	public String springlogout(SessionStatus status) {
		System.out.println("SessionStatus를 이용한 로그아웃 처리하기");
		status.setComplete(); // 세션에 있는 객체를 제거
		return "redirect:/index.do"; // view명으로 인식하지 않음.
	}

	@RequestMapping("/dept/tree.do")
	public String showTree(Model model) {
		List<DeptDTO> deptlist = deptservice.select();
		//데이터 공유
		model.addAttribute("deptlist", deptlist);
		return "dept/tree"; // forward
	}
	
	@RequestMapping(value =  "/idcheck.do", produces = "application/text;charset=utf-8", method = RequestMethod.GET)
	public @ResponseBody String idCheck(String id) {
		String msg = "";
		boolean check = service.idCheck(id);
		if(check) {
			//기존 DB에 저장되어 있는 아이디
			msg = "사용불가능한 아이디";
		}
		else {
			msg = "사용가능한 아이디";
		}
		return msg;
	}
}
