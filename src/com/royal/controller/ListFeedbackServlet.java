package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.FeedbackBean;
import com.royal.dao.FeedbackDao;

/**
 * Servlet implementation class ListFeedbackServlet
 */
public class ListFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FeedbackDao feedbackDao = new FeedbackDao();
		HttpSession session=request.getSession();
		
		ArrayList<FeedbackBean> getAllFeedbacks = feedbackDao.getAllFeedback();
		
		request.setAttribute("getAllFeedbacks", getAllFeedbacks);
		request.getRequestDispatcher("list_of_feedbacks.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
