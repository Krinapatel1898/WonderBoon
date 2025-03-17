package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.OrderBean;
import com.royal.bean.ProductBean;
import com.royal.dao.StoreOwnerDao;
import com.royal.dao.UserDao;
import com.royal.util.ValidationUtils;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		System.out.println("ConfirmOrderServlet :: Message ==> Order Confirmed !!!");
		UserDao userDao=new UserDao();
		HttpSession session=request.getSession(true);
		String store_ownerEmail=(String) session.getAttribute("store_ownerEmail");
		
		OrderBean orderBean=(OrderBean) session.getAttribute("orderBean");
		StoreOwnerDao storeOwnerDao=new StoreOwnerDao();
		String contact_no=storeOwnerDao.getContact(store_ownerEmail);
		String store_ownerName=storeOwnerDao.getNameByEmail(store_ownerEmail);
		
		ProductBean productBean=(ProductBean) session.getAttribute("productBean");
		
		String message=ValidationUtils.sendOrder(contact_no,store_ownerName);
		System.out.println("ConfirmOrderServlet :: SMS :: message ==> "+message);
		
		String user_email=orderBean.getEmail();
		String name=userDao.getNameByEmail(user_email);
		String message1=ValidationUtils.sendConfirmation(user_email,name,productBean);
		System.out.println("ConfirmOrderServlet :: Mail :: message ==> "+message);
		
		request.setAttribute("user_email", user_email);
		request.getRequestDispatcher("feedback.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
