package kr.multicampus.erp.board;

import java.util.ArrayList;

public interface BoardDAO {
	//게시글 등록을 위한 메소드
	public int insert(BoardDTO board);
	//전체 게시글 목록을 조회하는 메소드
	public ArrayList<BoardDTO> select();
	//게시글을 조회하는 메소드
	public BoardDTO read(String boardNo);
	
	
		
}
