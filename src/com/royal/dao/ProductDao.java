package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.royal.bean.ProductBean;
import com.royal.util.DBConnection;

public class ProductDao 
{
	public boolean insert(ProductBean productBean) 
	{
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO product(product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_ownerEmail,storeID,Gender,Age) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int rowEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setString(1, productBean.getProduct_Name());
				pstmt.setString(2, productBean.getProduct_Desc());
				pstmt.setInt(3, productBean.getProduct_Price());
				pstmt.setString(4, productBean.getProduct_Weight());
				pstmt.setInt(5, productBean.getOccasionID());
				pstmt.setInt(6, productBean.getCategoryID());
				pstmt.setInt(7, productBean.getSubcategoryID());
				pstmt.setString(8, productBean.getProduct_Image1());
				pstmt.setString(9, productBean.getProduct_Image2());
				pstmt.setInt(10, productBean.getNo_of_product());
				pstmt.setString(11, productBean.getStore_ownerEmail());
				pstmt.setInt(12,productBean.getStoreID() );
				pstmt.setString(13,productBean.getGender() );
				pstmt.setString(14,productBean.getAge() );
				
				rowEffected = pstmt.executeUpdate();
				if(rowEffected>0) {
					return true;
				}
			} 
			
			catch (SQLException e)
			{
				e.printStackTrace();
			}

		} 
		else 
		{
			System.out.println("Db not Connected StoreRegistrationDao");
		}
	
		return false;
	}
	
	
//	public ArrayList<ProductBean> getAllProducts(String store_ownerEmail) 
//	{
//		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
//		ProductBean productBean = null;
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement pstmt = null;
//		String selectProducts = "SELECT productID,product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product  FROM product WHERE store_ownerEmail=?";
//		ResultSet rs=null;
//		if (conn!=null) 
//		{
//			try 
//			{
//
//				pstmt = conn.prepareStatement(selectProducts);
//				pstmt.setString(1, store_ownerEmail);
//				rs = pstmt.executeQuery();
//				
//				System.out.println("StoreDao :: getAllStores :: store_ownerEmail ==>"+store_ownerEmail);
//				 
//
//				 while (rs.next()) 
//				 {
//					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11));
//					 listofProducts.add(productBean);
//				 }
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		} else 
//		{
//				System.out.println("StoreDao - getAllstore() Db not connected ");
//		}
//		return listofProducts;		
//	}
	
	public ArrayList<ProductBean> getAllProducts(int storeID) 
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "SELECT productID, product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, Gender, Age  FROM product WHERE storeID=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, storeID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: getAllProducts :: storeID ==>"+storeID);
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getString(13));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllProduct() Db not connected ");
		}
		return listofProducts;		
	}
	
	
	
	public ArrayList<ProductBean> getAllProductsByCategory(int categoryID) 
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "SELECT productID, product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, Gender, Age  FROM product WHERE categoryID=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{
				
				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, categoryID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: getAllProducts :: storeID ==>"+categoryID);
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getString(13));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllProduct() Db not connected ");
		}
		return listofProducts;		
	}
	
	
	

	public int update(ProductBean productBean) 
	{
		Connection conn = DBConnection.getConnection();
		String updateProduct = "UPDATE product SET product_Name=?, product_Desc=?, product_Price=?, product_Weight=?, occasionID=?, categoryID=?, subcategoryID=?, product_Image1=?, product_Image2=?, no_of_product=?, store_ownerEmail=?, Gender=?, Age=? WHERE productID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn!=null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(updateProduct);
			
				pstmt.setString(1, productBean.getProduct_Name());
				pstmt.setString(2, productBean.getProduct_Desc());
				pstmt.setInt(3, productBean.getProduct_Price());
				pstmt.setString(4, productBean.getProduct_Weight());
				pstmt.setInt(5, productBean.getOccasionID());
				pstmt.setInt(6, productBean.getCategoryID());
				pstmt.setInt(7, productBean.getSubcategoryID());
				pstmt.setString(8, productBean.getProduct_Image1());
				pstmt.setString(9, productBean.getProduct_Image2());
				pstmt.setInt(10, productBean.getNo_of_product());
				pstmt.setString(11, productBean.getStore_ownerEmail());
				pstmt.setString(12, productBean.getGender());
				pstmt.setString(13, productBean.getAge());
				pstmt.setInt(14, productBean.getProductID());
				
				rowsEffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else {
			System.out.println("ProductDao : update() Db not connected");	
		}
		System.out.println("ProductDao ===> Update ==> rowsEffected ==> "+rowsEffected);
		System.out.println("ProductDao ===> Update ==> Number Of Product ==> "+productBean.getNo_of_product());
		return rowsEffected;
	}


	public ProductBean getProductByID(int productID)
	{
		ProductBean productBean = null;
		String selectProducts = "SELECT product_Name, product_Desc, product_Price, product_Weight, o.occasiontitle, c.categoryName, s.subcategoryName, product_Image1, product_Image2, no_of_product, store_ownerEmail, storeID,Gender,Age  FROM product p, occasion_details o, category c, sub_category s WHERE productID=? AND p.occasionID=o.occasionID AND p.categoryID=c.categoryID AND p.subcategoryID=s.subcategoryID";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, productID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					productBean = new ProductBean(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),rs.getString(11),rs.getInt(12),rs.getString(13),rs.getString(14));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("ProductBean :: getProductByID(int productID)");
		}
		return productBean;
	}
