package kr.multicampus.erp.user;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.CustomerVO;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CustomerDAO dao = new CustomerDAOImpl();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		String userId = req.getParameter("id");
		String password = req.getParameter("pass");
		CustomerVO loginuser = dao.login(userId, password);
		
		if (loginuser != null) {
	        out.println("<script>");
	        out.println("alert('로그인 성공');");
	        out.println("</script>");
	    } else {
	        out.println("<script>");
	        out.println("alert('로그인 실패');");
	        out.println("</script>");
	    }
	}

}
