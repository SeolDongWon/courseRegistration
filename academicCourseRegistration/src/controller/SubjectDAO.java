package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.SubjectVO;

public class SubjectDAO { // Subject Data Access Object

	// 학과 목록 //
	public void getSubjectTotalList() {
		Connection con = DBUtil.getConnection(); // DB 연결
		PreparedStatement pstmt = null; // PreparedStatement는 쿼리를 미리 컴파일해서 SQL삽입 공격 방어
										// Statement은 동적쿼리를 사용해서 SQL Injection 공격에 취약
		ResultSet rs = null; // 쿼리를 실행한 출력결과를 저장할 변수
		SubjectVO sbVO = null; // 출력결과 데이터로 만든 객체를 저장할 변수
		String sql = "select * from subject order by no"; // 쿼리를 문자열로 저장

		try {
			pstmt = con.prepareStatement(sql); // 쿼리를 DB로 전송
			rs = pstmt.executeQuery(); // 출력결과를 저장

			System.out.println("일련번호\t학과번호\t학과명");

			while (rs.next()) { // 출력결과를 한 줄씩 읽어서 null까지 반복
				sbVO = new SubjectVO(); // 출력결과를 받을 객체 할당
				sbVO.setNo(rs.getInt("no")); // 출력결과 중 no를 할당
				sbVO.setS_num(rs.getString("s_num")); // 출력결과 중 s_num를 할당
				sbVO.setS_name(rs.getString("s_name")); // 출력결과 중 s_name를 할당
				System.out.println(sbVO.toString()); // 객체에 할당한 데이터를 출력
			}

		} catch (SQLException e) { // SQL 에서 오류 발생 시 작동
			e.printStackTrace();
			System.out.println("===============================================");
			System.out.println(e);
			System.out.println("SQLException 오류");
		} catch (Exception e) { // SQL 이외 오류 발생 시 작동
			e.printStackTrace();
			System.out.println(e);
			System.out.println("Exception 오류");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close오류");
			}
		}
	}

	// 학과 등록
	public void setSubjectRegiste(SubjectVO sbVO) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into subject values (subject_no_seq.nextval, ?, ?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sbVO.getS_num()); // 쿼리 문자열의 1번째 ?에 넣을 변수
			pstmt.setString(2, sbVO.getS_name()); // 쿼리 문자열의 2번째 ?에 넣을 변수

			int cnt = pstmt.executeUpdate(); // DML 쿼리의 줄 수를 카운트
			if (cnt >= 1) { // 1줄 이상이면 쿼리를 실행한 것이므로 성공
				System.out.println(sbVO.getS_name() + " 학과 등록 완료");
				System.out.println("학과 등록 성공");
			} else { // 1줄 이하, 즉 0줄이면 쿼리를 실행하지 못한 것이므로 실패
				System.out.println("학과 등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close오류");
			}
		}
	}

	// 학과 수정
	public void setSubjectUpdate(SubjectVO sbVO) {
		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "update subject set s_num=?, s_name=? where no=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sbVO.getS_num()); // subjectManager.subjectUpdate()에서 입력한 데이터 출력
			pstmt.setString(2, sbVO.getS_name()); // subjectManager.subjectUpdate()에서 입력한 데이터 출력
			pstmt.setInt(3, sbVO.getNo()); // subjectManager.subjectUpdate()에서 입력한 데이터 출력

			int cnt = pstmt.executeUpdate();
			if (cnt >= 1) {
				System.out.println(sbVO.getS_name() + " 학과 수정 완료");
				System.out.println("학과 수정 성공");
			} else {
				System.out.println("학과 수정 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close오류");
			}
		}

	}

	// 학과 삭제
	public void setSubjectDelete(int s_no) { // subjectManager.subjectDelete()에서 입력한 데이터를 매개변수로 받음

		Connection con = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from subject where no = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, s_no);

			int cnt = pstmt.executeUpdate();
			if (cnt >= 1) {
				System.out.println("학과 삭제 성공");
			} else {
				System.out.println("학과 삭제 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close오류");
			}
		}
	}
}
