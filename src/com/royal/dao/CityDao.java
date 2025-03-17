package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.CityBean;
import com.royal.util.DBConnection;

public class CityDao 
{
	public int insert(CityBean cityBean) 
	{
		Connection conn = DBConnection.getConnection();
		String insertCity="INSERT INTO city (cname,sid) VALUES (?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertCity);
			
				pstmt.setString(1, cityBean.getCname());
				pstmt.setInt(2, cityBean.getSid());
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CityDao - insert(CityBean cityBean)  :: Db not connected ");
		}
		return rowsIffected;
	}
	public ArrayList<CityBean>  getAllCities()
	{
		ArrayList<CityBean> listofcities = new ArrayList<CityBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectCities = "SELECT c.cid,c.cname FROM city c , state s WHERE (c.sid=s.sid)";
		CityBean cityBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectCities);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 cityBean = new CityBean(rs.getInt(1), rs.getString(2));
					 listofcities.add(cityBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("CityDao - getAllCities() Db not connected ");
		}
		return listofcities;
	}
	
	public ArrayList<CityBean>  getAllCityByState(int sid)
	{
		ArrayList<CityBean> listofcities = new ArrayList<CityBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectCities = "SELECT cid,cname FROM city WHERE sid=?";
		CityBean cityBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectCities);
				 ps.setInt(1, sid);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 cityBean = new CityBean(rs.getInt(1), rs.getString(2));
					 listofcities.add(cityBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("CityDao - getAllCities() Db not connected ");
		}
		return listofcities;
	}
	
	public ArrayList<CityBean>  getAllCityByState(String sname)
	{
		System.out.println("CityDao :: Sname :: "+sname);
		ArrayList<CityBean> listOfCities = new ArrayList<CityBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectCities = "SELECT cid, cname FROM city c,state s WHERE c.sid=s.sid AND s.sname=?;";
		CityBean cityBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectCities);
				 ps.setString(1, sname);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 cityBean = new CityBean(rs.getInt(1), rs.getString(2));
					 listOfCities.add(cityBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("CityDao - getAllCities() Db not connected ");
		}
		System.out.println("CityDao :: listofcities :: "+listOfCities);
		return listOfCities;
	}
	
	public int delete(int cid)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM city WHERE cid = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, cid);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("CityDao :: delete() DB not connected ");
		}
		return rowsEffected;
	}
	

	public CityBean getCityByPK(int cid)
	{
		CityBean cityBean = null;
		String selectCity = "SELECT c.cid,c.cname,c.sid,s.sname FROM city c , state s WHERE c.sid=s.sid AND cid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectCity);
				pstmt.setInt(1, cid);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					cityBean = new CityBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("CityDao :: getCityByPK(int cid)");
		}
		return cityBean;
	}
	public int update(CityBean cityBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateCity = "UPDATE city SET cname=? , sid=?  WHERE cid=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateCity);
			
				pstmt.setString(1, cityBean.getCname());
				pstmt.setInt(2, cityBean.getSid());
				pstmt.setInt(3, cityBean.getCid());
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("CityDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	

}
