package com.multi.erp.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//BoardDAO의 메소드를 호출
//=>컨트롤러에서 받은 데이터를 가공해서 DAO로 넘기거나 DAO에서 받은 데이터를 가공해서 컨트롤러로 넘기는 작업을 수행한다.
//=>비지니스로직을 구현한다.
//=>서비스단위로 트랜잭션처리를 할 것이다.
@Service
public class BoardServiceImpl implements BoardService {
	BoardDAO dao;
	public BoardServiceImpl() {
		
	}
	
	@Autowired
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public int insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return dao.insert(board);
	}

	@Override
	public List<BoardDTO> boardList() {
		// TODO Auto-generated method stub
		return dao.boardList();
	}

	@Override
	public BoardDTO getBoardInfo(String board_no) { //read
		// TODO Auto-generated method stub
		return dao.read(board_no);
	}

	@Override
	public int update(BoardDTO board) {
		// TODO Auto-generated method stub
		return dao.update(board);
	}

	@Override
	public int delete(String board_no) {
		// TODO Auto-generated method stub
		return dao.delete(board_no);
	}

	@Override
	public List<BoardDTO> search(String data) {
		// TODO Auto-generated method stub
		return dao.search(data);
	}

	@Override
	public List<BoardDTO> search(String tag, String data) {
		// TODO Auto-generated method stub
		return dao.search(tag, data);
	}
	
	//조건을 판단해서 dao의 적절한 메소드를 호출하기 - 비지니스로직
	@Override
	public List<BoardDTO> findByCategory(String category) {
		// TODO Auto-generated method stub
		List<BoardDTO> list = null;
		if(category!=null) {
			if(category.equals("all")) {
				list = dao.boardList();
			}
			else {
				list = dao.findByCategory(category);
			}
		}
		return list;
	}
	
	

}
