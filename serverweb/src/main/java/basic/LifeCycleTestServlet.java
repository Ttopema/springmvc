package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleTestServlet extends HttpServlet{
	public LifeCycleTestServlet() {
		System.out.println("LifeCycleTestServlet 객체생성....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()호출....");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet()호출....");
		// 주소표시줄에 엔터를 누르는 것은 get방식 호출임		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost()호출....");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()호출...." + req.getMethod());
		if(req.getMethod().equals("GET")) {
			doGet(req, resp);
		}
		else {
			doPost(req, resp);
		}
	}
	//서블릿객체가 소멸될때 호출
	//-서블릿객체가 컴파일될때
	//-WAS가 reload될때
	//-context가 reload될때
	
	@Override
	public void destroy() {
		System.out.println("destroy()호출...."); // destroy메소드가 호출됐다는건 servlet이 해제되었다는 뜻이다.
	}
	
}
