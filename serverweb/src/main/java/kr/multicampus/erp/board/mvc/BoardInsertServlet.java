package kr.multicampus.erp.board.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.multicampus.erp.board.BoardDAO;
import kr.multicampus.erp.board.BoardDAOImpl;
import kr.multicampus.erp.board.BoardDTO;

@WebServlet(name = "boardInsert_mvc", urlPatterns = { "/board/write.do" })
public class BoardInsertServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		// 1.요청정보 추출하기 - 입력하는 값
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		// 2. 비지니스 메소드 호출
		BoardDTO board = new BoardDTO(writer, title, content);
		BoardDAO dao = new BoardDAOImpl();
		int result = dao.insert(board);
		
		//3.데이터 공유
		req.setAttribute("insertboard", content);
		
		String view ="";
		
		if(result > 0) { //정상처리
			view = "/serverweb/user_mvc/insertOK.jsp";
		}
		else { //삽입실패
			view = "/serverweb/user_mvc/insertFail.jsp";
		}
		//응답뷰가 클라이언트에게 response되도록 재요청
		resp.sendRedirect(view);
	}

}
