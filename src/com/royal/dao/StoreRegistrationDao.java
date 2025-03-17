package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.royal.bean.StoreRegistrationBean;
import com.royal.util.DBConnection;

public class StoreRegistrationDao 
{
	
	public int insert(StoreRegistrationBean storeregistrationBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO store_detail(store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid,store_ownerEmail) VALUES (?,?,?,?,?,?,?,?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
//				String insertQuery = "INSERT INTO store_detail(store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid,store_ownerEmail) VALUES ('"+storeregistrationBean.getStoreName()+"','"+storeregistrationBean.getStore_Address()+"','"+storeregistrationBean.getStore_Contact()+"','"+storeregistrationBean.getStore_Image()+"','"+storeregistrationBean.getStore_GST_No()+"','"+storeregistrationBean.getAid()+"','"+storeregistrationBean.getCid()+"','"+storeregistrationBean.getSid()+"','"+storeregistrationBean.getStore_ownerEmail()+"')";

				
				pstmt.setString(1, storeregistrationBean.getStoreName());
				pstmt.setString(2, storeregistrationBean.getStore_Address());
				pstmt.setString(3, storeregistrationBean.getStore_Contact());
				pstmt.setString(4, storeregistrationBean.getStore_Image());
				pstmt.setString(5, storeregistrationBean.getStore_GST_No());
				pstmt.setInt(6, storeregistrationBean.getAid());
				pstmt.setInt(7, storeregistrationBean.getCid());
				pstmt.setInt(8, storeregistrationBean.getSid());
				pstmt.setString(9, storeregistrationBean.getStore_ownerEmail());

				System.out.println("==> "+insertQuery);

				rowEffected = pstmt.executeUpdate();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected StoreRegistrationDao");
		}
	
		return rowEffected;
	}
	
	
//	public boolean check(String store_Email,String store_Password)
//	{
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement stmt = null;
//		ResultSet rs=null;
//		String Checkquery="SELECT * FROM store_detail WHERE store_Email=? and store_Password=?";
//		if (conn != null) 
//		{
//			try 
//			{
//				stmt=conn.prepareStatement(Checkquery);
//				stmt.setString(1, store_Email);
//				stmt.setString(2, store_Password);
//				rs = stmt.executeQuery();
//				if(rs.next())
//				{
//					return true;
//				}
//			} 
//			catch (SQLException e)
//			{
//				e.printStackTrace();
//			}
//
//		} 
//		else 
//		{
//			System.out.println("Db not Connected StoreRegistrationDao");
//		}
//
//		return false;
//		
//	}
	
	public String getnameByemail(String store_ownerEmail) 
	{
		String userName = null;
		
		String getByemailQuery = "SELECT store_Name FROM store_detail s1, store_owner s2 WHERE s1.store_ownerEmail=s2.store_ownerEmail";
		
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
			System.out.println("StoreRegistrationDao :: getnameByemail() Db not connected");
		}
		return userName;
	}
	
	public String checkuser(String store_ownerEmail)
	{
		String userName=null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		String query="SELECT store_Name FROM store_detail s1, store_owner s2 WHERE s1.store_ownerEmail=s2.store_ownerEmail";
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
			System.out.println("Db not Connected StoreRegistrationDao");
		}

		return userName;
		
	}
	
}
