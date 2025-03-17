package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Session;
import com.royal.bean.ProductBean;
import com.royal.bean.WishListBean;
import com.royal.util.DBConnection;

public class WishListDao 
{

	public int insert(ProductBean productBean, int productID, int userID) 
	{
		Connection conn = DBConnection.getConnection();
		UserRegistrationDao userRegistrationDao=new UserRegistrationDao();
		String email=userRegistrationDao.getEmailByID(userID);
		PreparedStatement pstmt = null;
		
		System.out.println("WishListDao :: insert() :: "+productID);                        
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Name());	   
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Desc());	   
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Price());	
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Weight());	
		System.out.println("WishListDao :: insert() :: "+productBean.getCategoryID());		
		System.out.println("WishListDao :: insert() :: "+productBean.getSubcategoryID());	
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Image1());	
		System.out.println("WishListDao :: insert() :: "+productBean.getProduct_Image2());	
		System.out.println("WishListDao :: insert() :: "+productBean.getNo_of_product());	
		System.out.println("WishListDao :: insert() :: "+productBean.getStore_ownerEmail());
		System.out.println("WishListDao :: insert() :: "+productBean.getStoreID());		   
		System.out.println("WishListDao :: insert() :: "+email);		                       
		System.out.println("WishListDao :: insert() :: "+userID);
		
		// UserWishListBean uwBean = new UserWishListBean();
		int rowsEffected = 0;
		if (conn != null) {
			System.out.println("UserWishListDao - prod_id" + productID);
			System.out.println("UserWishListDao - user_id" + userID);
			String insertQuery = "INSERT INTO wish_list (productID, product_Name, product_Desc, product_Price, product_Weight, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_ownerEmail, storeID, email,userID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setInt(1, 	productID);
				pstmt.setString(2, 	productBean.getProduct_Name());	
				pstmt.setString(3,	productBean.getProduct_Desc());	
				pstmt.setInt(4, 	productBean.getProduct_Price());	
				pstmt.setString(5, 	productBean.getProduct_Weight());	
				pstmt.setInt(6, 	productBean.getCategoryID());		
				pstmt.setInt(7, 	productBean.getSubcategoryID());		
				pstmt.setString(8, 	productBean.getProduct_Image1());	
				pstmt.setString(9, 	productBean.getProduct_Image2());	
				pstmt.setInt(10, 	productBean.getNo_of_product());		
				pstmt.setString(11, productBean.getStore_ownerEmail());	
				pstmt.setInt(12, 	productBean.getStoreID());		
				pstmt.setString(13, email);		
				pstmt.setInt(14, 	userID);	
				rowsEffected = pstmt.executeUpdate();                     
				
				System.out.println("UserWishListDao :: rowsIffected--> " + rowsEffected);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsEffected;
	}

	
	
	public boolean check(int userID, int productID) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		// UserWishListBean uwBean = new UserWishListBean();
		ResultSet rs = null;
		if (conn != null) {
			String checkQuery = "SELECT * FROM wish_list WHERE userID=? AND productID=?";
			try {
				pstmt = conn.prepareStatement(checkQuery);
				pstmt.setInt(1, userID);
				pstmt.setInt(2, productID);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public ArrayList<WishListBean> getProducts(int productID, int userID) 
	{
		ArrayList<WishListBean> listWishListBeans = new ArrayList<WishListBean>();
		System.out.println("WishListDao getProducts(int prod_id,int user_id):: prod_id==>" + productID);
		System.out.println("WishListDao getProducts(int prod_id,int user_id):: user_id==>" + userID);
		String selectQuery = "SELECT wishID, productID, product_Name, product_Desc, product_Price, product_Weight, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_ownerEmail, storeID, email FROM wish_list WHERE userID=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		if (conn != null) {
			try {
				pstmt = conn.prepareStatement(selectQuery);
				pstmt.setInt(1, userID);
				ResultSet rs = pstmt.executeQuery();
				WishListBean WBean = null;
				while (rs.next()) {
					WBean = new WishListBean(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11), 
							rs.getString(12), rs.getInt(13), rs.getString(14));
					listWishListBeans.add(WBean);
					System.out.println(WBean.getProduct_Image1());
					System.out.println(WBean.getProduct_Image2());

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("WishListDao getProducts(int productID,int userID):: selectQuery ==>" + selectQuery);
		} else {
			System.out.println("WishListDao getProducts(int productID,int userID):: DB not connected ");
		}
		return listWishListBeans;
	}



	public int DeleteFromWishList(int productID,int userID)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM wish_list WHERE productID = ? AND userID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, productID);
				pstmt.setInt(2, userID);
			
				rowsEffected = pstmt.executeUpdate();
			
			}catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("WishListDao :: DeleteFromWishList() DB not connected ");
		}
		return rowsEffected;
	}

	
}




























