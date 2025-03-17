package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;
import com.royal.bean.StoreOwnerBean;
import com.royal.util.DBConnection;

public class StoreOwnerDao 
{
	public int insert(StoreOwnerBean storeownerBean)
	{
		Connection conn= DBConnection.getConnection();
		String insertStoreOwner="INSERT INTO store_owner (store_ownerName, store_ownerContact, store_ownerEmail, store_ownerPassword) VALUES (?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{		
			try {
				pstmt = conn.prepareStatement(insertStoreOwner);
				
				pstmt.setString(1, storeownerBean.getStore_ownerName());
				pstmt.setString(2, storeownerBean.getStore_ownerContact());
				pstmt.setString(3, storeownerBean.getStore_ownerEmail());
				pstmt.setString(4, storeownerBean.getStore_ownerPassword());

				
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StoreOwnerDao - insert()  :: Db not connected ");
		}
		return rowsIffected;
	}
	
	public ArrayList<StoreOwnerBean> getAllStoreOwners() 
	{
		ArrayList<StoreOwnerBean> listofStoreOwners = new ArrayList<StoreOwnerBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectStoreOwners = "SELECT store_ownerID, store_ownerName, store_ownerContact, store_ownerEmail FROM store_owner";
		StoreOwnerBean storeownerBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectStoreOwners);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 storeownerBean = new StoreOwnerBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
					 listofStoreOwners.add(storeownerBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreOwnerDao - getAllstoreowner() Db not connected ");
		}
		return listofStoreOwners;		
	}
	
	
	public int delete(int store_ownerID) 
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM store_owner WHERE store_ownerID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, store_ownerID);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("StoreOwnerDao :: delete() DB not connected ");
		}
		return rowsEffected;
		
	}
	
	

	public int update(StoreOwnerBean storeownerBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateStoreOwner = "UPDATE store_owner SET store_ownerContact=?, store_ownerPassword=? WHERE store_ownerEmail=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateStoreOwner);
			
				pstmt.setString(1, storeownerBean.getStore_ownerContact());
				pstmt.setString(2, storeownerBean.getStore_ownerPassword());
				pstmt.setString(3, storeownerBean.getStore_ownerEmail());
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("StoreOwnerDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	
	public int updatePassword(String store_ownerEmail,String store_ownerPassword) 
	{
		Connection conn = DBConnection.getConnection();
		String updatePassword= "UPDATE store_owner SET store_ownerPassword=? WHERE store_ownerEmail=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updatePassword);
			
				pstmt.setString(1, store_ownerPassword);
				pstmt.setString(2, store_ownerEmail);
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("StoreOwnerDao : updatePassword() Db not connected");	
		}
		return rowsEffected;
	}

	public String getContact(String store_ownerEmail) 
	{
		Connection conn = DBConnection.getConnection();
		System.out.println("StoreOwnerDao :: store_ownerEmail ==> "+store_ownerEmail);
		String store_ownerContact = "SELECT store_ownerContact FROM store_owner WHERE store_ownerEmail=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String number=null;

		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(store_ownerContact);
			
				pstmt.setString(1, store_ownerEmail);
				
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
			System.out.println("StoreOwnerDao : getContact() Db not connected");	
		}
		System.out.println("StoreOwnerDao :: store_ownerContact = "+store_ownerContact);
		return number;
	}
	
	
	
	public String getNameByEmail(String store_ownerEmail) 
	{
		Connection conn = DBConnection.getConnection();
		System.out.println("StoreOwnerDao :: store_ownerEmail ==> "+store_ownerEmail);
		String store_ownerName = "SELECT store_ownerName FROM store_owner WHERE store_ownerEmail=?";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String name=null;

		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(store_ownerName);
			
				pstmt.setString(1, store_ownerEmail);
				
				rs = pstmt.executeQuery();
				
				while (rs.next())
				{
					name=rs.getString(1);
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("StoreOwnerDao : getContact() Db not connected");	
		}
		System.out.println("StoreOwnerDao :: store_ownerName = "+store_ownerName);
		return name;
	}

}
