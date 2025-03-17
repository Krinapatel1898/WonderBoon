package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.OrderBean;
import com.royal.bean.StoreBean;
import com.royal.util.DBConnection;

public class OrderDao {

	public int insert(OrderBean orderBean)
	{
		Connection conn = DBConnection.getConnection();
		String insertCity="INSERT INTO order_detail (product_Name, product_Price, product_quantity, firstname, lastname, contact, email, address1, address2, sname, cname, aName, postcode, store_ownerEmail, delivery_date, delivery_time,storeID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertCity);
			
				pstmt.setString(1, orderBean.getProductName());
				pstmt.setInt(2, orderBean.getProduct_Price());
				pstmt.setInt(3, orderBean.getProductQuantity());
				pstmt.setString(4, orderBean.getFirstname());
				pstmt.setString(5, orderBean.getLastname());
				pstmt.setString(6, orderBean.getContact());
				pstmt.setString(7, orderBean.getEmail());
				pstmt.setString(8, orderBean.getAddress1());
				pstmt.setString(9, orderBean.getAddress2());
				pstmt.setString(10, orderBean.getState());
				pstmt.setString(11, orderBean.getCity());
				pstmt.setString(12, orderBean.getArea());
				pstmt.setString(13, orderBean.getPostcode());
				pstmt.setString(14, orderBean.getStore_ownerEmail());
				pstmt.setString(15, orderBean.getDelivery_date());
				pstmt.setString(16, orderBean.getDelivery_time());
				pstmt.setInt(17, orderBean.getStoreID());
				
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("OrderDao - insert(OrderBean orderBean)  :: Db not connected ");
		}
		return rowsIffected;
	}

	public ArrayList<OrderBean> getAllOrders(int storeID) 
	{
		ArrayList<OrderBean> listofOrders = new ArrayList<OrderBean>();
		OrderBean orderBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		String selectOrders = "SELECT * FROM order_detail WHERE storeID=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectOrders);
				pstmt.setInt(1, storeID);
				rs = pstmt.executeQuery();
				
				System.out.println("OrderDao :: getAllOrders :: storeID ==>"+storeID);
				 

				 while (rs.next()) 
				 {
					 orderBean = new OrderBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
					 listofOrders.add(orderBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("OrderDao - getAllOrders() Db not connected ");
		}
		return listofOrders;		
	}

	public OrderBean getOrderByPK(int orderID) 
	{
		OrderBean orderBean = null;
		String selectstore = "SELECT * FROM order_detail WHERE orderID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectstore);
				pstmt.setInt(1, orderID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					orderBean = new OrderBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),rs.getString(19));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("OrderDao :: getOrderByPK(int OrderID) :: DB Not Connected");
		}
		return orderBean;
	}

	public int updateStatus(int orderID,String status) 
	{
		Connection conn = DBConnection.getConnection();
		String updatestatus="UPDATE order_detail SET status=? WHERE orderID=?";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(updatestatus);
				
				pstmt.setString(1, status);
				pstmt.setInt(2, orderID);
				
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("OrderDao - UpdateStatus()  :: Db not connected ");
		}
		return rowsIffected;
	}

	public ArrayList<OrderBean> getAllOrdersByEmail(String email) 
	{
		ArrayList<OrderBean> listofOrders = new ArrayList<OrderBean>();
		OrderBean orderBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;

		String selectOrders = "SELECT * FROM order_detail WHERE email=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectOrders);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				
				System.out.println("OrderDao :: getAllOrdersByEmail :: Email ==>"+email);
				 

				 while (rs.next()) 
				 {
					 orderBean = new OrderBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
					 listofOrders.add(orderBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("OrderDao - getAllOrders() Db not connected ");
		}
		return listofOrders;		
	}

}
