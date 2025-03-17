package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.StateBean;
import com.royal.util.DBConnection;

public class StateDao
{
	
	public int insert(StateBean stateBean) 
	{
		Connection conn = DBConnection.getConnection();
		String insertCity="INSERT INTO state (sname) VALUES (?)";
		PreparedStatement pstmt = null;
		int rowsIffected = 0;
		if (conn!=null) 
		{
			
			try {
				pstmt = conn.prepareStatement(insertCity);
			
				pstmt.setString(1, stateBean.getSname());
				rowsIffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StateDao - insert(StateBean stateBean)  :: Db not connected ");
		}
		return rowsIffected;
	}
	
	

	public StateBean getStateByPK(int sid)
	{
		StateBean stateBean = null;
		String selectCity = "SELECT * FROM state WHERE sid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectCity);
				pstmt.setInt(1, sid);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					stateBean = new StateBean(rs.getInt(1), rs.getString(2));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StateDao :: getCityByPK(int sid)");
		}
		return stateBean;
	}
	
	
	
	
	public int update(StateBean stateBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateCity = "UPDATE state SET sname=? WHERE sid=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateCity);
			
				pstmt.setString(1, stateBean.getSname());
				pstmt.setInt(2, stateBean.getSid());
				
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("StateDao : update() Db not connected");	
		}
		return rowsEffected;
	}
	
	
	
	public int delete(int sid)
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM state WHERE sid = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, sid);
			
				rowsEffected = pstmt.executeUpdate();
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("StateDao :: delete() DB not connected ");
		}
		return rowsEffected;
	}
	
	
	
	public ArrayList<StateBean>  getAllStates()
	{
		ArrayList<StateBean> listofstates = new ArrayList<StateBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectStates = "SELECT * FROM state";
		StateBean stateBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectStates);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 stateBean = new StateBean(rs.getInt(1), rs.getString(2));
					 listofstates.add(stateBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StateDao - getAllStates() Db not connected ");
		}
		return listofstates;
	}

}
