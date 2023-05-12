package kr.multicampus.erp.user.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.multicampus.erp.user.EmpDAO;
import kr.multicampus.erp.user.EmpDAOImpl;
import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "emplogin", urlPatterns = { "/mvc/login.do" })
public class EmpLoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		// 1.요청정보 추출
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		// 2.비지니스 모델 호출
		EmpDAO dao = new EmpDAOImpl();
		EmpDTO loginuser = dao.login(id, pass);
		// 3.데이터공유 - 뷰에서 출력할 데이터를 공유
		// 3-1) 세션객체를 만들기
		/*
		        1) getSession()
		           -request에서 세션id를 꺼내고 서버에 할당된 세션의 세션id와 일치하는 게 없거나 세션id가 존재하지 않으면
		           -일치하는 세션id가 있으면 그 세션id로 정의된 세션을 HttpSession객체로 만들어서 리턴한다.
		           ex) 로그인 버튼을 눌러서 로그인에 성공하면 세션을 무조건 생성
		           
		           
		        2) getSession(true) - 1번과 동일
		        3) getSession(false)
		           -일치하는 세션 id가 존재하면 세션객체를 만들어서 리턴
		           -일치하는 세션 id가 존재하지 않으면 null을 리턴
		           
		           ex) 세션유무를 체크하는 경우 사용(로그아웃)
		 */		  
		
		
		//request.setAttribute("loginuser", loginuser);
		
		

		// 4.요청재지정
		String path = "";
		if(loginuser!=null) {
			HttpSession session = request.getSession(); // 세션만들기
			//세션에 데이터 공유하기
			session.setAttribute("loginuser", loginuser);
			path = "/index.jsp";
		}
		else {
			path = "/user_mvc/login.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

}
