package com.royal.bean;

public class UserRegistrationBean
{
	private int userID;
	private String fullname;
	private String user_name;
	private String email;
	private String user_password;
	private String contact_no;

	

	public int getuserID() {
		return userID;
	}
	public void setuserID(int userID) {
		this.userID = userID;
	}
	public String getuser_name() {
		return user_name;
	}
	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	
	
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public UserRegistrationBean(int userID, String user_name, String fullname, String email, String user_password, String contact_no) {
		super();
		this.userID = userID;
		this.user_name = user_name;
		this.fullname = fullname;
		this.email = email;
		this.user_password = user_password;
		this.contact_no = contact_no;
	}
	
	
	public UserRegistrationBean( String fullname, String email, String user_password, String contact_no) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.user_password = user_password;
		this.contact_no = contact_no;
	}
	
	
	
	public UserRegistrationBean() 
	{
	
	}

}
