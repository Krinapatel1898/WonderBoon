package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.UserBean;
import com.royal.util.DBConnection;

public class UserDao 
{
	public int insert(UserBean userBean)
	{
		Connection conn= DBConnection.getConnection();
		String insertUser="INSERT INTO user_detail (fullname,email,user_password,contact_no,address) VALUES (?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{		
			try {
				pstmt = conn.prepareStatement(insertUser);
				
				pstmt.setString(1, userBean.getFullname());
				pstmt.setString(2, userBean.getEmail());
				pstmt.setString(3, userBean.getEmail());
				pstmt.setString(4, userBean.getContact_no());
				pstmt.setString(5, userBean.getAddress());

				
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("UserDao - insert()  :: Db not connected ");
		}
		return rowsIffected;
	}
	
	public ArrayList<UserBean> getAllUsers() 
	{
		ArrayList<UserBean> listofusers = new ArrayList<UserBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectUsers = "SELECT userID, fullname, email, user_password, contact_no FROM user_detail";
		UserBean userBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectUsers);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 userBean = new UserBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					 listofusers.add(userBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("UserDao - getAllUser() Db not connected ");
		}
		return listofusers;		
	}

	public int update(UserBean userBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateUser = "UPDATE user_detail SET fullname=?,user_password=?,contact_no=? WHERE email=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateUser);
			
				pstmt.setString(1, userBean.getFullname());
				pstmt.setString(2, userBean.getUser_password());
				pstmt.setString(3, userBean.getContact_no());
				pstmt.setString(4, userBean.getEmail());
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("UserDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	
	public int updatePassword(String email, String user_password) 
	{
		Connection conn = DBConnection.getConnection();
		String updateUser = "UPDATE user_detail SET user_password=? WHERE email=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateUser);
			
				pstmt.setString(1, user_password);
				pstmt.setString(2, email);
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("UserDao : updatePassword() Db not connected");	
		}
		return rowsEffected;
	}
	
	public int delete(int userID) 
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM user_detail WHERE userID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, userID);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("UserDao :: delete() DB not connected ");
		}
		return rowsEffected;
		
	}

	public String getContact(String email) {
		Connection conn = DBConnection.getConnection();
		System.out.println("UserDao :: email ==> "+email);
		String contact_no = "SELECT contact_no FROM user_detail WHERE email=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String number=null;

		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(contact_no);
			
				pstmt.setString(1, email);
				
				rs = pstmt.executeQuery();
				
				while (rs.next())
				{
					number=rs.getString(1);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("UserDao : getContact() Db not connected");	
		}
		System.out.println("UserDao :: contact_no = "+contact_no);
		return number;
	}

	public String getNameByEmail(String user_email)
	{
		Connection conn = DBConnection.getConnection();
		System.out.println("UserDao :: email ==> "+user_email);
		String name = "SELECT fullname FROM user_detail WHERE email=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String fullname=null;

		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(name);
			
				pstmt.setString(1, user_email);
				
				rs = pstmt.executeQuery();
				
				while (rs.next())
				{
					fullname=rs.getString(1);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("UserDao : getContact() Db not connected");	
		}
		System.out.println("UserDao :: contact_no = "+name);
		return fullname;
	}


}
