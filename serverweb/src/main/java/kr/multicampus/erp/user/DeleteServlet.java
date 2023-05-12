package kr.multicampus.erp.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "empdelete", urlPatterns = { "/emp/delete.do" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String test = request.getParameter("test");
		String id = request.getParameter("id");
		System.out.println(test+":"+id);
		
		EmpDAO dao = new EmpDAOImpl();
		int result = dao.delete(id);
		System.out.println(result + "삭제");
		
		//요청재지정 - 목록을 출력하는 서블릿을 재요청
		response.sendRedirect("/serverweb/emp/list.do"); //서블릿 요청했던 path
		
	
	}

}
