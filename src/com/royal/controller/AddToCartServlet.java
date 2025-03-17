package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		System.out.println("AddToCartServlet :: email ==> "+email);
		
		int userID=(Integer) session.getAttribute("userID");
		
		int productID=Integer.parseInt(request.getParameter("productID"));
		System.out.println("AddToCartServelt :: ProductID ::  "+productID);
		
		ProductDao productDao=new ProductDao();
		ProductBean productBean=productDao.getProductDetailByID(productID);
		System.out.println("AddToCartServlet :: productBean::"+productBean);
		
		int rowsEffected=productDao.AddToCart(productBean,email,userID);		
		if (rowsEffected>0) {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Product Added to Your Cart');");
			out.print("</script>");
			rd = request.getRequestDispatcher("ListCartProductServlet");
		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Product is not Added to Your Cart');");
			out.print("</script>");
			rd = request.getRequestDispatcher("ProductListServlet");
		}
		rd.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
