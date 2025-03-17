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

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.royal.bean.StoreBean;
import com.royal.dao.StoreDao;

/**
 * Servlet implementation class UpdateStoreServlet
 */
public class UpdateStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

		RequestDispatcher rd = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("UpdateStoreServlet(isMultipart) : " + isMultipart);
		
		StoreBean storeBean = new StoreBean();
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

					if (paramName.trim().equals("storeID")) 
					{
						System.out.println("storeID : " + paramValue);
						storeBean.setStoreID(Integer.parseInt(paramValue));
					} else if (paramName.trim().equals("store_Name")) {
						System.out.println("store_Name : " + paramValue);
						storeBean.setStore_Name(paramValue);
					} else if (paramName.trim().equals("store_address")) {
						storeBean.setStore_address(paramValue);
					} else if (paramName.trim().equals("store_contact")) {
						storeBean.setStore_contact(paramValue);
					} else if (paramName.trim().equals("store_GST_No")) {
						storeBean.setStore_GST_No(paramValue);
					} else if (paramName.trim().equals("sid")) {
						storeBean.setSid(Integer.parseInt(paramValue));
					}  else if (paramName.trim().equals("cid")) {
						storeBean.setCid(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("aid")) {
						storeBean.setAid(Integer.parseInt(paramValue)); 
					}else if (paramName.trim().equals("store_ownerEmail")) {
						storeBean.setStore_ownerEmail(paramValue); 
					}
				} else {
					try {
						boolean flag=true;
						
						String itemName = item.getName();
						System.out.println("UpdateStoreServlet :: itemName ==> "+itemName);
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
						
							storeBean.setStore_Image("C:\\Users\\A to Z\\eclipse-workspace\\designing\\WebContent\\resources\\uploadimg\\"
								+ finalImage);
							
						
														
						System.out.println("UpdateStoreServlet :: StoreImage1==>"+storeBean.getStore_Image());
						

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		StoreDao sDao = new StoreDao();
		if (sDao.update(storeBean)>0) {
			rd = request.getRequestDispatcher("ListStoreServlet");
		} else {
			rd = request.getRequestDispatcher("editstore.jsp");
		}
		rd.forward(request, response);

	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
