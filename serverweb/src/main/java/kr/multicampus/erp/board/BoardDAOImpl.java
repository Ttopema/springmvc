package kr.multicampus.erp.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CustomerVO;
import fw.DBUtil;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public int insert(BoardDTO board) {
		String sql = "insert into board values(null,?,?,?,sysdate())";
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			ptmt.setInt(1, board.getBoardNo());
			ptmt.setString(2, board.getTitle());
			ptmt.setString(3, board.getWriter());
			ptmt.setString(4, board.getContent());
			ptmt.setString(5, board.getWriteDate());
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;

	}

	@Override
	public ArrayList<BoardDTO> select() {
		ArrayList<BoardDTO> boardlist = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		String sql = "select * from board";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql);
			rs = ptmt.executeQuery();
			while (rs.next()) {
//				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
				boardlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}

		return boardlist;
	}

	@Override
	public BoardDTO read(String id) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from board ");
		sql.append("where boardNo=?");
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		BoardDTO board = null;

		try {
			con = DBUtil.getConnect();
			ptmt = con.prepareStatement(sql.toString());
//			ptmt.setString(1, boardNo);
			rs = ptmt.executeQuery();
			if (rs.next()) {
//				board = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return board;
	}

}
