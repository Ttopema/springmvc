package kr.multicampus.erp.board;

import java.util.ArrayList;

public class BoardDTO {
	private int boardNo;
	private String title;
	private String writer;
	private String content;
	private String writeDate;

	public BoardDTO() {

	}

	// insert용
	public BoardDTO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	// select용
	public BoardDTO(int boardNo, String title, String writer, String content, String writeDate) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [boardNo=" + boardNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

}
