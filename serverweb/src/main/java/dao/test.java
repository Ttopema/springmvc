package dao;

public class test {

	public static void main(String[] args) {
		CustomerDAO dao = new CustomerDAOImpl();
		dao.login("park", "1234");
	}

}
