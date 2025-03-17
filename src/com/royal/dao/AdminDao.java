package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.royal.bean.AdminBean;
import com.royal.util.DBConnection;

public class AdminDao 
{

	public int insert(AdminBean adminBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		int rowEffected = 0;
		String insertQuery = "INSERT INTO admin_detail(admin_Name,admin_Email,admin_password) VALUES ('" +adminBean.getAdmin_Name()+"','" +adminBean.getAdmin_Email()+"','" +adminBean.getAdmin_password()+"')";
		
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(insertQuery);
				rowEffected = stmt.executeUpdate();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected StoreRegDao");
		}
	
		return rowEffected;
	}
	
	
	public boolean check(String admin_Email,String admin_password)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT * FROM admin_detail WHERE admin_Email=? and admin_password=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(query);
				stmt.setString(1, admin_Email);
				stmt.setString(2, admin_password);
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
			System.out.println("Db not Connected AdminDao");
		}

		return false;
		
	}
	
	public String getnameByemail(String admin_Email) 
	{
		String userName = null;
		
		String getNameByEmailQuery = "SELECT admin_Name FROM admin_detail WHERE admin_Email=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getNameByEmailQuery);
				
				pstmt.setString(1, admin_Email);

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
			System.out.println("AdminDao :: getnameByemail() Db not connected");
		}
		return userName;
	}
	
	public String checkstore(String admin_Email)
	{
		String admin_Name=null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String selectquery="SELECT admin_Name FROM admin_detail WHERE admin_Email=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(selectquery);
				stmt.setString(1, admin_Email);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					admin_Name=rs.getString(1);
				}
				System.out.println("Name of Admin :: "+admin_Name);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected AdminDao");
		}

		return admin_Name;
		
	}


	public int update(AdminBean adminBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateAdmin = "UPDATE admin_detail SET admin_password=? WHERE admin_Email=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateAdmin);
			
				pstmt.setString(1, adminBean.getAdmin_password());
				pstmt.setString(2, adminBean.getAdmin_Email());
				
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("AdminDao : update() Db not connected");	
		}
		return rowsEffected;
	}


	public int updatePassword(String admin_Email, String admin_password) 
	{
		Connection conn = DBConnection.getConnection();
		String updateAdmin = "UPDATE admin_detail SET admin_password=? WHERE admin_Email=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateAdmin);
			
				pstmt.setString(1, admin_password);
				pstmt.setString(2, admin_Email);
				
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("AdminDao : updatePassword() Db not connected");	
		}
		return rowsEffected;
	}
}
