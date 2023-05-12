package kr.multicampus.erp.user.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "read", urlPatterns = {"/mvc/read.do"})
public class EmpReadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿에서 응답데이터에 대한 한글처리는 하지 않아도 된다.
		//응답을 jsp로 분리했으므로 jsp에서 한글처리를 하면 된다.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1. 요청정보 추출
		String id = request.getParameter("id");
		System.out.println(id + "서블릿=======");
		//2. 비지니스 모델 호출
		EmpDAO dao = new EmpDAOImpl();
		//사원정보 하나에 대한 레코드를 리턴(일치하는 정보가 없으면 null리턴)
		EmpDTO emp =  dao.read(id);
		
		//3.데이터공유 - 뷰에서 출력할 데이터를 공유
		request.setAttribute("emp", emp);
		//4.요청재지정 - emp_read.jsp
		RequestDispatcher rd = request.getRequestDispatcher("/user_mvc/emp_read.jsp");
		rd.forward(request, response);
	
	}

}