//	
//	public StoreBean getStoreByID(int storeID)
//	{
//		StoreBean storeBean = null;
//		System.out.println("SDao :: getStoreBYID :: storeID==> "+storeID);
//		String selectstore = "SELECT storeID, store_Name, store_address, store_contact, store_Image, store_GST_No, aid, cid, sid, store_ownerEmail  FROM store_detail WHERE storeID=?";
//		Connection conn = DBConnection.getConnection();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	
//		if (conn != null) 
//		{
//			try 
//			{
//				pstmt = conn.prepareStatement(selectstore);
//				pstmt.setInt(1, storeID);
//				rs = pstmt.executeQuery();
//				
//				while (rs.next()) 
//				{
//					storeBean = new StoreBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getString(10));
//				}
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//		} else 
//		{
//			System.out.println("CategoryBean :: getCategoryByPK(int categoryID)");
//		}
//		return storeBean;
//	}
//
//
	public int delete(int productID) 
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM product WHERE productID = ?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, productID);
			
				rowsEffected = pstmt.executeUpdate();
			
			}catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("ProductDao :: delete() DB not connected ");
		}
		return rowsEffected;
		
	}
//
//
//	public String checkStore(String store_ownerEmail)
//	{
//		int storeID = 0;
//		String store_Name=null;
//		Connection conn=DBConnection.getConnection();
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		String selectQuery="SELECT storeID, store_Name FROM store_detail WHERE store_ownerEmail=?";
//		
//		
//		if (conn!=null)
//		{
//			try 
//			{
//				pstmt=conn.prepareStatement(selectQuery);
//				pstmt.setString(1, store_ownerEmail);
//				rs=pstmt.executeQuery();
//				if (rs.next()) 
//				{
//					storeID=Integer.parseInt(rs.getString(1));
//					store_Name=rs.getString(2);
//				} 
//				System.out.println("StoreID ==> "+storeID);
//				System.out.println("Store_Name ==> "+store_Name);
//				System.out.println("Store_ownerEmail ==> "+store_ownerEmail);
//
//			} catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		}
//		else 
//		{
//			System.out.println("DB Not Connected StoreDao ::checkStore()");
//		}
//				
//		return store_Name;
//	}


	public ArrayList<ProductBean> sortProducts(String Gender, String Age, int occasionID) 
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "select productID, product_Name, product_Desc, product_Price, product_Weight, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_Name, store_address  FROM product p, store_detail s WHERE p.storeID=s.storeID AND Gender=? AND Age=? AND occasionID=?";
		ResultSet rs=null;
		
		
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setString(1, Gender);
				pstmt.setString(2, Age);
				pstmt.setInt(3, occasionID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: sortProducts :: Gender ==>"+Gender);
				System.out.println("ProductDao :: sortProducts :: Age ==>"+Age);
				System.out.println("ProductDao :: sortProducts :: OccasionID ==>"+occasionID);
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllProduct() Db not connected ");
		}
		
		
		
		return listofProducts;
	}
	
	
	
	public ProductBean getProductDetailByID(int productID)
	{
		ProductBean productBean = null;
		String selectProducts = "SELECT productID,product_Name, product_Desc, product_Price, product_Weight, o.occasionID, o.occasiontitle, c.categoryID, c.categoryName, s.subcategoryID, s.subcategoryName, product_Image1, product_Image2, no_of_product, store_ownerEmail,storeID,Gender,Age  FROM product p, occasion_details o, category c, sub_category s WHERE productID=? AND p.occasionID=o.occasionID AND p.categoryID=c.categoryID AND p.subcategoryID=s.subcategoryID";
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = DBConnection.getConnection();
		ResultSet rs = null;
	
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, productID);
				rs = pstmt.executeQuery();
				
				while (rs.next()) 
				{
					productBean = new ProductBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14),rs.getString(15),rs.getInt(16),rs.getString(17),rs.getString(18));
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("ProductBean :: getProductByID(int productID)");
		}
		return productBean;
	}


	public int AddToCart(ProductBean productBean,String email,int userID) {
		int rowEffected = 0;	
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		String insertQuery = "INSERT INTO cart_detail(productID,product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_ownerEmail,storeID,Gender,Age,email,userID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
				
				pstmt.setInt(1, productBean.getProductID());
				pstmt.setString(2, productBean.getProduct_Name());
				pstmt.setString(3, productBean.getProduct_Desc());
				pstmt.setInt   (4,    productBean.getProduct_Price());
				pstmt.setString(5, productBean.getProduct_Weight());
				pstmt.setInt   (6,    productBean.getOccasionID());
				pstmt.setInt   (7,    productBean.getCategoryID());
				pstmt.setInt   (8,    productBean.getSubcategoryID());
				pstmt.setString(9, productBean.getProduct_Image1());
				pstmt.setString(10,productBean.getProduct_Image2());
				pstmt.setInt   (11,   productBean.getNo_of_product());
				pstmt.setString(12,productBean.getStore_ownerEmail());
				pstmt.setInt   (13,   productBean.getStoreID() );
				pstmt.setString(14,productBean.getGender() );
				pstmt.setString(15,productBean.getAge() );
				pstmt.setString(16,email);
				pstmt.setInt   (17, userID);

				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProductID());    
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Name());    
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Desc());    
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Price());   
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Weight());  
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getOccasionID());
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getOccasiontitle());      
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getCategoryID());
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getCategoryName());      
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getSubcategoryID());   
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getSubcategoryName());      
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Image1());  
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getProduct_Image2());  
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getNo_of_product());   
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getStore_ownerEmail());
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getStoreID() );        
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getGender() );         
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+productBean.getAge() );            
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+email);            
				System.out.println("ProductDao :: AddToCart() :: product_Name :: "+userID);            
				rowEffected = pstmt.executeUpdate();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		} 
		else 
		{
			System.out.println("Db not Connected ProductDao :: AddtoCart");
		}
				
		return rowEffected;
	
}


	public ArrayList<ProductBean> ListCartProducts(int userID) {
		ArrayList<ProductBean> listcartproducts = new ArrayList<ProductBean>();
		Connection conn = DBConnection.getConnection();
		ProductBean productBean=new ProductBean();
		PreparedStatement pstmt = null;
		String listofproducts = "SELECT productID, product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_ownerEmail, storeID, Gender, Age FROM cart_detail WHERE userID=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(listofproducts);
				pstmt.setInt(1, userID);
				rs = pstmt.executeQuery();
				
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getInt(13),rs.getString(14),rs.getString(15));
					 listcartproducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("ProductDao - ListCartProducts() Db not connected ");
		}
		return listcartproducts;
	}


	public int DeleteFromCart(int productID, int userID) 
	{
		Connection conn = DBConnection.getConnection();
		
		String deleteQuery = "DELETE FROM cart_detail WHERE productID = ? AND userID=?";
		PreparedStatement pstmt = null;
		int rowsEffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(deleteQuery);
				
				pstmt.setInt(1, productID);
				pstmt.setInt(2, userID);
			
				rowsEffected = pstmt.executeUpdate();
			
			}catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}else 
		{
			System.out.println("ProductDao :: DeleteFromCart() DB not connected ");
		}
		return rowsEffected;
	}


	public ArrayList<ProductBean> sortProductsByPriceLowToHigh(String Gender,String Age,int occasionID) 
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "select productID, product_Name, product_Desc, product_Price, product_Weight, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, store_Name, store_address  FROM product p, store_detail s WHERE p.storeID=s.storeID AND Gender=? AND Age=? AND occasionID=? AND product p ORDER BY product_Price asc";
		ResultSet rs=null;
		
		
		if (conn!=null) 
		{
			try 
			{

				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setString(1, Gender);
				pstmt.setString(2, Age);
				pstmt.setInt(3, occasionID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: sortProducts :: Gender ==>"+Gender);
				System.out.println("ProductDao :: sortProducts :: Age ==>"+Age);
				System.out.println("ProductDao :: sortProducts :: OccasionID ==>"+occasionID);
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getString(8),rs.getString(9),rs.getInt(10),rs.getString(11),rs.getString(12));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllProduct() Db not connected ");
		}
		
		
		
		return listofProducts;
	}


	public ArrayList<ProductBean> getAllProductsBySubCategory(int subcategoryID)
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "SELECT productID, product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, Gender, Age  FROM product WHERE subcategoryID=?";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{
				
				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, subcategoryID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: getAllProducts :: subcategoryID ==>"+subcategoryID);
				 
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getString(13));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("StoreDao - getAllProduct() Db not connected ");
		}
		return listofProducts;		
		}


	public ArrayList<ProductBean> FilterProducts(int categoryID, int subcategoryID, int occasionID) 
	{
		ArrayList<ProductBean> listofProducts = new ArrayList<ProductBean>();
		ProductBean productBean = null;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		String selectProducts = "SELECT productID, product_Name, product_Desc, product_Price, product_Weight, occasionID, categoryID, subcategoryID, product_Image1, product_Image2, no_of_product, Gender, Age, COUNT(product_Name) AS NumOccurrences FROM product WHERE categoryID=? AND subcategoryID=? AND occasionID=? GROUP BY product_Name HAVING ( COUNT(product_Name) > 1 );";
		ResultSet rs=null;
		if (conn!=null) 
		{
			try 
			{
				
				pstmt = conn.prepareStatement(selectProducts);
				pstmt.setInt(1, categoryID);
				pstmt.setInt(2, subcategoryID);
				pstmt.setInt(3, occasionID);
				rs = pstmt.executeQuery();
				
				System.out.println("ProductDao :: getAllProducts :: categoryID ==>"+categoryID);
				System.out.println("ProductDao :: getAllProducts :: subcategoryID ==>"+subcategoryID);
				System.out.println("ProductDao :: getAllProducts :: occasionID ==>"+occasionID);
				
				 while (rs.next()) 
				 {
					 productBean = new ProductBean(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getInt(7),rs.getInt(8),rs.getString(9),rs.getString(10),rs.getInt(11),rs.getString(12),rs.getString(13));
					 listofProducts.add(productBean);
				 }
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
				System.out.println("ProductDao - FilterProducts() Db not connected ");
		}
		return listofProducts;		
	}


	

}
