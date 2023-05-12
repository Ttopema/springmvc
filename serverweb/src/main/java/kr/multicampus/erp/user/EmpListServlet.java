package kr.multicampus.erp.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "emplist", urlPatterns = {"/emp/list.do"})
public class EmpListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		//비지니스 메소드 호춢
		EmpDAO dao = new EmpDAOImpl();
		ArrayList<EmpDTO> userlist = dao.select();
		System.out.println("서블릿========");
		System.out.println(userlist);
		pw.print(userlist);
		//응답화면 만들기
		int size = userlist.size();
		pw.print("<h1>회원목록보기</h1>");
		pw.print("<table width='600' border='1'>");
		pw.print("<tr>");
		pw.print("<th>부서코드</th><th>성명</th><th>아이디</th><th>비밀번호</th>");
		pw.print("<th>주소</th><th>포인트</th><th>등급</th><th>삭제</th>");
		pw.print("<tr>");
		for(int i =0; i<size; i++) {
			//Araaylist에 저장된 레코드인 EmpDTO를 꺼내기
			//화면에서 분리시켜야함
			EmpDTO emp = userlist.get(i);
			pw.print("<tr>");
			pw.print("<td>" + emp.getDeptno() + "</td>");
			pw.print("<td>" + emp.getName() + "</td>");
			pw.print("<td>" + emp.getId() + "</td>");
			pw.print("<td>" + emp.getPass() + "</td>");
			pw.print("<td>" + emp.getAddr() + "</td>");
			pw.print("<td>" + emp.getPoint() + "</td>");
			pw.print("<td>" + emp.getGrade() + "</td>");
			pw.print("<td><a href='/serverweb/emp/delete.do?test=info&id="+emp.getId()+"'>삭제</a></td>"); //?
			pw.print("</tr>");
			
		}
	}
	
}
