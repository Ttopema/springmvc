package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fw.DBUtil;

//MySQL액세스하기 위한 기능 - customer테이블에 대한  CLRUD를 정의
public class CustomerDAOImpl implements CustomerDAO{
	@Override
	public int insert(CustomerVO customer) {
		System.out.println(customer);//검증
		String sql = "insert into customer values(?,?,?,?,sysdate(),1000,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("커넥션성공!!:"+con);
			ptmt =  con.prepareStatement(sql);
			System.out.println("PreparedStatement객체:"+ptmt);
			//외부에 입력  받아 처리하는 부분을 VO객체에서 꺼내서 전달한다.
			ptmt.setString(1, customer.getId());
			ptmt.setString(2, customer.getPass());
			ptmt.setString(3, customer.getName());
			ptmt.setString(4, customer.getAddr());
			ptmt.setString(5, customer.getMemo());
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	@Override
	public int insert(String id, String pass, String name, String addr, String memo) {
		String sql = "insert into customer values(?,?,?,?,sysdate(),1000,?)";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			con = DBUtil.getConnect();
			System.out.println("커넥션성공!!:"+con);
			ptmt =  con.prepareStatement(sql);
			System.out.println("PreparedStatement객체:"+ptmt);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			ptmt.setString(3, name);
			ptmt.setString(4, addr);
			ptmt.setString(5, memo);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삽입성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int update(String id, int point, String pass) {
		String sql = "update customer ";
		sql = sql+"set point=?, pass=? ";
		sql = sql+"where id=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			System.out.println("드라이버로딩성공!!");
			con = DBUtil.getConnect();
			System.out.println("커넥션성공!!:"+con);
			ptmt =  con.prepareStatement(sql);
			ptmt.setInt(1, point);
			ptmt.setString(2, pass);
			ptmt.setString(3, id);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 수정성공!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("수정오류");
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public int delete(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("delete from customer ");
		sql.append("where id= ?");
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try {
			System.out.println("드라이버로딩성공!!");
			con = DBUtil.getConnect();
			System.out.println("커넥션성공!!:"+con);
			ptmt =  con.prepareStatement(sql.toString());
			ptmt.setString(1, id);
			System.out.println("Statement객체:"+ptmt);
			result = ptmt.executeUpdate();
			System.out.println(result+"개 행 삭제성공!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public ArrayList<CustomerVO> select(String addr) {
		String sql = "select * from customer where addr like ?" ;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		//변환된 레코드를 담을 자료구조
		//레코드를 하나를 VO로 변환하고 ArrayList 저장하기
		ArrayList<CustomerVO> customerlist = new ArrayList<CustomerVO>();
		//레코드 하나를 담을 객체를 정의
		CustomerVO customer = null;
		try {
			System.out.println("드라이버로딩성공!!");
			con = DBUtil.getConnect();
			System.out.println("커넥션성공!!:"+con);
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, "%"+addr +'%');
			
			//select문을 실행
			rs =  ptmt.executeQuery();
			System.out.println("ResultSet=>"+rs);
			//테스트를 위해서 sysout해서 결과를 출력해보았지만 sysout은 의미가 없고
			//조회한 레코드를 VO로 변환해서 ArrayList에 담는 작업을 처리
			while(rs.next()) {//레코드 탐색 : 다음레코드로 커서를 내려서 레코드가 있으면 true리턴, 없으면 false리턴
				//1. 조회한 레코드로 VO객체를 만들기
				customer = new CustomerVO(rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getDate(5), rs.getInt(6),rs.getString(7));
				//2. 레코드가 변환된 VO객체를 ArrayList에 저장하기
				customerlist.add(customer);
			}
			System.out.println("조회된 레코드 갯수:"+customerlist.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return customerlist;
	}

	@Override
	public CustomerVO login(String id, String pass) {
		String sql = "select * from customer where id=? and pass=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		CustomerVO customer = null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			rs =  ptmt.executeQuery();
			if(rs.next()) {
				//System.out.println("로그인성공");
				//로그인을 성공하면 조회된 로그인 사용자의 레코드를 VO로 만들어서 리턴
				customer = new CustomerVO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6),rs.getString(7));
			}
//			else {
//				System.out.println("로그인실패");
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return customer;
	}
	@Override
	public ArrayList<CustomerVO> getMemberList() {
		ArrayList<CustomerVO> customerlist = new ArrayList<CustomerVO>();
		CustomerVO customer = null;
		String sql = "select * from customer" ;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while(rs.next()) {
				customer = new CustomerVO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6),rs.getString(7));
				customerlist.add(customer);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, ptmt, con);
		}
		return customerlist;
	}
	@Override
	public CustomerVO getCustomerInfo(String id) {
		String sql = "select * from customer where id=?";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		CustomerVO customer = null;
		try {
			con = DBUtil.getConnect();
			ptmt =  con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs =  ptmt.executeQuery();
			if(rs.next()) {
				customer = new CustomerVO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getDate(5), rs.getInt(6),rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return customer;
	}

	

}










