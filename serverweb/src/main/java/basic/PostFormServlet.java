package basic;

import java.io.IOException;
import java.io.PrintWriter;
//패키지가 톰캣10부터 jakarta.servlet.ServletException; 로 바뀜
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		String id = req.getParameter("userId");
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String favorites[] = req.getParameterValues("item");
		pw.print("<h1>customer</h1>");
		pw.print("<hr/>");
		pw.print("<h1>아이디:" + id + "</h1>");
		pw.print("<h1>이름:" + name + "</h1>");
		pw.print("<h1>패스워드:" + pass + "</h1>");
		pw.print("<h1>성별:" + gender + "</h1>");
		pw.print("<h1>직업:" + job + "</h1>");
		pw.print("<h1>좋아하는 항목:");
		for(int i = 0; i< favorites.length; i++) {
			pw.print(favorites[i] + " ");
		}
		pw.print("</h1>");
	}
	
}
