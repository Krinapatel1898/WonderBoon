package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.CategoryBean;
import com.royal.util.DBConnection;

public class CategoryDao 
{
	public int insert(CategoryBean categoryBean) 
	{
		Connection conn = DBConnection.getConnection();
		String insertCity="INSERT INTO category (categoryName) VALUES (?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertCity);
			
				pstmt.setString(1, categoryBean.getCategoryName());
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CategoryDao - insert(CategoryBean categoryBean)  :: Db not connected ");
		}
		return rowsIffected;
	}
	public ArrayList<CategoryBean>  getAllCategories()
	{
		ArrayList<CategoryBean> listofcategories = new ArrayList<CategoryBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectcategories = "SELECT c.categoryID, c.categoryName FROM category c";
		CategoryBean categoryBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectcategories);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 categoryBean = new CategoryBean(rs.getInt(1), rs.getString(2));
					 listofcategories.add(categoryBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("CategoryDao - getAllCategories() Db not connected ");
		}
		return listofcategories;
	}
	public int delete(int categoryID)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM category WHERE categoryID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, categoryID);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("CategoryDao :: delete() DB not connected ");
		}
		return rowsEffected;
	}
	

	public CategoryBean getCategoryByPK(int categoryID)
	{
		CategoryBean categoryBean = null;
		String selectCategory = "SELECT * FROM category WHERE categoryID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectCategory);
				pstmt.setInt(1, categoryID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					categoryBean = new CategoryBean(rs.getInt(1),rs.getString(2));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
		}
		return categoryBean;
	}
	public int update(CategoryBean categoryBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateCategory = "UPDATE category SET categoryName=? WHERE categoryID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateCategory);
			
				
				pstmt.setString(1, categoryBean.getCategoryName());
				pstmt.setInt(2, categoryBean.getCategoryID());
				rowsEffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("CategoryDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	

}
