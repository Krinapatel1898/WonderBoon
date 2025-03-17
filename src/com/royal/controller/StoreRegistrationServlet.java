package com.royal.controller;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.util.Iterator;
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

import com.royal.bean.StoreRegistrationBean;
import com.royal.dao.StoreRegistrationDao;


/**
 * Servlet implementation class StoreRegistrationServlet
 */
public class StoreRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//private final String
		RequestDispatcher rd = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		System.out.println("AddStoreServlet(isMultipart) : " + isMultipart);
		StoreRegistrationBean storeregistrationBean = new StoreRegistrationBean();
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

//					String store_address = item.getFieldName();
//					String addressvalue = item.getString();
//					String store_number = item.getFieldName();
//					String numbervalue = item.getString();	
//					String store_email = item.getFieldName();
//					String emailvalue = item.getString();
//					String storeowner_email = item.getFieldName();
//					String oemailvalue = item.getString();
//					String area_name = item.getFieldName();
//					String areavalue = item.getString();
//					String city_id = item.getFieldName();						
//					int cityvalue = Integer.parseInt(item.getString());
//					String state_id = item.getFieldName();
//					int statevalue = Integer.parseInt(item.getString());
//					String gst_no = item.getFieldName();
//					String gstvalue = item.getString();
//					System.out.println("Store-Name" + store_name + "Value" + namevalue);
//					System.out.println("Store-Number" + store_number + "Value" + numbervalue);
//					System.out.println("City ID" + cityvalue);

					if (paramName.trim().equals("store_Name")) 
					{
						System.out.println("StoreRegistrationServlet :: store_Name : " + paramValue);
						storeregistrationBean.setStoreName(paramValue);
					} else if (paramName.trim().equals("store_address")) {
						System.out.println("StoreRegistrationServlet :: state_Address ==> "+paramValue);						
						storeregistrationBean.setStore_Address(paramValue);
					} else if (paramName.trim().equals("store_contact")) {
						System.out.println("StoreRegistrationServlet :: state_contact ==> "+paramValue);
						storeregistrationBean.setStore_Contact(paramValue);
					} else if (paramName.trim().equals("store_GST_No")) {
						System.out.println("StoreRegistrationServlet :: state_GST_No ==> "+paramValue);
						storeregistrationBean.setStore_GST_No(paramValue);
					} else if (paramName.trim().equals("state_id")) {
						System.out.println("StoreRegistrationServlet :: state_id ==> "+paramValue);
						storeregistrationBean.setSid(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("city_id")) {
						System.out.println("StoreRegistrationServlet :: city_id ==> "+paramValue);
						storeregistrationBean.setCid(Integer.parseInt(paramValue)); 
					}else if (paramName.trim().equals("area_id")) {
						System.out.println("StoreRegistrationServlet :: area_id ==> "+paramValue);
						storeregistrationBean.setAid(Integer.parseInt(paramValue));
					}else if (paramName.trim().equals("store_ownerEmail")) {
						System.out.println("StoreRegistrationServlet :: state_ownerEmail ==> "+paramValue);
						storeregistrationBean.setStore_ownerEmail(paramValue);
					}
				} else {
					try {
						String itemName = item.getName();
						Random generator = new Random();
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
						
						System.out.println("Image Path :: "+savedFile);
						item.write(savedFile);

						storeregistrationBean.setStore_Image("C:\\Users\\A to Z\\eclipse-workspace\\designing\\WebContent\\resources\\uploadimg\\"
								+ finalImage);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		}
		StoreRegistrationDao storeregistrationDao = new StoreRegistrationDao();
		if (storeregistrationDao.insert(storeregistrationBean) != 0) {
			rd = request.getRequestDispatcher("ListStoreServlet");
		} else {
			rd = request.getRequestDispatcher("store_registration.jsp");
		}
		rd.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


