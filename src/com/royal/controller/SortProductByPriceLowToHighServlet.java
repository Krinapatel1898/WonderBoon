package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class SortProductByPriceLowToHighServlet
 */
public class SortProductByPriceLowToHighServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao pDao=new ProductDao();
		HttpSession session=request.getSession(true);
		ProductBean productBean=new ProductBean();
		String Gender=(String) session.getAttribute("Gender");
		String Age=(String) session.getAttribute("Age");
		int occasionID=(Integer) session.getAttribute("occasionID");
		
		System.out.println("ProductListServlet :: Gender :: "+Gender);
		System.out.println("ProductListServlet :: Age :: "+Age);
		System.out.println("ProductListServlet :: OccasionID :: "+occasionID);
		
		ArrayList<ProductBean> listofProducts = pDao.sortProductsByPriceLowToHigh(Gender,Age,occasionID);
		request.setAttribute("listofProducts", listofProducts);
		request.getRequestDispatcher("listproducts.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
