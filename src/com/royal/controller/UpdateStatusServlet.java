package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.OrderDao;

/**
 * Servlet implementation class UpdateStatusServlet
 */
public class UpdateStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		int orderID=(Integer) session.getAttribute("orderID");
		String status=request.getParameter("status");
		OrderDao orderDao=new OrderDao();
		
		int rowEffected=0;
		
		rowEffected=orderDao.updateStatus(orderID,status);
		
		System.out.println("UpdateStatusServlet :: rowEffected ==> "+rowEffected);
		
		if (rowEffected>0) 
		{
			rd=request.getRequestDispatcher("index.jsp");
			
		} else 
		{
			rd=request.getRequestDispatcher("ViewOrderServlet");
		}
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
