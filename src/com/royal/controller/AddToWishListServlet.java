package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.bean.WishListBean;
import com.royal.dao.ProductDao;
import com.royal.dao.UserDao;
import com.royal.dao.UserRegistrationDao;
import com.royal.dao.WishListDao;

/**
 * Servlet implementation class AddToWishListServlet
 */
public class AddToWishListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd=null;
		WishListDao wishListDao=new WishListDao();
		UserRegistrationDao userRegistrationDao=new UserRegistrationDao();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(true);
		String email=(String) session.getAttribute("email");
		System.out.println("AddToWishListServlet :: email ==> "+email);
		
		int productID=Integer.parseInt(request.getParameter("productID"));
		System.out.println("AddToWishListServlet :: ProductID ::  "+productID);
		session.setAttribute("productID", productID);
		
		int userID=userRegistrationDao.getIdByEmail(email);
		System.out.println("AddToWishListServlet :: userID ::  "+userID);
		session.setAttribute("userID", userID);
		
		ProductDao productDao=new ProductDao();
		ProductBean productBean=productDao.getProductDetailByID(productID);
		System.out.println("AddToWishListServlet :: productBean::"+productBean);
		
		int rowsEffected=wishListDao.insert(productBean, productID, userID);		
		if (rowsEffected>0) {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Product Added to Your Cart');");
			out.print("</script>");
			rd = request.getRequestDispatcher("ListWishListProductServlet");
		} else {
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Product is not Added to Your Cart');");
			out.print("</script>");
			rd = request.getRequestDispatcher("ProductListServlet");
		}
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
