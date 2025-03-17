package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.CityBean;
import com.royal.bean.FeedbackBean;
import com.royal.bean.StoreOwnerBean;
import com.royal.util.DBConnection;

public class FeedbackDao 
{

	public int insert(FeedbackBean feedbackBean) 
	{
		
			Connection conn = DBConnection.getConnection();
			String insertFeedback="INSERT INTO feedback (feedback_message, email, First_Name, Last_Name) VALUES (?,?,?,?)";
			PreparedStatement pstmt = null;
			int rowsIffected = 0;
			if (conn!=null) 
			{
				
				try {
					pstmt = conn.prepareStatement(insertFeedback);
					
					pstmt.setString(1, feedbackBean.getFeedback_message());
					pstmt.setString(2, feedbackBean.getEmail());
					pstmt.setString(3, feedbackBean.getFirst_Name());
					pstmt.setString(4, feedbackBean.getLast_Name());
					
					rowsIffected = pstmt.executeUpdate();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			} else 
			{
				System.out.println("FeedbackDao - insert(FeedbackBean feedbackBean)  :: Db not connected ");
			}
			return rowsIffected;
	
	}

	public ArrayList<FeedbackBean> getAllFeedback() 
	{
		ArrayList<FeedbackBean> listofFeedbacks = new ArrayList<FeedbackBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps=null ;
		String selectStoreOwners = "SELECT feedbackID, feedback_message, email, First_Name, Last_Name FROM feedback";
		FeedbackBean feedbackBean = null;
		if (conn!=null) 
		{
			try 
			{
				 ps = conn.prepareStatement(selectStoreOwners);
				 ResultSet rs = ps.executeQuery();

				 while (rs.next()) 
				 {
					 feedbackBean = new FeedbackBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
					 listofFeedbacks.add(feedbackBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreOwnerDao - getAllstoreowner() Db not connected ");
		}
		return listofFeedbacks;		}
}
