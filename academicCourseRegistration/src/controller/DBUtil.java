package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() {
		Properties properties = new Properties(); // properties 객체 생성
		Connection con = null;
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/config/db.properties"); // db.propertis 로드
			properties.load(fis);

			String driver = properties.getProperty("driver"); // 드라이버 클래스 경로
			String url = properties.getProperty("url"); // 아이피 포트번호
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");

			Class.forName(driver); // JDBC 드라이버 로드
			con = DriverManager.getConnection(url, username, password); // DB 연결

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("FileNotFoundException 오류");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[" + e.toString() + "]");
			System.out.println("IOException 오류");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException 오류");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException 오류");
		}
		System.out.println("DB 연결성공");

		return con;
	}
}
