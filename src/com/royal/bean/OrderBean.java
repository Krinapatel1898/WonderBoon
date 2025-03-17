package com.royal.bean;

public class OrderBean 
{
	String firstname,lastname,contact,email,address1,address2,state,area,city,productImage1;
	String productImage2,postcode,product_Name,product_Desc,store_ownerEmail,delivery_date,delivery_time;
	int productID,product_quantity,storeID,orderID,product_Price;
	String sname;
	String cname;
	String aName,status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public int getStoreID() {
		return storeID;
	}
	public void setStoreID(int storeID) {
		this.storeID = storeID;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public String getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(String delivery_time) {
		this.delivery_time = delivery_time;
	}
	
	public String getStore_ownerEmail() {
		return store_ownerEmail;
	}
	public void setStore_ownerEmail(String store_ownerEmail) {
		this.store_ownerEmail = store_ownerEmail;
	}
	public String getProductImage1() {
		return productImage1;
	}
	public void setProductImage1(String productImage1) {
		this.productImage1 = productImage1;
	}
	public int getProductQuantity() {
		return product_quantity;
	}
	public void setProductQuantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getProductImage2() {
		return productImage2;
	}
	public void setProductImage2(String productImage2) {
		this.productImage2 = productImage2;
	}

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getProductName() {
		return product_Name;
	}
	public void setProductName(String product_Name) {
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
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public OrderBean() 
	{
		super();
	}
	
	public OrderBean(String firstname, String lastname, String contact, String email, String address1, String address2,
			String state,String area, String city, String postcode, String productName, String product_Desc, int product_Price,
			int productID) 
	{
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.state = state;
		this.city = city;
		this.postcode = postcode;
		this.product_Name = productName;
		this.product_Desc = product_Desc;
		this.product_Price = product_Price;
		this.productID = productID;
	}
	public OrderBean(int orderID, String product_Name, int product_Price, int product_quantity, String firstname, String lastname, String contact,
			String email, String address1, String address2, String sname, String cname, String aName,
			String postcode, String store_ownerEmail, String delivery_date, String delivery_time) 
	{
		this.orderID		=orderID	; 
		this.product_Name	=product_Name	; 
		this.product_Price	=product_Price	; 
		this.product_quantity=product_quantity; 
		this.firstname		=firstname		; 
		this.lastname		=lastname		; 
		this.contact		=contact	; 
		this.email			=email			; 
		this.address1		=address1		; 
		this.address2		=address2		; 
		this.sname			=sname			; 
		this.cname			=cname			; 
		this.aName			=aName			; 
		this.postcode		=postcode		; 
		this.store_ownerEmail=store_ownerEmail; 
		this.delivery_date	=delivery_date	; 
		this.delivery_time	=delivery_time	; 
	}
	
	public OrderBean(int orderID, String product_Name, int product_Price, int product_quantity, String firstname, String lastname, String contact,
			String email, String address1, String address2, String sname, String cname, String aName,
			String postcode, String store_ownerEmail, String delivery_date, String delivery_time,String status) 
	{
		this.orderID		=orderID	; 
		this.product_Name	=product_Name	; 
		this.product_Price	=product_Price	; 
		this.product_quantity=product_quantity; 
		this.firstname		=firstname		; 
		this.lastname		=lastname		; 
		this.contact		=contact	; 
		this.email			=email			; 
		this.address1		=address1		; 
		this.address2		=address2		; 
		this.sname			=sname			; 
		this.cname			=cname			; 
		this.aName			=aName			; 
		this.postcode		=postcode		; 
		this.store_ownerEmail=store_ownerEmail; 
		this.delivery_date	=delivery_date	; 
		this.delivery_time	=delivery_time	;
		this.status=status;
	}
}

