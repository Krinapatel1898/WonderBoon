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
import com.royal.dao.OrderDao;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class CheckoutProductServlet
 */
public class CheckoutProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession(true);
		ProductBean productBean=(ProductBean)session.getAttribute("productBean");
		String firstname=request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String contact  =request.getParameter("contact");
		String email    =request.getParameter("email");
		String address1 =request.getParameter("address1");
		String address2 =request.getParameter("address2");
		String sname    =request.getParameter("sname");
		String cname    =request.getParameter("cname");
		String aName    =request.getParameter("aname");
		String postcode =request.getParameter("postcode");
		String delivery_date=request.getParameter("delivery_date");
		String delivery_time=request.getParameter("delivery_time");
		
		System.out.println("CheckOutServlet ==> firstname ==> "+firstname);
		System.out.println("CheckOutServlet ==> lastname  ==> "+lastname );
		System.out.println("CheckOutServlet ==> contact   ==> "+contact  );
		System.out.println("CheckOutServlet ==> email     ==> "+email    );
		System.out.println("CheckOutServlet ==> address1  ==> "+address1 );
		System.out.println("CheckOutServlet ==> address2  ==> "+address2 );
		System.out.println("CheckOutServlet ==> sname     ==> "+sname    );
		System.out.println("CheckOutServlet ==> cname     ==> "+cname    );
		System.out.println("CheckOutServlet ==> aName     ==> "+aName    );
		System.out.println("CheckOutServlet ==> postcode  ==> "+postcode );
		System.out.println("CheckOutServlet ==> productName ==> "+productBean.getProduct_Name());
		System.out.println("CheckoutServlet ==> product_Description ==> "+productBean.getProduct_Desc());
		System.out.println("CheckoutServlet ==> product_Price ==> "+productBean.getProduct_Price());		
		System.out.println("CheckoutServlet ==> product_Image1 ==> "+productBean.getImg1());
		System.out.println("CheckoutServlet ==> product_Image1 ==> "+productBean.getProduct_Image1());
		System.out.println("CheckoutServlet ==> product_Image2 ==> "+productBean.getImg2());
		System.out.println("CheckoutServlet ==> product_Image2 ==> "+productBean.getProduct_Image2());
		System.out.println("CheckoutServlet ==> Delivery_Date ==> "+delivery_date);
		System.out.println("CheckoutServlet ==> Delivery_Time ==> "+delivery_time);
		System.out.println("CheckoutServlet ==> StoreID ==> "+productBean.getStoreID());


		
		OrderBean orderBean=new OrderBean();
		OrderDao orderDao=new OrderDao();
		orderBean.setFirstname(firstname);
		orderBean.setLastname(lastname);
		orderBean.setContact(contact);
		orderBean.setEmail(email);
		orderBean.setAddress1(address1);
		orderBean.setAddress2(address2);
		orderBean.setState(sname);
		orderBean.setCity(cname);
		orderBean.setArea(aName);
		orderBean.setPostcode(postcode);
		orderBean.setProductName(productBean.getProduct_Name());
		orderBean.setProduct_Desc(productBean.getProduct_Desc());
		orderBean.setProduct_Price(productBean.getProduct_Price());;
		orderBean.setProductImage1(productBean.getImg1());
		orderBean.setProductImage2(productBean.getImg2());
		orderBean.setProductQuantity(productBean.getNo_of_product());
		orderBean.setStore_ownerEmail(productBean.getStore_ownerEmail());
		orderBean.setDelivery_date(delivery_date);
		orderBean.setDelivery_time(delivery_time);
		orderBean.setStoreID(productBean.getStoreID());
		
		String store_ownerEmail=productBean.getStore_ownerEmail();
		session.setAttribute("store_ownerEmail", store_ownerEmail);
		
		session.setAttribute("orderBean", orderBean);
		
		RequestDispatcher rd=null;
		int rowsEffected=0;
		rowsEffected=orderDao.insert(orderBean);
		System.out.println("CheckoutServlet :: rowsEffected :: "+rowsEffected);
		
		if (rowsEffected>0) 
		{
			rd=request.getRequestDispatcher("ConfirmOrderServlet");			
		}
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
