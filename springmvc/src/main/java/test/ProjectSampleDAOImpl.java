package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectSampleDAOImpl implements ProjectSampleDAO {
	@Autowired
	JdbcTemplate template;
	@Override
	public void test() {
		System.out.println("나 dao");
		//JdbcTemplate이 제공하는 조회결과가 자바의 객체 한 개와 매핑되는 경우 사용하는 메소드
		int result = template.queryForObject("select count(id) from myemp", Integer.class);
		System.out.println("레코드갯수=>"+result);
	}

}
