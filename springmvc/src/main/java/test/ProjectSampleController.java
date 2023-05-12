package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectSampleController {
	//서비스단의 메소드 호출
	@Autowired
	ProjectSampleService service;
	@RequestMapping("/pro.do")
	public String sampletest() {
		System.out.println("나는 컨트롤러");
		service.servicetest();
		return "main/index";
	}
}
