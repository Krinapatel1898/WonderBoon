package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.CityBean;
import com.royal.bean.SubCategoryBean;
import com.royal.util.DBConnection;

public class SubCategoryDao 
{
	
	public int insert(SubCategoryBean subcategoryBean) 
	{
		Connection conn = DBConnection.getConnection();
		String insertsubcategory="INSERT INTO sub_category (subcategoryName,categoryID) VALUES (?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertsubcategory);
			
				pstmt.setString(1, subcategoryBean.getSubcategoryName());
				pstmt.setInt(2, subcategoryBean.getCategoryID());
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("SubcategoryDao - insert(SubcategoryBean subcategoryBean)  :: Db not connected ");
		}
		return rowsIffected;
	}
	public ArrayList<SubCategoryBean>  getAllSubCategories()
	{
		ArrayList<SubCategoryBean> listofsubcategories = new ArrayList<SubCategoryBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectsubcategories = "SELECT s.subcategoryID,s.subcategoryName,c.categoryID,c.categoryName FROM sub_category s , category c WHERE (s.categoryID=c.categoryID)";
		SubCategoryBean subcategoryBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectsubcategories);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 subcategoryBean = new SubCategoryBean(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
					 listofsubcategories.add(subcategoryBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("SubCategoryDao - getAllSubCategories() Db not connected ");
		}
		return listofsubcategories;
	}
	public int delete(int subcategoryID)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM sub_category WHERE subcategoryID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, subcategoryID);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("SubCategoryDao :: delete() DB not connected ");
		}
		return rowsEffected;
	}
	

	public SubCategoryBean getSubCategoryByPK(int subcategoryID)
	{
		SubCategoryBean subcategoryBean = null;
		String selectSubCategory = "SELECT s.subcategoryID,s.subcategoryName,s.categoryID,c.categoryName FROM sub_category s , category c WHERE s.categoryID=c.categoryID AND subcategoryID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectSubCategory);
				pstmt.setInt(1, subcategoryID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					subcategoryBean = new SubCategoryBean(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("SubCategoryDao :: getSubCategoryByPK(int subcategoryID)");
		}
		return subcategoryBean;
	}
	public int update(SubCategoryBean subcategoryBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateSubCategory = "UPDATE sub_category SET subcategoryName=? WHERE subcategoryID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateSubCategory);
			
				
				pstmt.setString(1, subcategoryBean.getSubcategoryName());
				pstmt.setInt(2, subcategoryBean.getSubcategoryID());
				rowsEffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("SubCategoryDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	
	public ArrayList<SubCategoryBean>  getAllSubcategoryByCategory(int categoryID)
	{
		ArrayList<SubCategoryBean> listofsubcategories = new ArrayList<SubCategoryBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectSubcategories = "SELECT subcategoryID, subcategoryName FROM sub_category WHERE categoryID=?";
		SubCategoryBean subCategoryBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectSubcategories);
				 ps.setInt(1, categoryID);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 subCategoryBean = new SubCategoryBean(rs.getInt(1), rs.getString(2));
					 listofsubcategories.add(subCategoryBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("CityDao - getAllCities() Db not connected ");
		}
		return listofsubcategories;
	}

}
