package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.royal.bean.OrderBean;
import com.royal.dao.OrderDao;

/**
 * Servlet implementation class AdminViewUserOrderListServlet
 */
public class AdminViewUserOrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		
		OrderDao orderDao=new OrderDao();
		ArrayList<OrderBean> getAllOrders = orderDao.getAllOrdersByEmail(email);
		request.setAttribute("getAllOrders", getAllOrders);
		

		request.getRequestDispatcher("admin_list_of_orders.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
