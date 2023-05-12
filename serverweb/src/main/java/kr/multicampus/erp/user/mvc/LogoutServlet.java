package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "logout", urlPatterns = { "/logout.do" })
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//request.getSession(boolean)
		
			/*
			 * -> 기존에 작업하던 세션이 있는지 확인하고 세션객체를 반환
			 * getSession(true) - getSession()과 동일
			 * getSession(false) - 기존에 사용하던 세션이 있으면 세션객체를 반환하고 없으면 null을 반환
			 * 
			 * */
		
			HttpSession session = request.getSession(false);
			if(session != null) {
				//사용하던 세션을 메모리에서 제거하기
				session.invalidate();
				
			}
			response.sendRedirect("/serverweb/index.jsp");
		
	}
  
}
