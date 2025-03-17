package com.royal.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.royal.bean.ProductBean;
import com.royal.dao.ProductDao;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		RequestDispatcher rd = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);


		System.out.println("AddProductServlet(isMultipart) : " + isMultipart);

		ProductBean productBean = new ProductBean();
		if (!isMultipart) 
		{
			System.out.println("File Not Uploaded");
		} else 
		{
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = null;

			try {
				items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					System.out.println(i + "-" + items.get(i));
				}
				System.out.println("items:" + items);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator<FileItem> itr = items.iterator();
			while (itr.hasNext()) {
				FileItem item = itr.next();
				if (item.isFormField()) {
					
				
					String paramName = item.getFieldName();
					String paramValue = item.getString();
					
					if (paramName.trim().equals("productID")) 
					{
						System.out.println("productID : " + paramValue);
						productBean.setProductID(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("product_Name")) 
					{
						System.out.println("product_Name : " + paramValue);
						productBean.setProduct_Name(paramValue);
					} else if (paramName.trim().equals("product_Desc")) {
						productBean.setProduct_Desc(paramValue);
					} else if (paramName.trim().equals("product_Price")) {
						productBean.setProduct_Price(Integer.parseInt(paramValue));
					} else if (paramName.trim().equals("product_Weight")) {
						productBean.setProduct_Weight(paramValue);
					} else if (paramName.trim().equals("occasionID")) {
						productBean.setOccasionID(Integer.parseInt(paramValue));
					}  else if (paramName.trim().equals("categoryID")) {
						productBean.setCategoryID(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("subcategoryID")) {
						productBean.setSubcategoryID(Integer.parseInt(paramValue)); 
					}else if (paramName.trim().equals("no_of_product")) {
						System.out.println("UpdateProductServlet :: Number Of Product1 ==> "+paramValue);
						productBean.setNo_of_product(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("store_ownerEmail")) {
						productBean.setStore_ownerEmail(paramValue); 
					}else if (paramName.trim().equals("storeID")) {
						productBean.setStoreID(Integer.parseInt(paramValue));
					}
				} else {
					try {
						boolean flag=true;
						
						String itemName = item.getName();
						System.out.println("InsertProductServlet :: itemName ==> "+itemName);
						Random generator = new Random();
						String paramName = item.getFieldName();
						int r = Math.abs(generator.nextInt());
						String reg = "[.*]";
						String replacingtext = "";
						System.out.println("Text Before Replacing is:- " + itemName);
						Pattern pattern = Pattern.compile(reg);
						Matcher matcher = pattern.matcher(itemName);
						StringBuffer buffer = new StringBuffer();

						while (matcher.find()) {
							System.out.println("----------START----------");
							matcher.appendReplacement(buffer, replacingtext);
							System.out.println("\t" + buffer);
							System.out.println("----------EXIT-----------");
						}
						int IndexOf = itemName.indexOf(".");
						String domainName = itemName.substring(IndexOf);
						System.out.println("domainName" + domainName);
						String finalImage = buffer.toString() + "_" + r + domainName;
						System.out.println("Final Image===" + finalImage);
						File savedFile = new File(
								"C:\\Users\\A to Z\\eclipse-workspace\\designing\\WebContent\\resources\\uploadimg\\"
										+ finalImage);
						item.write(savedFile);
						
						if(paramName.equals("product_Image1"))
						{
						productBean.setProduct_Image1("C:\\Users\\A to Z\\eclipse-workspace\\designing\\WebContent\\resources\\uploadimg\\"
								+ finalImage);
							
						}
						
						if(paramName.equals("product_Image2"))
						{
						productBean.setProduct_Image2("C:\\Users\\A to Z\\eclipse-workspace\\designing\\WebContent\\resources\\uploadimg\\"
								+ finalImage);
							
						}
						
						System.out.println("UpdateProductServlet :: productID==>"+productBean.getProductID());
						System.out.println("UpdateProductServlet :: product_Name==>"+productBean.getProduct_Name());
						System.out.println("UpdateProductServlet :: product_Description==>"+productBean.getProduct_Desc());
						System.out.println("UpdateProductServlet :: Price==>"+productBean.getProduct_Price());
						System.out.println("UpdateProductServlet :: weight==>"+productBean.getProduct_Weight());
						System.out.println("UpdateProductServlet :: OcassionID==>"+productBean.getOccasionID());
						System.out.println("UpdateProductServlet :: CategoryID==>"+productBean.getCategoryID());
						System.out.println("UpdateProductServlet :: SubCategoryID==>"+productBean.getSubcategoryID());														
						System.out.println("UpdateProductServlet :: ProductImage1==>"+productBean.getProduct_Image1());
						System.out.println("UpdateProductServlet :: ProductImage2==>"+productBean.getProduct_Image2());
						System.out.println("UpdateProductServlet :: Number_of_product2==>"+productBean.getNo_of_product());

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		ProductDao sDao = new ProductDao();
//		int no_of_product=Integer.parseInt(request.getParameter("no_of_product"));
//		productBean.setNo_of_product(no_of_product);
//		System.out.println("UpdateProductServlet :: no_of_product ==> "+no_of_product);
		if (sDao.update(productBean)>0) {
			rd = request.getRequestDispatcher("ListProductServlet");
		} else {
			rd = request.getRequestDispatcher("editproduct.jsp");
		}
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
