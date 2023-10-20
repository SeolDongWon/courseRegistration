package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.StudentVO;

public class StudentDAO { // 구조에 관한 주석은 subjectDAO 참고
	// 학생 등록
	public void setStudentRegister(StudentVO stVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into student values (student_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stVO.getSd_num());
			pstmt.setString(2, stVO.getSd_name());
			pstmt.setString(3, stVO.getSd_id());
			pstmt.setString(4, stVO.getSd_passwd());
			pstmt.setString(5, stVO.getS_num());
			pstmt.setString(6, stVO.getSd_birthday());
			pstmt.setString(7, stVO.getSd_phone());
			pstmt.setString(8, stVO.getSd_address());
			pstmt.setString(9, stVO.getSd_email());

			int cnt = pstmt.executeUpdate();

			if (cnt >= 1) {
				System.out.println(stVO.getSd_name() + "학생정보 등록 완료");
			} else {
				System.out.println("학생정보 등록 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close 오류");
			}
		}
	}

	// 학생 정보 수정
	public void setStudentUpdate(StudentVO stVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update student set sd_passwd=?, sd_phone=?, sd_address=?,sd_email=? where sd_num=?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stVO.getSd_passwd());
			pstmt.setString(2, stVO.getSd_phone());
			pstmt.setString(3, stVO.getSd_address());
			pstmt.setString(4, stVO.getSd_email());
			pstmt.setString(5, stVO.getSd_num());

			int cnt = pstmt.executeUpdate();

			if (cnt >= 1) {
				System.out.println(stVO.getSd_name() + "학생정보 수정 완료");
			} else {
				System.out.println("학생정보 수정 실패");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("close 오류");
			}
		}
	}

	// 동일 학과 학생 일련번호
	public String getStudentCount(String subjecNum) {
		String serialNumber = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 아래 쿼리를 실행해서 특정 학과의 인원 수에 1을 더한 값을 구한다
		String sql = "select LPAD(count(*)+1, 4,'0') as studentCount from student where s_num = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, subjecNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				serialNumber = rs.getString("studentCount");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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
		return serialNumber;
	}

	// 학생 아이디 중복 체크
	public boolean getStudentIdOverlap(String idCheck) {
		boolean CheckFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where sd_id = ?"; // 등록할 아이디를 기준으로 하는 쿼리를 실행

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idCheck);
			rs = pstmt.executeQuery();

			if (rs.next()) { // 레코드값이 있다 = rs가 null이 아니다 = 아이디 중복
				CheckFlag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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
		return CheckFlag;
	}

	// 학생 로그인
	public boolean getStudentLogin(String id, String pw) {
		boolean loginFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from student where sd_id = ? and sd_passwd = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginFlag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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
		return loginFlag;
	}

	// 학생 번호
	public String getStudentNum(String id, String pw) {
		String sd_num = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select sd_num from student where sd_id = ? and sd_passwd= ?"; // 입력한 아이디와 비밀번호가 일치하는 레코드 추출

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sd_num = rs.getString("sd_num");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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
		return sd_num;

	}

	// 학생 정보
	public void getStudent(String id, String pw) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO stVO = null;
		String sql = "select * from student where sd_id = ? and sd_passwd = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			System.out.println("일련번호\t학생번호\t\t성명\t아이디\t\t비밀번호\t\t학과\t\t생년월일\t\t전화번호\t\t주소\t\t\t이메일\t\t\t등록일자");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stVO = new StudentVO();
				stVO.setNo(rs.getInt("no"));
				stVO.setSd_num(rs.getString("sd_num"));
				stVO.setSd_name(rs.getString("sd_name"));
				stVO.setSd_id(rs.getString("sd_id"));
				stVO.setSd_passwd(rs.getString("sd_passwd"));
				stVO.setS_num(rs.getString("s_num"));
				stVO.setSd_birthday(rs.getString("sd_birthday"));
				stVO.setSd_phone(rs.getString("sd_phone"));
				stVO.setSd_address(rs.getString("sd_address"));
				stVO.setSd_email(rs.getString("sd_email"));
				stVO.setSd_date(rs.getDate("sd_date") + ""); // ""을 붙여서 date타입을 string으로 변환

				System.out.println(stVO.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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

	// 학생 전체 목록
	public void getStudentTotalList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentVO stVO = null;
		// 학생 테이블과 학과 테이블을 조인하는 쿼리
		String sql = "select st.no as no, sd_num, sd_name, sd_id, sd_passwd, "
				+ "su.s_name as s_num, sd_birthday, sd_phone, sd_address, sd_email, sd_date "
				+ "from STUDENT st, SUBJECT su where st.s_num = su.s_num order by no";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			System.out.println("일련번호\t학생번호\t\t성명\t아이디\t\t비밀번호\t\t학과\t\t생년월일\t\t전화번호\t\t주소\t\t\t이메일\t\t\t등록일자");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				stVO = new StudentVO();
				stVO.setNo(rs.getInt("no"));
				stVO.setSd_num(rs.getString("sd_num"));
				stVO.setSd_name(rs.getString("sd_name"));
				stVO.setSd_id(rs.getString("sd_id"));
				stVO.setSd_passwd(rs.getString("sd_passwd"));
				stVO.setS_num(rs.getString("s_num")); // 학과 테이블의 학과명을 학생객체의 학과번호 변수에 넣는다
				stVO.setSd_birthday(rs.getString("sd_birthday"));
				stVO.setSd_phone(rs.getString("sd_phone"));
				stVO.setSd_address(rs.getString("sd_address"));
				stVO.setSd_email(rs.getString("sd_email"));
				stVO.setSd_date(rs.getDate("sd_date") + "");

				System.out.println(stVO.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
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
}
