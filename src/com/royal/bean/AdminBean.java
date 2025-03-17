package com.royal.bean;

public class AdminBean 
{
	int adminID;
	String admin_Name,admin_Email,admin_password;

	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getAdmin_Name() {
		return admin_Name;
	}
	public void setAdmin_Name(String admin_Name) {
		this.admin_Name = admin_Name;
	}
	public String getAdmin_Email() {
		return admin_Email;
	}
	public void setAdmin_Email(String admin_Email) {
		this.admin_Email = admin_Email;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	
	public AdminBean(int adminID, String admin_Name, String admin_Email, String admin_password) 
	{
		super();
		this.adminID=adminID;
		this.admin_Name=admin_Name;
		this.admin_Email=admin_Email;
		this.admin_password=admin_password;
		
	}
	
	public AdminBean(String admin_Email, String admin_password) 
	{
		super();
		this.admin_Email=admin_Email;
		this.admin_password=admin_password;
	}
	
	public AdminBean() {}
	
	

}
