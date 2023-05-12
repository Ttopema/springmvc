package kr.multi.erp.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.multi.erp.dept.DeptRowMapper;
@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	JdbcTemplate template;
	@Override
	public int insert(EmpDTO user) {
		// TODO Auto-generated method stub
//		String sql = "insert into myemp values(?,?,?,null,?,?,?,?,?,?,?)";
//		return template.update(sql, user.getDeptno(), user.getName(), user.getId(), user.getPass(), user.getAddr(), user.getPoint(), user.getGrade());
		return 0;
	}

	@Override
	public List<EmpDTO> select() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EmpDTO read(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmpDTO login(String id, String pass) {
		// TODO Auto-generated method stub
		return template.queryForObject("select * from myemp where id = ? and pass = ?", new Object[] {id, pass}, new EmpRowMapper());
	}

	@Override
	public int update(EmpDTO user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
