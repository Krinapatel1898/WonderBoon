package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.royal.bean.UserRegistrationBean;
import com.royal.util.DBConnection;

public class UserRegistrationDao 
{

	public int insert(UserRegistrationBean userregistrationBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO user_detail(fullname,email,user_password,contact_no) VALUES (?,?,?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, userregistrationBean.getFullname());
				pstmt.setString(2, userregistrationBean.getEmail());
				pstmt.setString(3, userregistrationBean.getUser_password());
				pstmt.setString(4, userregistrationBean.getContact_no());

				rowEffected = pstmt.executeUpdate();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected UserRegistrationDao");
		}
	
		return rowEffected;
	}
	
	
	public boolean check(String email,String user_password)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT * FROM user_detail WHERE email=? and user_password=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(query);
				stmt.setString(1, email);
				stmt.setString(2, user_password);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					return true;
				}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected UserRegistrationDao");
		}

		return false;
		
	}
	
	public String getnameByemail(String email) 
	{
		String userName = null;
		
		String getBynameQuery = "SELECT fullname FROM user_detail WHERE email=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getBynameQuery);
				
				pstmt.setString(1, email);

				rs = pstmt.executeQuery();

				while(rs.next())
				{ 
					userName =rs.getString(1);	
				}	
				System.out.println(userName);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.out.println("UserRegistrationDao :: getnameByemail() Db not connected");
		}
		return userName;
	}
	
	public String checkuser(String email)
	{
		String userName=null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT fullname FROM user_detail WHERE email=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(query);
				stmt.setString(1, email);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					userName=rs.getString(1);
				}
				System.out.println(userName);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected UserRegistrationDao");
		}

		return userName;
		
	}


	public String getContactByEmail(String email) 
	{
		String number = null;
		
		String getBynameQuery = "SELECT contact_no FROM user_detail WHERE email=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getBynameQuery);
				
				pstmt.setString(1, email);

				rs = pstmt.executeQuery();

				while(rs.next())
				{ 
					number =rs.getString(1);	
				}	
				System.out.println(number);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.out.println("UserRegistrationDao :: getContactByemail() Db not connected");
		}
		return number;
	}


	public int getIdByEmail(String email) 
	{
		int userID = 0;
		
		String getIDByEmailQuery = "SELECT userID FROM user_detail WHERE email=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getIDByEmailQuery);
				
				pstmt.setString(1, email);

				rs = pstmt.executeQuery();

				while(rs.next())
				{ 
					userID =rs.getInt(1);	
				}	
				System.out.println("UserRegistrationDao :: UserID ==> "+userID);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.out.println("UserRegistrationDao :: getIDByemail() Db not connected");
		}
		return userID;	
	}


	public String getEmailByID(int userID) 
	{
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		String email=null;
		
		System.out.println("UserRegistrationDao :: getEmailByID() :: userID ==> "+userID);
		
		String getEmailByIDQuery = "SELECT email FROM user_detail WHERE userID=?";
		
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getEmailByIDQuery);
					
				pstmt.setInt(1, userID);

				rs = pstmt.executeQuery();

				while(rs.next())
				{ 
					email =rs.getString(1);	
				}	
				System.out.println("UserRegistrationDao :: User_Email ==> "+email);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.out.println("UserRegistrationDao :: getEmailByID() Db not connected");
		}
		
		return email;
	}

}
