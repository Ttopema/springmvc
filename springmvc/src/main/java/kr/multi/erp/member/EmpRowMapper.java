package kr.multi.erp.member;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


//query메소드 내부에서 디비에서 조회한 레코드를 어떤 객체에 매핑시켜야 하는지 정보를 담고 있는 객체
//while(){},if(){}안에서 처리해야 할 내용을 정의
public class EmpRowMapper implements RowMapper<EmpDTO>{

	@Override
	public EmpDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("maprow=>"+rowNum);
		//레코드 갯수만큼 mapRow를 호출
		//레코드 하나를 dto에 매핑한 후 리턴
		EmpDTO user = new EmpDTO(rs.getString(1),rs.getString(2), rs.getString(3),rs.getString(4)
				, rs.getString(5), rs.getInt(6),rs.getString(7));
		return user;
	}

}
