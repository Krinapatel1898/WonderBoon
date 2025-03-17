package com.royal.bean;

public class CategoryBean 
{
	int categoryID;
	String categoryName;
	
	
	public CategoryBean() 
	{
	
	}
	

	
	
	public CategoryBean(int categoryID, String categoryName) 
	{
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	public CategoryBean(String categoryName) 
	{
		super();
		this.categoryName = categoryName;
	}


	public int getCategoryID() 
	{
		return categoryID;
	}


	public void setCategoryID(int categoryID) 
	{
		this.categoryID = categoryID;
	}


	public String getCategoryName() 
	{
		return categoryName;
	}


	public void setCategoryName(String categoryName) 
	{
		this.categoryName = categoryName;
	}
}
