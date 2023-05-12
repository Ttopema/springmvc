package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;


@WebServlet(name = "emplist_mvc", urlPatterns = {"/mvc/list.do"})
public class EmpListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		//비지니스 메소드 호춢
		EmpDAO dao = new EmpDAOImpl();
		ArrayList<EmpDTO> userlist = dao.select();
		
		//데이터공유
		req.setAttribute("userlist", userlist); //아 ~~ 리스트에 담아버리면 끝나는구나~~
		
		//요청재지정
		RequestDispatcher rd = req.getRequestDispatcher("/user_mvc/list.jsp");
		rd.forward(req, resp);
		}
	}
	
