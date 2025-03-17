package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.AdminDao;
import com.royal.dao.StoreOwnerDao;
import com.royal.util.ValidationUtils;

/**
 * Servlet implementation class AdminForgetPasswordServlet
 */
public class AdminForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		String admin_Email=request.getParameter("admin_Email");
		session.setAttribute("admin_Email", admin_Email);
		System.out.println("AdminForgetPasswordServlet :: admin_Email="+admin_Email);
		
		AdminDao adminDao=new AdminDao();
		
		String OriginalOTP=ValidationUtils.random(6);
		session.setAttribute("OriginalOTP", OriginalOTP);
		System.out.println("ForgetPasswordServlet :: OriginalOTP ==> "+OriginalOTP);
		
		String OTP=request.getParameter("OTP");
		session.setAttribute("OTP", OTP);
		
		if (OTP.equals("Request OTP by Mail")) 
		{
			String message=ValidationUtils.sendOTPByEmail(admin_Email, "testing", OriginalOTP);
			System.out.println("AdminForgetPasswordServlet :: Mail :: message ==> "+message);
			
			rd=request.getRequestDispatcher("verifyOTP.jsp");
			
		}
//		else if (OTP.equals("Request OTP by SMS")) 
//		{
//			String message=ValidationUtils.sendSMS(OriginalOTP, store_ownerContact);
//			System.out.println("ForgetPasswordServlet :: SMS :: message1 ==> "+message);
//			
//			rd=request.getRequestDispatcher("verifyOTP.jsp");			
//		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
