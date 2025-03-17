package com.royal.bean;

public class SubCategoryBean 
{
	int subcategoryID;
	String subcategoryName;
	int categoryID;
	String categoryName;
	
	

	public SubCategoryBean(int subcategoryID, String subcategoryName, int categoryID, String categoryName) 
	{
		super();
		this.subcategoryID = subcategoryID;
		this.subcategoryName = subcategoryName;
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	public SubCategoryBean(int subcategoryID, String subcategoryName, int categoryID) 
	{
		super();
		this.subcategoryID = subcategoryID;
		this.subcategoryName = subcategoryName;
		this.categoryID = categoryID;
	}
	
	public SubCategoryBean(int subcategoryID,String subcategoryName) 
	{
		super();
		this.subcategoryID = subcategoryID;
		this.subcategoryName = subcategoryName;
	}
	
	public SubCategoryBean(String subcategoryName,int categoryID) 
	{
		super();
		this.subcategoryName = subcategoryName;
		this.categoryID = categoryID;
	}
	
	
	
	public SubCategoryBean(String subcategoryName) 
	{
		super();
		this.subcategoryName = subcategoryName;
	}
	
	public SubCategoryBean() 
	{
	
	}

	public int getSubcategoryID() {
		return subcategoryID;
	}

	public void setSubcategoryID(int subcategoryID) {
		this.subcategoryID = subcategoryID;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
