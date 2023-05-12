package com.multi.erp.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	//Mybatis의 핵심클래스를 이용해서 sql문을 실행한다.
	SqlSession sqlSessionTemplate;
	public BoardDAOImpl() {
		
	}
	
	@Autowired //생성자에게 Autowired 걸어주는 방식을 많이쓴다.
	public BoardDAOImpl(SqlSession sqlSessionTemplate) {
		super();
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public int insert(BoardDTO board) {
		//SqlSession의 insert메소드는 insert SQL명령문을 실행하기 위해 제공되는 메소드이다.
		//insert(statement, 파라미터객체)
		//statement가 mapper에 정의한 sql구문을 구분하는 id명 - 네임스페이스명.id명
		//파라미터객체 - 사용자가 입력한 값이 저장되어 있는 DTO
		return sqlSessionTemplate.insert("com.multi.erp.board.insert", board);
	}

	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		//리턴 첫번째 매개변수 값에서 맨 뒤에는 mapper에 정의해놓은 id값을 준다.
		return sqlSessionTemplate.selectList("com.multi.erp.board.selectall");
	}

	@Override
	public BoardDTO read(String board_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.multi.erp.board.read",board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("com.multi.erp.board.update", board);
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("com.multi.erp.board.delete", board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		// TODO Auto-generated method stub
		//네임스페이스.id임
		return sqlSessionTemplate.selectList("com.multi.erp.board.search", data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = null;
		System.out.println("========="+tag);
		Map<String, String> map = new HashMap<String, String>();
		map.put("tag", tag);
		map.put("data", data);
		list = sqlSessionTemplate.selectList("com.multi.erp.board.dynamicsearch", map);
		return list;
	}

	@Override
	public List<BoardDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = sqlSessionTemplate.selectList("com.multi.erp.board.categorySearch", category);
		System.out.println("====dao=====" + list.size());
		return list;
	}

}
