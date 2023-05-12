package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.user.EmpDTO;

@WebServlet(name = "forward", urlPatterns = { "/forward" })
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		
		System.out.println("sendRedirect연습 - Redirect서블릿 실행");
		pw.println("<h1>요청재지정연습 - sendRedirect</h1>");
		
		//1.데이터공유 - db에서 가져온 결과 비지니스로직 수행결과
		EmpDTO dto = new EmpDTO("park", "1234", "서울 광진구", 1000, "VIP");
		//공유하고 싶은 scope를 나타내는 객체에 이름을 정의하고 저장
		request.setAttribute("mydata", dto);
		
		//2. 요청재지정
		RequestDispatcher rd = request.getRequestDispatcher("/basicview/result.jsp");
		rd.forward(request, response);
		
		
	
	}

}
