package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.bean.FeedbackBean;
import com.royal.dao.FeedbackDao;

/**
 * Servlet implementation class UserFeedBackServlet
 */
public class UserFeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String feedback_message=request.getParameter("feedback_message");
		String email           =request.getParameter("email");
		String First_Name      =request.getParameter("First_Name");
		String Last_Name       =request.getParameter("Last_Name");
		
		System.out.println("UserFeedBackServlet :: feedback_message :: "+feedback_message);
		System.out.println("UserFeedBackServlet :: email            :: "+email           );
		System.out.println("UserFeedBackServlet :: First_Name       :: "+First_Name      );
		System.out.println("UserFeedBackServlet :: Last_Name        :: "+Last_Name       );
		
		RequestDispatcher rd=null;
		int rowseffected=0;
		FeedbackDao feedbackDao=new FeedbackDao();
		FeedbackBean feedbackBean=new FeedbackBean();
		
		feedbackBean.setFeedback_message(feedback_message);
		feedbackBean.setEmail(email);
		feedbackBean.setFirst_Name(First_Name);
		feedbackBean.setLast_Name(Last_Name);
		
		rowseffected=feedbackDao.insert(feedbackBean);
		
		if (rowseffected>0) 
		{
			rd=request.getRequestDispatcher("home.jsp");
			
		} else 
		{
			rd=request.getRequestDispatcher("feedback.jsp");
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
