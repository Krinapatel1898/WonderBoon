package com.royal.bean;

public class StoreOwnerRegistrationBean 
{
	int store_ownerID;
	String store_ownerName, store_ownerContact, store_ownerEmail, store_ownerPassword;
	int storeID;
	
	
	public StoreOwnerRegistrationBean(String store_ownerName, String store_ownerContact, String store_ownerEmail,String store_ownerPassword) 
	{
		super();
		this.store_ownerName=store_ownerName;
		this.store_ownerContact=store_ownerContact;
		this.store_ownerEmail=store_ownerEmail;
		this.store_ownerPassword=store_ownerPassword;
		
	}
	
	
	public StoreOwnerRegistrationBean() 
	{
		super();		
	}
	
	
	
	

	public int getStore_ownerID() {
		return store_ownerID;
	}
	public void setStore_ownerID(int store_ownerID) {
		this.store_ownerID = store_ownerID;
	}
	public String getStore_ownerName() {
		return store_ownerName;
	}
	public void setStore_ownerName(String store_ownerName) {
		this.store_ownerName = store_ownerName;
	}
	public String getStore_ownerContact() {
		return store_ownerContact;
	}
	public void setStore_ownerContact(String store_ownerContact) {
		this.store_ownerContact = store_ownerContact;
	}
	public String getStore_ownerEmail() {
		return store_ownerEmail;
	}
	public void setStore_ownerEmail(String store_ownerEmail) {
		this.store_ownerEmail = store_ownerEmail;
	}
	public String getStore_ownerPassword() {
		return store_ownerPassword;
	}
	public void setStore_ownerPassword(String store_ownerPassword) {
		this.store_ownerPassword = store_ownerPassword;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	
	
	
	
	
	
	
}
