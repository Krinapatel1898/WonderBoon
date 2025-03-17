package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.UserDao;
import com.royal.util.ValidationUtils;

/**
 * Servlet implementation class UserForgetPasswordServlet
 */
public class UserForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		String email=request.getParameter("email");
		session.setAttribute("email", email);
		System.out.println("ForgetPasswordServlet :: User-email="+email);
		
		UserDao udao=new UserDao();
		String contact_no = udao.getContact(email);
		System.out.println("UserForgetPasswordServlet :: contact_no ==> "+contact_no);
		
		String OriginalOTP=ValidationUtils.random(6);
		session.setAttribute("OriginalOTP", OriginalOTP);
		System.out.println("UserForgetPasswordServlet :: OriginalOTP ==> "+OriginalOTP);
		
		String OTP=request.getParameter("OTP");
		session.setAttribute("OTP", OTP);
		
		if (OTP.equals("Request OTP by Mail")) 
		{
			String message=ValidationUtils.sendOTPByEmail(email, "testing", OriginalOTP);
			System.out.println("UserForgetPasswordServlet :: Mail :: message ==> "+message);
			
			rd=request.getRequestDispatcher("verifyOTP.jsp");
			
		}
		else if (OTP.equals("Request OTP by SMS")) 
		{
			String message=ValidationUtils.sendSMS(OriginalOTP, contact_no);
			System.out.println("UserForgetPasswordServlet :: SMS :: message ==> "+message);
			
			rd=request.getRequestDispatcher("verifyOTP.jsp");			
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
