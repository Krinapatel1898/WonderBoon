package com.royal.bean;

public class WishListBean 
{
	int wishID;
	int productID;
	String product_Name, product_Desc;
	int product_Price;
	String product_Weight;
	int categoryID,subcategoryID;
	String product_Image1,img1,img2,product_Image2;
	int no_of_product;
	String store_ownerEmail;
	int storeID,userID;
	String email;
	public int getWishID() {
		return wishID;
	}
	public void setWishID(int wishID) {
		this.wishID = wishID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Desc() {
		return product_Desc;
	}
	public void setProduct_Desc(String product_Desc) {
		this.product_Desc = product_Desc;
	}
	public int getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}
	public String getProduct_Weight() {
		return product_Weight;
	}
	public void setProduct_Weight(String product_Weight) {
		this.product_Weight = product_Weight;
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public int getSubcategoryID() {
		return subcategoryID;
	}
	public void setSubcategoryID(int subcategoryID) {
		this.subcategoryID = subcategoryID;
	}
	public String getProduct_Image1() {
		return product_Image1;
	}
	public void setProduct_Image1(String product_Image1) {
		this.product_Image1 = product_Image1;
	}
	public String getImg1() {
		setDisplayImagePath1();
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		setDisplayImagePath2();
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getProduct_Image2() {
		return product_Image2;
	}
	public void setProduct_Image2(String product_Image2) {
		this.product_Image2 = product_Image2;
	}
	public int getNo_of_product() {
		return no_of_product;
	}
	public void setNo_of_product(int no_of_product) {
		this.no_of_product = no_of_product;
	}
	public String getStore_ownerEmail() {
		return store_ownerEmail;
	}
	public void setStore_ownerEmail(String store_ownerEmail) {
		this.store_ownerEmail = store_ownerEmail;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	private void setDisplayImagePath1() {
		String filePath = product_Image1;
		String path[] = filePath.split("\\\\");
		System.out.println(path.length);
		StringBuilder madePath = new StringBuilder();
		boolean flag = false;
		boolean extstatus = false;

		for (int j = 0; j < path.length; j++) {
			if ("resources".equals(path[j])) {
				madePath.append(path[j]);
				madePath.append("\\");
				flag = true;
			} else {
				if (flag) {
					madePath.append(path[j]);
					if (!path[j].contains("jpgg")) {
						extstatus = true;
						madePath.append("\\");
					}
				}
			}
		}
		StringBuilder extStringPath = new StringBuilder(madePath);
		if (extstatus) {
			extStringPath.deleteCharAt(extStringPath.length() - 1);
			madePath = extStringPath;
		}
		System.out.println("setDisplayImagePath1 ==> MadePath : " + madePath);
		this.img1 = madePath.toString();

	}
	
	
	private void setDisplayImagePath2() {
		String filePath = product_Image2;
		String path[] = filePath.split("\\\\");
		System.out.println(path.length);
		StringBuilder madePath = new StringBuilder();
		boolean flag = false;
		boolean extstatus = false;

		for (int j = 0; j < path.length; j++) {
			if ("resources".equals(path[j])) {
				madePath.append(path[j]);
				madePath.append("\\");
				flag = true;
			} else {
				if (flag) {
					madePath.append(path[j]);
					if (!path[j].contains("jpgg")) {
						extstatus = true;
						madePath.append("\\");
					}
				}
			}
		}
		StringBuilder extStringPath = new StringBuilder(madePath);
		if (extstatus) {
			extStringPath.deleteCharAt(extStringPath.length() - 1);
			madePath = extStringPath;
		}
		System.out.println("setDisplayImagePath2 ==> MadePath : " + madePath);
		this.img2 = madePath.toString();

	}
	
	

	public WishListBean(int wishID, int productID, String product_Name, String product_Desc, int product_Price,
			String product_Weight, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail, int storeID, String email)
	{
		super();
		this.wishID = wishID;
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.categoryID = categoryID;
		this.subcategoryID = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
		this.storeID = storeID;
		this.email = email;
	}
	
	
	public WishListBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
