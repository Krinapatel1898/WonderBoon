package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.AreaBean;
import com.royal.util.DBConnection;

public class AreaDao 
{
	public int insert(AreaBean areaBean) 
	{
		Connection conn = DBConnection.getConnection();
		String insertArea="INSERT INTO area (aname,cid) VALUES (?,?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertArea);
			
				pstmt.setString(1, areaBean.getAname());
				pstmt.setInt(2, areaBean.getCid());
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("AreaDao - insert(AreaBean areaBean)  :: Db not connected ");
		}
		return rowsIffected;
	}
	public ArrayList<AreaBean>  getAllAreas()
	{
		ArrayList<AreaBean> listofareas = new ArrayList<AreaBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectAreas = "SELECT a.aid,a.aname,c.cid,c.cname FROM area a , city c WHERE (a.cid=c.cid)";
		AreaBean areaBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectAreas);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 areaBean = new AreaBean(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
					 listofareas.add(areaBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("AreaDao - getAllAreas() Db not connected ");
		}
		return listofareas;
	}
	
	public ArrayList<AreaBean>  getAllAreasByCity(int cid)
	{
		ArrayList<AreaBean> listofareas = new ArrayList<AreaBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectAreas = "SELECT  a.aid,a.aname FROM area a WHERE cid=?";
		AreaBean areaBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectAreas);
				 ps.setInt(1, cid);				 
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 areaBean = new AreaBean(rs.getInt(1), rs.getString(2));
					 listofareas.add(areaBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("AreaDao - getAllAreas() Db not connected ");
		}
		return listofareas;
	}
	
	
	public ArrayList<AreaBean>  getAllAreasByCity(String cname)
	{
		ArrayList<AreaBean> listofareas = new ArrayList<AreaBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectAreas = "SELECT aid, aname FROM city c,area a WHERE c.cid=a.cid AND c.cname=?";
		AreaBean areaBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectAreas);
				 ps.setString(1, cname);				 
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 areaBean = new AreaBean(rs.getInt(1), rs.getString(2));
					 listofareas.add(areaBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("AreaDao - getAllAreas() Db not connected ");
		}
		return listofareas;
	}
	
	
	public int delete(int aid)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM area WHERE aid = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, aid);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("AreaDao :: delete() DB not connected ");
		}
		return rowsEffected;
	}
	

	public AreaBean getAreaByPK(int aid)
	{
		AreaBean areaBean = null;
		String selectArea = "SELECT a.aid,a.aname,a.cid,c.cname FROM area a , city c  WHERE a.cid=c.cid AND aid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectArea);
				pstmt.setInt(1, aid);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					areaBean = new AreaBean(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("AreaDao :: getAreaByPK(int aid)");
		}
		return areaBean;
	}
	public int update(AreaBean areaBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateArea = "UPDATE area SET aname=? , cid=?  WHERE aid=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateArea);
			
				pstmt.setString(1, areaBean.getAname());
				pstmt.setInt(2, areaBean.getCid());
				pstmt.setInt(3, areaBean.getAid());
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("AreaDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	

}
