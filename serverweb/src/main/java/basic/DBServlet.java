package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDAOImpl;
import dao.CustomerDAO;

public class DBServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		CustomerDAO dao = new CustomerDAOImpl();
		dao.login("park", "1234");
	}
}
