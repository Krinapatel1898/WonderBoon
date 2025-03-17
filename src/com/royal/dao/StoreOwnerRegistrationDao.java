package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.royal.bean.StoreOwnerRegistrationBean;
import com.royal.util.DBConnection;

public class StoreOwnerRegistrationDao 
{

	public int insert(StoreOwnerRegistrationBean storeownerregistrationBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO store_owner(store_ownerName, store_ownerContact, store_ownerEmail, store_ownerPassword) VALUES (?,?,?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, storeownerregistrationBean.getStore_ownerName());
				pstmt.setString(2, storeownerregistrationBean.getStore_ownerContact());
				pstmt.setString(3, storeownerregistrationBean.getStore_ownerEmail());
				pstmt.setString(4, storeownerregistrationBean.getStore_ownerPassword());
//				pstmt.setInt(5, storeownerregistrationBean.getStore_ownerID());


				rowEffected = pstmt.executeUpdate();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected StoreOwnerRegistrationDao");
		}
	
		return rowEffected;
	}
	
	
	public boolean check(String store_ownerEmail,String store_ownerPassword)
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String Checkquery="SELECT * FROM store_owner WHERE store_ownerEmail=? and store_ownerPassword=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(Checkquery);
				stmt.setString(1, store_ownerEmail);
				stmt.setString(2, store_ownerPassword);
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
			System.out.println("Db not Connected StoreOwnerRegistrationDao");
		}

		return false;
		
	}
	
	public String getnameByemail(String store_ownerEmail) 
	{
		String userName = null;
		
		String getByemailQuery = "SELECT store_ownerName FROM store_owner WHERE store_ownerEmail=?";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if (conn!= null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(getByemailQuery);
				
				pstmt.setString(1, store_ownerEmail);

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
			System.out.println("StoreOwnerRegistrationDao :: getnameByemail() Db not connected");
		}
		return userName;
	}
	
	public String checkuser(String store_ownerEmail)
	{
		String userName=null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT store_ownerName FROM store_owner WHERE store_ownerEmail=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(query);
				stmt.setString(1, store_ownerEmail);
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
			System.out.println("Db not Connected StoreOwnerRegistrationDao");
		}

		return userName;
		
	}


	public String getContactByEmail(String store_ownerEmail) 
	{
		String number=null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT store_ownerContact FROM store_owner WHERE store_ownerEmail=?";
		if (conn != null) 
		{
			try 
			{
				stmt=conn.prepareStatement(query);
				stmt.setString(1, store_ownerEmail);
				rs = stmt.executeQuery();
				if(rs.next())
				{
					number=rs.getString(1);
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
			System.out.println("Db not Connected StoreOwnerRegistrationDao :: GetContactByEmail()");
		}

		
		return number;
	}

}
