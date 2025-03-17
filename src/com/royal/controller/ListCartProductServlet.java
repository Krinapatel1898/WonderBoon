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
 * Servlet implementation class ListCartProductServlet
 */
public class ListCartProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ProductDao pDao=new ProductDao();
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		int userID=(Integer) session.getAttribute("userID");
		ArrayList<ProductBean> listcartproducts = pDao.ListCartProducts(userID);
		request.setAttribute("listcartproducts", listcartproducts);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
