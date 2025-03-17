package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.royal.bean.WishListBean;
import com.royal.dao.WishListDao;

/**
 * Servlet implementation class ListWishListProductServlet
 */
public class ListWishListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		WishListDao wishListDao=new WishListDao();
		HttpSession session=request.getSession(true);
		int productID=(Integer) session.getAttribute("productID");
		int userID=(Integer) session.getAttribute("userID");
		ArrayList<WishListBean> listWishListproducts = wishListDao.getProducts(productID, userID);
		request.setAttribute("listWishListproducts", listWishListproducts);
		request.getRequestDispatcher("wishlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
