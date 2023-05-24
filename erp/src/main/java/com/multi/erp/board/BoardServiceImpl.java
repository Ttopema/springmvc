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
	
	//게시글 등록버튼을 눌렀을 때 실행될 메소드
	//-두 개의 작업을 처리해야함.
	//-tbBoard의 글에 대한 내용을 저장, board_file테이블에 첨부파일의 내용들을 저장
	//-dao에 정의된 메소드 2개를 호출할 것이다.
	//-서비스메소드에서 호출되는 두 개의 메소드가 모두 정상처리되어야 db에 반영될 수 있도록 처리해야 한다.
	//-만약 두 작업중에 하나의 작업만 처리가 되고 오류가 발생되면 모든 작업이 취소되도록 처리해야 한다.
	//-논리적인 작업그룹(작업 한 개)
	// ---------------------------> 트랜잭션 처리
	@Override
	public int insert(BoardDTO board, List<BoardFileDTO> boardfiledtolist) {
		// TODO Auto-generated method stub
		dao.insert(board);
		
		dao.insertFile(boardfiledtolist);
		return 0;
	}

	@Override
	public List<BoardFileDTO> getFileList(String boardno) {
		// TODO Auto-generated method stub
		return dao.getFileList(boardno);
	}

	@Override
	public BoardFileDTO getFile(BoardFileDTO inputdata) {
		// TODO Auto-generated method stub
		return dao.getFile(inputdata);
	}
	
	

}
