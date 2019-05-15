package com.cafe24.mysite1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite1.vo.GuestbookVo;
import com.cafe24.mysite1.vo.UserVo;

public class UserDao {
	
	public boolean update(UserVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = getConnection();
				String sql="update user set name=?,email=?,password=? "
						+ "where no=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getPassword());
				pstmt.setLong(4, vo.getNo());
				int count = pstmt.executeUpdate();
				result = (count == 1);
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
		}return result;
	}
	
	public boolean insert(UserVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = getConnection();
				String sql="insert into user(name,email,password,gender,join_date) value(?,?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getEmail());
				pstmt.setString(3, vo.getPassword());
				pstmt.setString(4, vo.getGender());
				int count = pstmt.executeUpdate();
				result = (count == 1);
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
		}return result;
		
	}
	public UserVo get(Long no) {
	UserVo result =null;
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=getConnection();
				// sql문 실행
				String sql = "select name,email,password from user where no=?"; //sql 문장의 끝에  ; 을 뺀다
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1,no );
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				if(rs.next()) {
					String name=rs.getString(1);
					String email = rs.getString(2);
					String password = rs.getString(3);
					
					result = new UserVo();
					result.setName(name);
					result.setEmail(email);
					result.setPassword(password);
					
					
					
				}
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
					if(rs!=null)
							rs.close();
					if(pstmt!=null)
							pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
	//Login시
	public UserVo get(String email,String password){
		UserVo result =null;
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=getConnection();
				// sql문 실행
				String sql = "select no,name from user where email=? and password=?"; //sql 문장의 끝에  ; 을 뺀다
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				if(rs.next()) {
					Long no=rs.getLong(1);
					String name = rs.getString(2);
					
					
					result = new UserVo();
					result.setNo(no);
					result.setName(name);
					
					
					
				}
				
		}catch (SQLException e) {
				// TODO Auto-generated catch block
			 System.out.println("error" + e);
			}
		finally {
				try {
					if(conn!=null)
						conn.close();
					if(rs!=null)
							rs.close();
					if(pstmt!=null)
							pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	private Connection getConnection(){
		Connection conn = null;
		// 1. jdbc driver(mariadb) loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.26:3307/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
		return conn;
		
	}
}
