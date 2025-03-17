package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.royal.bean.StoreBean;
import com.royal.bean.StoreRegistrationBean;
import com.royal.util.DBConnection;


public class StoreDao 
{
	public int insert(StoreRegistrationBean storeregistrationBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO store_detail(store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid) VALUES (?,?,?,?,?,?,?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, storeregistrationBean.getStoreName());
				pstmt.setString(2, storeregistrationBean.getStore_Address());
				pstmt.setString(3, storeregistrationBean.getStore_Contact());
				pstmt.setString(4, storeregistrationBean.getStore_Image());
				pstmt.setString(5, storeregistrationBean.getStore_GST_No());
				pstmt.setInt(6, storeregistrationBean.getAid());
				pstmt.setInt(7, storeregistrationBean.getCid());
				pstmt.setInt(8, storeregistrationBean.getSid());

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
	
	
	public ArrayList<StoreBean> getAllStores(String store_ownerEmail) 
	{
		ArrayList<StoreBean> listofStores = new ArrayList<StoreBean>();
		StoreBean storeBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		String selectStores = "SELECT * FROM store_detail WHERE store_ownerEmail=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectStores);
				pstmt.setString(1, store_ownerEmail);
				rs = pstmt.executeQuery();
				
				System.out.println("StoreDao :: getAllStores :: store_ownerEmail ==>"+store_ownerEmail);
				 

				 while (rs.next()) 
				 {
					 storeBean = new StoreBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getInt(7),rs.getInt(8),rs.getInt(9));
					 listofStores.add(storeBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllstore() Db not connected ");
		}
		return listofStores;		
	}
	
	
	

	public int update(StoreBean storeBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateStore = "UPDATE store_detail SET store_Name=?, store_address=?, store_contact=?, store_Image=?, store_GST_No=?, aid=?, cid=?, sid=?, store_ownerEmail=? WHERE storeID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateStore);
			
				pstmt.setString(1, storeBean.getStore_Name());
				pstmt.setString(2, storeBean.getStore_address());
				pstmt.setString(3, storeBean.getStore_contact());
				pstmt.setString(4, storeBean.getStore_Image());
				pstmt.setString(5, storeBean.getStore_GST_No());
				pstmt.setInt(6, storeBean.getAid());
				pstmt.setInt(7, storeBean.getCid());
				pstmt.setInt(8, storeBean.getSid());
				pstmt.setString(9, storeBean.getStore_ownerEmail());
				pstmt.setInt(10, storeBean.getStoreID());

				
				System.out.println("StoreDao-StoreName==>"+storeBean.getStore_Name());
				System.out.println("StoreDao-StoreAddress==>"+storeBean.getStore_address());
				System.out.println("StoreDao-StoreContact==>"+storeBean.getStore_contact());
				System.out.println("StoreDao-StoreImage==>"+storeBean.getStore_Image());
				System.out.println("StoreDao-StoreGST_No==>"+storeBean.getStore_GST_No());
				System.out.println("StoreDao-StoreArea==>"+storeBean.getAid());
				System.out.println("StoreDao-StoreCity==>"+storeBean.getCid());
				System.out.println("StoreDao-StoreState==>"+storeBean.getSid());
				System.out.println("StoreDao-StoreOwnerEmail==>"+storeBean.getStore_ownerEmail());
				System.out.println("StoreDao-StoreID==>"+storeBean.getStoreID());

				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("StoreDao : update() Db not connected");	
		}
		System.out.println("StoreDao ===> Update ==> rowsEffected ==> "+rowsEffected);
		return rowsEffected;
	}


	public StoreBean getStoreByPK(int storeID)
	{
		StoreBean storeBean = null;
		String selectstore = "SELECT storeID,store_Name, store_address, store_contact, store_Image, store_GST_No, s.aid, a.aname, s.cid, c.cname, s.sid, st.sname, store_ownerEmail  FROM store_detail s, area a, city c, state st WHERE storeID=? AND s.aid=a.aid AND s.cid=c.cid AND s.sid=st.sid";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectstore);
				pstmt.setInt(1, storeID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					storeBean = new StoreBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getString(13));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
		}
		return storeBean;
	}
	
	public StoreBean getStoreByID(int storeID)
	{
		StoreBean storeBean = null;
		System.out.println("SDao :: getStoreBYID :: storeID==> "+storeID);
		String selectstore = "SELECT storeID, store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid, store_ownerEmail  FROM store_detail WHERE storeID=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectstore);
				pstmt.setInt(1, storeID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					storeBean = new StoreBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
		}
		return storeBean;
	}


	public int delete(int storeID) 
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM store_detail WHERE storeID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, storeID);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("StoreDao :: delete() DB not connected ");
		}
		return rowsEffected;
		
	}


	public String checkStore(String store_ownerEmail)
	{
		int storeID = 0;
		String store_Name=null;
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="SELECT storeID, store_Name FROM store_detail WHERE store_ownerEmail=?";
		
		
		if (conn!=null)
		{
			try 
			{
				pstmt=conn.prepareStatement(selectQuery);
				pstmt.setString(1, store_ownerEmail);
				rs=pstmt.executeQuery();
				if (rs.next()) 
				{
					storeID=Integer.parseInt(rs.getString(1));
					store_Name=rs.getString(2);
				} 
				System.out.println("StoreID ==> "+storeID);
				System.out.println("Store_Name ==> "+store_Name);
				System.out.println("Store_ownerEmail ==> "+store_ownerEmail);

			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		else 
		{
			System.out.println("DB Not Connected StoreDao ::checkStore()");
		}
				
		return store_Name;
	}
	
	public ArrayList<StoreBean> getStoreBySearch(String store_ownerEmail,String search)
	{
		ArrayList<StoreBean> listOfStores= new ArrayList<StoreBean>();
		System.out.println("ArrayList<StoreBean> :: getStoreBySearch(String store_ownerEmail,String search) :: store_ownerEmail = "+store_ownerEmail);
		System.out.println("ArrayList<StoreBean> :: getStoreBySearch(String store_ownerEmail,String search) :: search = "+search);
		String selectQuery="SELECT storeID, store_Name, store_address, store_contact FROM store_detail WHERE store_ownerEmail='"+store_ownerEmail+"'AND store_Name LIKE '"+search+"%'ORDER BY storeID";
		Connection con=DBConnection.getConnection();
		PreparedStatement pstmt=null;
		
		if(con!=null)
		{
			try {
				pstmt=con.prepareStatement(selectQuery);
				ResultSet rs= pstmt.executeQuery();
				StoreBean storeBean=null;
				while (rs.next()) 
				{
					storeBean = new StoreBean();
					storeBean.setStoreID(rs.getInt(1));
					storeBean.setStore_Name(rs.getString(2));
					storeBean.setStore_address(rs.getString(3));
					storeBean.setStore_contact(rs.getString(4));
					listOfStores.add(storeBean);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("ArrayList<StoreBean> :: getStoreBySearch(String store_ownerEmail,String search) :: selectQuery ==> "+selectQuery);
		}else {
			System.out.println("ArrayList<StoreBean> :: getStoreBySearch(String store_ownerEmail,String search) :: DB Not Connected");
		}
		return listOfStores;
		
	}
	
}
