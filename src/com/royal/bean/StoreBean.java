package com.royal.bean;

public class StoreBean {
	int storeID;
	String store_Name, store_address, store_contact, store_Image,img_display, store_GST_No,aname,cname,sname;
	int aid, cid, sid;
	String store_ownerEmail;
	
	
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public int getStoreID() {
		return storeID;
	}
	
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

	public String getStore_contact() {
		return store_contact;
	}

	public void setStore_contact(String store_contact) {
		this.store_contact = store_contact;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public String getStore_ownerEmail() {
		return store_ownerEmail;
	}

	public void setStore_ownerEmail(String store_ownerEmail) {
		this.store_ownerEmail = store_ownerEmail;
	}

	public StoreBean(String store_Name, String store_Image) {
		super();
		this.store_Name = store_Name;
		this.store_Image = store_Image;
	}

	private void setDisplayImagePath() {
		String filePath = store_Image;
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
		System.out.println("MadePath : " + madePath);
		this.img_display = madePath.toString();

	}

	public String getImg_display() {
		setDisplayImagePath();
		return img_display;
	}

	public void setImg_display(String img_display) {
		this.img_display = img_display;
	}
	
	
	
	
	
	public StoreBean(int storeID, String store_Name,String store_address,String store_contact,String store_Image,String store_GST_No,int aid, String aname, int cid, String cname, int sid, String sname,String store_ownerEmail) {
		super();
		this.storeID = storeID;
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aname = aname;
		this.cname = cname;
		this.sname = sname;
		this.aid = aid;
		this.cid = cid;
		this.sid = sid;
		this.store_ownerEmail = store_ownerEmail;
	}
	public StoreBean(String store_Name, String store_address, String store_contact, String store_Image,
			String store_GST_No, int aid,String aname, int cid,String cname, int sid,String sname, String store_ownerEmail) {
		super();
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aid = aid;
		this.aname = aname;
		this.cid = cid;
		this.cname = cname;
		this.sid = sid;
		this.sname = sname;
		this.store_ownerEmail = store_ownerEmail;
	}

	public StoreBean(int storeID, String store_Name, String store_address, String store_contact, String store_Image,
			String store_GST_No, int aid, int cid, int sid, String store_ownerEmail) {
		super();
		this.storeID = storeID;
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aid = aid;
		this.cid = cid;
		this.sid = sid;
		this.store_ownerEmail = store_ownerEmail;
	}
	

	
	public StoreBean(String store_Name, String store_address, String store_contact, String store_Image,
			String store_GST_No, int aid, int cid, int sid, String store_ownerEmail) {
		super();
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aid = aid;
		this.cid = cid;
		this.sid = sid;
		this.store_ownerEmail = store_ownerEmail;
	}

	public StoreBean(int storeID, String store_Name, String store_address, String store_contact, String store_Image,
			String store_GST_No, int aid, int cid, int sid) {
		super();
		this.storeID = storeID;
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aid = aid;
		this.cid = cid;
		this.sid = sid;
	}

	public StoreBean(String store_Name, String store_address, String store_contact, String store_Image,
			String store_GST_No, int aid, int cid, int sid) {
		super();
		this.store_Name = store_Name;
		this.store_address = store_address;
		this.store_contact = store_contact;
		this.store_Image = store_Image;
		this.store_GST_No = store_GST_No;
		this.aid = aid;
		this.cid = cid;
		this.sid = sid;
	}

	public StoreBean(int storeID, String store_Name) {
		super();
		this.storeID = storeID;
		this.store_Name = store_Name;
	}

	public StoreBean() {
		super();
	}

}
