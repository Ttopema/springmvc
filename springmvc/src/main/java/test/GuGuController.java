package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuGuController {
	@RequestMapping("/gugu.do")
	public ModelAndView printgugu() {
		ModelAndView mav = new ModelAndView("gugu/gugu");
		String str ="";
		for(int i=1;i<=9;i++) {
			str = str + "7 * "+i+"="+(7*i);
			System.out.println(str);
		}
		mav.addObject("gugudan",str);
		return mav;
	}
}
