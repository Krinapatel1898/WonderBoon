package com.royal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.dao.StoreOwnerDao;
import com.royal.util.ValidationUtils;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
public class StoreOwnerForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		HttpSession session=request.getSession(true);
		String store_ownerEmail=request.getParameter("store_ownerEmail");
		session.setAttribute("store_ownerEmail", store_ownerEmail);
		System.out.println("ForgetPasswordServlet :: store_ownerEmail="+store_ownerEmail);
		
		StoreOwnerDao sdao=new StoreOwnerDao();
		String store_ownerContact = sdao.getContact(store_ownerEmail);
		System.out.println("ForgetPasswordServlet :: store_ownerContact ==> "+store_ownerContact);
		
		String OriginalOTP=ValidationUtils.random(6);
		session.setAttribute("OriginalOTP", OriginalOTP);
		System.out.println("ForgetPasswordServlet :: OriginalOTP ==> "+OriginalOTP);
		
		String OTP=request.getParameter("OTP");
		session.setAttribute("OTP", OTP);
		
		if (OTP.equals("Request OTP by Mail")) 
		{
			String message=ValidationUtils.sendOTPByEmail(store_ownerEmail, "testing", OriginalOTP);
			System.out.println("ForgetPasswordServlet :: Mail :: message ==> "+message);
			
			rd=request.getRequestDispatcher("verifyOTP.jsp");
			
		}
		else if (OTP.equals("Request OTP by SMS")) 
		{
			String message=ValidationUtils.sendSMS(OriginalOTP, store_ownerContact);
			System.out.println("ForgetPasswordServlet :: SMS :: message1 ==> "+message);
			
			rd=request.getRequestDispatcher("verifyOTP.jsp");			
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
