package com.royal.bean;

public class StoreRegistrationBean
{
	int storeID;
	String store_Name, store_address, store_contact, store_Image, store_GST_No;
	int aid,cid,sid;
	String store_ownerEmail;

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
	public String getStoreName() {
		return store_Name;
	}
	public void setStoreName(String store_Name) {
		this.store_Name = store_Name;
	}
	public String getStore_Address() {
		return store_address;
	}
	public void setStore_Address(String store_address) {
		this.store_address = store_address;
	}
	public String getStore_Contact() {
		return store_contact;
	}
	public void setStore_Contact(String store_contact) {
		this.store_contact = store_contact;
	}
	public String getStore_Image() {
		return store_Image;
	}
	public void setStore_Image(String store_Image) {
		this.store_Image = store_Image;
	}
	public String getStore_GST_No() {
		return store_GST_No;
	}
	public void setStore_GST_No(String store_GST_No) {
		this.store_GST_No = store_GST_No;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	private void setDisplayImagePath() 
	{
		String filePath = store_Image;

		String path[] = filePath.split("\\\\");
		System.out.println(path.length);
		StringBuilder madePath = new StringBuilder();
		boolean flag = false;
		for (int j = 0; j < path.length; j++) 
		{
			if ("resources".equals(path[j])) 
			{
				madePath.append(path[j]);
				madePath.append("\\");
				flag = true;
			}else {
				if (flag) 
				{
					madePath.append(path[j]);
					if (!path[j].contains("jpg")) 
					{
						madePath.append("\\");
					}
				}

			}
		}
		System.out.println("MadePath : " + madePath);
		
		
		this.store_Image = madePath.toString();
	
	}
	
	public StoreRegistrationBean(String store_Name, String store_address, String store_contact, String store_Image,String store_GST_No, int aid, int cid, int sid, String store_ownerEmail) 
	{
		super();
		this.store_Name=store_Name;
		this.store_address=store_address;
		this.store_contact=store_contact;
		this.store_Image=store_Image;
		this.store_GST_No=store_GST_No;
		this.aid=aid;
		this.cid=cid;
		this.sid=sid;
		this.store_ownerEmail=store_ownerEmail;
	}
	
	public StoreRegistrationBean(String store_Name, String store_address, String store_contact, String store_GST_No, int aid, int cid, int sid, String store_ownerEmail) 
	{
		super();
		this.store_Name=store_Name;
		this.store_address=store_address;
		this.store_contact=store_contact;
		this.store_GST_No=store_GST_No;
		this.aid=aid;
		this.cid=cid;
		this.sid=sid;
		this.store_ownerEmail=store_ownerEmail;
	}
	
	
	public StoreRegistrationBean() 
	{
		super();
	}
	
	
	
}
