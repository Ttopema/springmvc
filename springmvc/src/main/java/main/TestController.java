package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public String test() {
		return "main/test";
	}
	@RequestMapping("/datatest")
	public ModelAndView getData() {
		ModelAndView mav = new ModelAndView();
		//공유데이터 저장하기
		//request.getAttribute("name",공유할객체)
		mav.addObject("msg", "스프링에서 공유되는 데이터");
		//뷰의 이름을 셋팅 - 요청재지정할 뷰의 이름을 셋팅
		mav.setViewName("main/result");
		return mav;
	}
}
