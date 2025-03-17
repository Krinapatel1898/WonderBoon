package com.royal.bean;

public class ProductBean {
	int productID;
	String product_Name, product_Desc;
	int product_Price;
	String product_Weight,occasiontitle,categoryName,subcategoryName,Age,Gender;
	int occasionID,categoryID,subcategoryID;
	String product_Image1,img1,img2,product_Image2;
	int no_of_product;
	String store_ownerEmail,store_Name,store_address;
	int storeID,userID;
	
	
	public String getStore_Name() {
		return store_Name;
	}
	public void setStore_Name(String store_Name) {
		this.store_Name = store_Name;
	}
	public String getStore_address() {
		return store_address;
	}
	public void setStore_address(String store_address) {
		this.store_address = store_address;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getOccasiontitle() {
		return occasiontitle;
	}
	public void setOccasiontitle(String occasiontitle) {
		this.occasiontitle = occasiontitle;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubcategoryName() {
		return subcategoryName;
	}
	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
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
	public int getOccasionID() {
		return occasionID;
	}
	public void setOccasionID(int occasionID) {
		this.occasionID = occasionID;
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
	
	
	public ProductBean(int productID,String product_Name,String product_Desc,int product_Price,String product_Weight,int occasionID,int categoryID,int subcategoryID,String product_Image1,String product_Image2,int no_of_product,int storeID) {
		super();
		this.productID		=productID		;
		this.product_Name	=product_Name	; 
		this.product_Desc	=product_Desc	; 
		this.product_Price	=product_Price	; 
		this.product_Weight	=product_Weight	; 
		this.occasionID		=occasionID		;
		this.categoryID		=categoryID		; 
		this.subcategoryID	=subcategoryID	; 
		this.product_Image1	=product_Image1	;
		this.product_Image2	=product_Image2	; 
		this.no_of_product	=no_of_product	;
		this.storeID		=storeID		;
		
	}
	
	
	

	public ProductBean(int productID, String product_Name, String product_Desc, int product_Price,
			String product_Weight, String occasiontitle, String categoryName, String subcategoryName,
			String product_Image1, String product_Image2, int no_of_product, String store_ownerEmail) {
		super();
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasiontitle = occasiontitle;
		this.categoryName = categoryName;
		this.subcategoryName = subcategoryName;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
	}
	
	public ProductBean(int productID, String product_Name, String product_Desc, int product_Price,
			String product_Weight, int occasionID, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail) {
		super();
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID = occasionID;
		this.categoryID = categoryID;
		this.subcategoryID = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
	}
	
	
	
	public ProductBean(String product_Name, String product_Desc, int product_Price, String product_Weight,
			String occasiontitle, String categoryName, String subcategoryName, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail) {
		super();
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasiontitle = occasiontitle;
		this.categoryName = categoryName;
		this.subcategoryName = subcategoryName;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
	}
	
	public ProductBean(String product_Name, String product_Desc, int product_Price, String product_Weight,
			String occasiontitle,String categoryName,String subcategoryName, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail,int storeID, String Gender, String Age) {
		super();
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasiontitle = occasiontitle;
		this.categoryName = categoryName;
		this.subcategoryName = subcategoryName;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
		this.storeID=storeID;
		this.Gender=Gender;
		this.Age=Age;
	}
	
	public ProductBean(int productID,String product_Name, String product_Desc, int product_Price, String product_Weight,int occasionID,
			String occasiontitle,int categoryID, String categoryName,int subcategoryID, String subcategoryName, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail,int storeID, String Gender, String Age) {
		super();
		this.productID=productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID=occasionID;
		this.occasiontitle = occasiontitle;
		this.categoryID=categoryID;
		this.categoryName = categoryName;
		this.subcategoryID=subcategoryID;
		this.subcategoryName = subcategoryName;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail = store_ownerEmail;
		this.storeID=storeID;
		this.Gender=Gender;
		this.Age=Age;
	}

	
	
	public ProductBean(String product_Name, String product_Desc, int product_Price, String product_Weight,
			int occasionID, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product, String store_ownerEmail) {
		super();
		this.product_Name    = product_Name;
		this.product_Desc    = product_Desc;
		this.product_Price   = product_Price;
		this.product_Weight  = product_Weight;
		this.occasionID      = occasionID;
		this.categoryID      = categoryID;
		this.subcategoryID   = subcategoryID;
		this.product_Image1  = product_Image1;
		this.product_Image2  = product_Image2;
		this.no_of_product   = no_of_product;
		this.store_ownerEmail= store_ownerEmail;
	}
	
	public ProductBean(String product_Name, String product_Desc, int product_Price, String product_Weight,
			int occasionID, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product) {
		super();
		this.product_Name   = product_Name;
		this.product_Desc   = product_Desc;
		this.product_Price  = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID     = occasionID;
		this.categoryID     = categoryID;
		this.subcategoryID  = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product  = no_of_product;
	}
	
	
	public ProductBean(int productID, String product_Name, String product_Desc, int product_Price,
			String product_Weight, int occasionID, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product) {
		super();
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID = occasionID;
		this.categoryID = categoryID;
		this.subcategoryID = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
	}
	
	public ProductBean(int productID, String product_Name, String product_Desc, int product_Price,
			String product_Weight, int occasionID, int categoryID, int subcategoryID, String product_Image1,
			String product_Image2, int no_of_product,String Gender, String Age) {
		super();
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID = occasionID;
		this.categoryID = categoryID;
		this.subcategoryID = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.Gender=Gender;
		this.Age=Age;
		
	}
	
	
	public ProductBean(int productID,String product_Name,String product_Desc,int product_Price,String product_Weight,
			int occasionID,int categoryID,int subcategoryID,String product_Image1, 
			String product_Image2,int no_of_product,String store_ownerEmail,int storeID,String Gender,String Age)
	{
		super();
		this.productID = productID;
		this.product_Name = product_Name;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.product_Weight = product_Weight;
		this.occasionID = occasionID;
		this.categoryID = categoryID;
		this.subcategoryID = subcategoryID;
		this.product_Image1 = product_Image1;
		this.product_Image2 = product_Image2;
		this.no_of_product = no_of_product;
		this.store_ownerEmail=store_ownerEmail;
		this.storeID=storeID;
		this.Gender=Gender;
		this.Age=Age;
	}
	
	
	
	public ProductBean(int productID, String product_Name, String product_Desc, int product_Price, String product_Weight, int categoryID, int subcategoryID, String product_Image1, String product_Image2, int no_of_product, String store_Name, String store_address) 
	{
		super();
		this.productID      =productID     ;
		this.product_Name   =product_Name  ;
		this.product_Desc   =product_Desc  ;
		this.product_Price  =product_Price ;
		this.product_Weight =product_Weight;
		this.categoryID     =categoryID    ;
		this.subcategoryID  =subcategoryID ;
		this.product_Image1 =product_Image1;
		this.product_Image2 =product_Image2;
		this.no_of_product  =no_of_product ;
		this.store_Name     =store_Name    ;
		this.store_address  =store_address ;
	}
	
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
