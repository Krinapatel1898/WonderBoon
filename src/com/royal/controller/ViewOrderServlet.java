package com.royal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.OrderBean;
import com.royal.bean.ProductBean;
import com.royal.bean.StoreBean;
import com.royal.dao.OrderDao;
import com.royal.dao.ProductDao;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class ViewOrderServlet
 */
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int orderID=Integer.parseInt(request.getParameter("orderID"));
		System.out.println("ViewOrderServlet: orderID : "+ orderID);
		OrderDao  orderDao = new OrderDao();
		OrderBean orderBean =orderDao.getOrderByPK(orderID);
		HttpSession session=request.getSession(true);
		session.setAttribute("orderID", orderID);
	
		
		request.setAttribute("orderBean", orderBean);
		
		request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
