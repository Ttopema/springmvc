package dao;

import java.util.ArrayList;

public interface CustomerDAO {
	int insert(CustomerVO custsomer) ;
	int insert(String id,String pass,String name,String addr,String memo) ;
	int update(String id,int point , String pass) ;
	int delete(String id);
	ArrayList<CustomerVO> select(String addr) ;
	CustomerVO login(String id,String pass);
	//전체사원목록보기
	ArrayList<CustomerVO> getMemberList() ;
	//사원의 상세 정보 조회하기
	CustomerVO getCustomerInfo(String id);
}
