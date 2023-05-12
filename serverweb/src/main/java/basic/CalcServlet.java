package basic;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		// 1.클라이언트 요청정보 추출
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		String method = req.getParameter("method");
		// 2.비지니스 로직
		// 2.비지니스 메소드 호출
		Calc obj = new Calc();
		int result = obj.calc(num1, method, num2);
		//3. 클라이언트에 응답할 메시지를 생성
		pw.print("<h1>계산결과(" + method + "연산)</h1>");
		pw.print("<hr/>");
		pw.print("<h1>계산결과(" + num1+"과 num2의" + num2 +"를 연산한 결과" + result + "입니다.</h3>");
//		if(req.getParameter("method").equals("+")) {
//			int result = Integer.parseInt(num1) + Integer.parseInt(num2);
//			pw.print("num1의" + num1 + "과 num2의" + num2 + "를 더한 결과는" + result + "입니다.");
//		}
//		else if(req.getParameter("method").equals("-")) {
//			int result = Integer.parseInt(num1) - Integer.parseInt(num2);
//			pw.print("num1의" + num1 + "과 num2의" + num2 + "를 뺀 결과는" + result + "입니다.");
//		}
//		
//		else if(req.getParameter("method").equals("*")) {
//			int result = Integer.parseInt(num1) * Integer.parseInt(num2);
//			pw.print("num1의" + num1 + "과 num2의" + num2 + "를 곱한 결과는" + result + "입니다.");
//		}
//		
//		else if(req.getParameter("method").equals("/")) {
//			int result = Integer.parseInt(num1) / Integer.parseInt(num2);
//			pw.print("num1의" + num1 + "과 num2의" + num2 + "를 나눈 결과는" + result + "입니다.");
//		}
	}

}
