package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.LessonVO;

public class LessonDAO {
	// 과목 목록
	public void getLessonTotalList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LessonVO lsVO = null;

		String sql = "select * from lesson order by no";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			System.out.println("일련번호\t과목약어\t과목명");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lsVO = new LessonVO();
				lsVO.setNo(rs.getInt("no"));
				lsVO.setL_abbre(rs.getString("l_abbre"));
				lsVO.setL_name(rs.getString("l_name"));

				System.out.println(lsVO.toString());

			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println("close 오류");
			}
		}
	}

	// 과목 등록
	public void setLessonRegiste(LessonVO lsVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "insert into lesson values (lesson_no_seq.nextval, ?, ?)";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lsVO.getL_abbre());
			pstmt.setString(2, lsVO.getL_name());

			int cnt = pstmt.executeUpdate();
			if (cnt >= 1) {
				System.out.println(lsVO.getL_name() + " 과목 등록 완료");
			} else {
				System.out.println("과목 등록 실패");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("close 오류");
			}
		}
	}

	// 과목 수정
	public boolean setLessonUpdate(LessonVO lsVO) {
		boolean updateFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "update lesson set l_abbre=?, l_name=? where no=?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lsVO.getL_abbre());
			pstmt.setString(2, lsVO.getL_name());
			pstmt.setInt(3, lsVO.getNo());

			int cnt = pstmt.executeUpdate();
			if (cnt >= 1) {
				System.out.println(lsVO.getL_name() + " 과목 수정 완료");
			} else {
				System.out.println("과목 수정 실패");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("close 오류");
			}
		}
		return updateFlag;
	}

	// 과목 삭제
	public void setLessonDelete(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "delete from lesson where no = ?";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);

			int cnt = pstmt.executeUpdate();
			if (cnt >= 1) {
				System.out.println("과목 삭제 완료");
			} else {
				System.out.println("과목 삭제 실패");
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("close 오류");
			}
		}
	}
}