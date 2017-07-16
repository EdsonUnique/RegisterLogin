package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.JdbcUtil;
import dao.Access2db;
import domain.User;

public class Jdbc2dbImpl implements Access2db{

	public void add(User user) {
		
		PreparedStatement ps=null;
		Connection con=JdbcUtil.getConnection();
		String sql="insert into users values(?,?,?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setObject(1, user.getId());
			ps.setObject(2, user.getUname());
			ps.setObject(3, user.getPassword());
			ps.setObject(4, user.getEmail());
			ps.setObject(5, user.getBirthday());
			ps.setObject(6, user.getNickname());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e);
			}
			throw new RuntimeException(e);
		}finally{
			try {
				ps.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
				
		
	}

	public User find(String uname, String password) {
		
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql="select * from users where uname=? and password=?";
		con=JdbcUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			
			ps.setObject(1, uname);
			ps.setObject(2, password);
			
			rs=ps.executeQuery();
			if(rs.next()){
				User user=new User();
				user.setId(rs.getString(1));
				user.setUname(rs.getString(2));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				user.setNickname(rs.getString("nickname"));
				
				return user;
				
			}else{
				return null;
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			
			try {
				
				if(rs!=null)
				rs.close();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			
			try {
				
				if(ps!=null)
				ps.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
	}

	public boolean find(String username) {
		
		ResultSet rs=null;
		Connection con=null;
		PreparedStatement ps=null;
		
		String sql="select * from users where uname=?";
		con=JdbcUtil.getConnection();
		try {
			ps=con.prepareStatement(sql);
			ps.setObject(1, username);
			
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			
			try {
				if(rs!=null)
					rs.close();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			
			try {
				
				if(ps!=null)
				 ps.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
			try {
				con.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			
		}
		
		
	}

}
