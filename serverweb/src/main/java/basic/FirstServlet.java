package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("FirstServlet실행");
		//SecondServlet만들기
		//=>7단 출력하는 서블릿
		// 서블릿명: gugu
		// 매핑명: gugudan.html
	}
}
