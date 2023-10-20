package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static final String driver = "oracle.jdbc.driver.OracleDriver"; // 드라이버 클래스 경로
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 오라클 접속에 쓸 아이피와 포트번호
	private static final String user = "javauser";
	private static final String pw = "javauser";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, user, pw); // DB 연결
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException 오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		}
		return con;
	}

	public static void main(String[] args) {
		getConnection();
	}

}
