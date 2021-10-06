package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB 관련 작업을 준비하는 JdbcUtil 클래스 정의
//->DB 연결(접속), 해제(자원반환), Commit, Rollback 작업 수행

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Context initCtx=new InitialContext();
			DataSource ds=(DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
			con=ds.getConnection();
			
			//데이터베이스 작업 단위(트랜잭션)에 대한 처리 시 
			//Commit 기능과 Rollback 기능을 수동으로 동작시키기 위해
			//MySQL의 Auto Commit 기능을 해제해야함(기본값은 오토커밋 동작함)
			//->Connection 객체의 setAutoCommit() 메서드를 호출하여 false 값입력
			con.setAutoCommit(false);
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return con;
	}
	//DB 자원 반환을 위한 close() 메서드 정의
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {		
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




































