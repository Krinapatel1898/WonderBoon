 <%@page import="com.royal.bean.StoreBean"%>
<%@page import="com.royal.dao.StoreDao"%>
<%@page import="com.royal.bean.AreaBean"%>
<%@page import="com.royal.dao.AreaDao"%>
<%@page import="java.util.ArrayList"%>
<%@jsp import="list_of_store.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label for="exampleInputEmail1">Select Area</label>

		   <%
				String search = request.getParameter("search");
				String store_ownerEmail=(String) session.getAttribute("store_ownerEmail");	
				System.out.println("getstoresbysearch.jsp :: store_ownerEmail ==> "+store_ownerEmail);
				StoreDao storeDao = new StoreDao();
				ArrayList<StoreBean> listOfStores = storeDao.getStoreBySearch(store_ownerEmail,search);
			%>
				<table border="1">
					<tr>
						<th>StoreId</th>
						<th>Store_Name</th>
						<th>Store_Address</th>
						<th>Store_Contact</th>
						<th>Actions</th>
					</tr>
				<%
							for(int i=0;i<listOfStores.size();i++)
							{
								StoreBean storeBean = listOfStores.get(i);
				%>
							<tr>
								<td><%=storeBean.getStoreID()%></td>
								<td><%=storeBean.getStore_Name()%></td>
								<td><%=storeBean.getStore_address()%></td>
								<td><%=storeBean.getStore_contact()%></td>
								<td>
									<a href='ViewStoreServlet?storeID=<%=storeBean.getStoreID()%>' class="btn btn-primary"><i class="glyphicon glyphicon-eye-open"> </i> View Store</a>
									<a href='EditStoreServlet?storeID=<%=storeBean.getStoreID()%>' class="btn btn-success"><i class="glyphicon glyphicon-edit icon-white"></i> Update</a> 
									<a href='InsertProductServlet?storeID=<%=storeBean.getStoreID()%>' class="btn btn-warning"><i class="glyphicon glyphicon-plus"> </i> Add Product</a>
									<a href='DeleteStoreServlet?storeID=<%=storeBean.getStoreID()%>' class="btn btn-danger"><i class="glyphicon glyphicon-trash icon-white"></i> Delete Store</a>  
								</td>
							</tr>	
				<%
				}
				%>
				</table>

</body>
</html>