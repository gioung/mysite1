package com.cafe24.mysite1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite1.vo.GuestbookVo;


public class GuestbookDao {
	

	public boolean insert(GuestbookVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = getConnection();
				String sql="insert into guestbook(name,password,contents,reg_date) value(?,?,?,now())";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getPassword());
				pstmt.setString(3, vo.getContents());
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
	
	public boolean delete(GuestbookVo vo) {
		Boolean result = false;
		Connection conn = null; 
		PreparedStatement pstmt = null;
		try {
				conn = getConnection();
				String sql="delete from guestbook where no=? and password=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, vo.getNo());
				pstmt.setString(2,vo.getPassword() );
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
	
	public List<GuestbookVo> getList(){
		List<GuestbookVo> result = new ArrayList<>();
		
		Connection conn = null; 
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			
				conn=getConnection();
				// sql문 실행
				String sql = "select no,name,contents,date_format(reg_date,'%Y-%m-%d %h:%i:%s') as date"+
						" from guestbook "+
						"order by reg_date desc"; //sql 문장의 끝에  ; 을 뺀다
				
				
				//PreparedStatement 객체 생성 
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
			// 결과 가져오기
				while(rs.next()) {
					Long no=rs.getLong(1);
					String name = rs.getString(2);
					String contents = rs.getString(3);
					String date = rs.getString(4);
					
					GuestbookVo vo = new GuestbookVo();
					vo.setNo(no);
					vo.setName(name);
					vo.setContents(contents);
					vo.setReg_date(date);
					
					result.add(vo);
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
