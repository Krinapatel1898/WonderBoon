package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.OccasionBean;
import com.royal.bean.ProductBean;
import com.royal.util.DBConnection;

public class OccasionDao 
{
	public boolean insert(OccasionBean occasionBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO occassion_details(occasiontitle,occasion_description) VALUES (?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, occasionBean.getOccasiontitle());
				pstmt.setString(2, occasionBean.getOccasion_description());
							
				rowEffected = pstmt.executeUpdate();
				if(rowEffected>0) {
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
			System.out.println("Db not Connected StoreRegistrationDao");
		}
	
		return false;
	}
	
	
	public ArrayList<OccasionBean> getAllOccasions() 
	{
		ArrayList<OccasionBean> listofOccasions = new ArrayList<OccasionBean>();
		OccasionBean occasionBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectStores = "SELECT * FROM occasion_details";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectStores);
				rs = pstmt.executeQuery();
				
				 

				 while (rs.next()) 
				 {
					 occasionBean = new OccasionBean(rs.getInt(1), rs.getString(2), rs.getString(3));
					 listofOccasions.add(occasionBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllstore() Db not connected ");
		}
		return listofOccasions;		
	}
	
	
	

//	public int update(ProductBean productBean) 
//	{
//		Connection conn = DBConnection.getConnection();
//		String updateStore = "UPDATE product SET product_Name=?, product_Desc=?, product_Price=?, product_Weight=?, occasionID=?, categoryID=?, subcategoryID=?, product_Image1=?, String product_Image2=?, no_of_product=?, store_ownerEmail=? WHERE productID=?";
//		PreparedStatement pstmt = null;
//		int rowsEffected = 0;
//		if (conn!=null) 
//		{
//			try 
//			{
//				pstmt = conn.prepareStatement(updateStore);
//			
//				pstmt.setString(1, productBean.getProduct_Name());
//				pstmt.setString(2, productBean.getProduct_Desc());
//				pstmt.setInt(3, productBean.getProduct_Price());
//				pstmt.setString(4, productBean.getProduct_Weight());
//				pstmt.setInt(5, productBean.getOccasionID());
//				pstmt.setInt(6, productBean.getCategoryID());
//				pstmt.setInt(7, productBean.getSubcategoryID());
//				pstmt.setString(8, productBean.getProduct_Image1());
//				pstmt.setString(9, productBean.getProduct_Image2());
//				pstmt.setInt(10, productBean.getNo_of_product());
//				pstmt.setString(11, productBean.getStore_ownerEmail());
//				pstmt.setInt(12, productBean.getProductID());
//				
//				rowsEffected = pstmt.executeUpdate();
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		} else {
//			System.out.println("ProductDao : update() Db not connected");	
//		}
//		System.out.println("ProductDao ===> Update ==> rowsEffected ==> "+rowsEffected);
//		return rowsEffected;
//	}


//	public StoreBean getStoreByPK(int storeID)
//	{
//		StoreBean storeBean = null;
//		String selectstore = "SELECT store_Name, store_address, store_contact, store_Image, store_GST_No, s.aid, a.aname, s.cid, c.cname, s.sid, st.sname, store_ownerEmail  FROM store_detail s, area a, city c, state st WHERE storeID=? AND s.aid=a.aid AND s.cid=c.cid AND s.sid=st.sid";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		conn = DBConnection.getConnection();
//		ResultSet rs = null;
//	
//		if (conn != null) 
//		{
//			try 
//			{
//				pstmt = conn.prepareStatement(selectstore);
//				pstmt.setInt(1, storeID);
//				rs = pstmt.executeQuery();
//				
//				while (rs.next()) 
//				{
//					storeBean = new StoreBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7),rs.getInt(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12));
//				}
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		} else 
//		{
//			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
//		}
//		return storeBean;
//	}
//	
//	public StoreBean getStoreByID(int storeID)
//	{
//		StoreBean storeBean = null;
//		System.out.println("SDao :: getStoreBYID :: storeID==> "+storeID);
//		String selectstore = "SELECT storeID, store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid, store_ownerEmail  FROM store_detail WHERE storeID=?";
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	
//		if (conn != null) 
//		{
//			try 
//			{
//				pstmt = conn.prepareStatement(selectstore);
//				pstmt.setInt(1, storeID);
//				rs = pstmt.executeQuery();
//				
//				while (rs.next()) 
//				{
//					storeBean = new StoreBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
//				}
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		} else 
//		{
//			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
//		}
//		return storeBean;
//	}
//
//
//	public int delete(int storeID) 
//	{
//		Connection conn = DBConnection.getConnection();
//		
//		String deleteQuery = "DELETE FROM store_detail WHERE storeID = ?";
//		PreparedStatement pstmt = null;
//		int rowsEffected = 0;
//		if (conn != null) 
//		{
//			try 
//			{
//				pstmt = conn.prepareStatement(deleteQuery);
//				
//				pstmt.setInt(1, storeID);
//			
//				rowsEffected = pstmt.executeUpdate();
//			
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		}else 
//		{
//			System.out.println("StoreDao :: delete() DB not connected ");
//		}
//		return rowsEffected;
//		
//	}
//
//
//	public String checkStore(String store_ownerEmail)
//	{
//		int storeID = 0;
//		String store_Name=null;
//		Connection conn=DBConnection.getConnection();
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		String selectQuery="SELECT storeID, store_Name FROM store_detail WHERE store_ownerEmail=?";
//		
//		
//		if (conn!=null)
//		{
//			try 
//			{
//				pstmt=conn.prepareStatement(selectQuery);
//				pstmt.setString(1, store_ownerEmail);
//				rs=pstmt.executeQuery();
//				if (rs.next()) 
//				{
//					storeID=Integer.parseInt(rs.getString(1));
//					store_Name=rs.getString(2);
//				} 
//				System.out.println("StoreID ==> "+storeID);
//				System.out.println("Store_Name ==> "+store_Name);
//				System.out.println("Store_ownerEmail ==> "+store_ownerEmail);
//
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		}
//		else 
//		{
//			System.out.println("DB Not Connected StoreDao ::checkStore()");
//		}
//				
//		return store_Name;
//	}

}
