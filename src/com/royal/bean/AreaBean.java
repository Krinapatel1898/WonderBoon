package com.royal.bean;

public class AreaBean 
{
	private int aid;
	private String aname;
	private int cid;
	private String cname;
	public AreaBean() {
		super();
	}
	public AreaBean(String aname, int cid) {
		super();
		this.aname = aname;
		this.cid = cid;
	}
	
	public AreaBean(int aid, String aname, int cid) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.cid = cid;
	}
	public AreaBean(int aid, String aname, int cid,String cname) {
		super();
		this.aid = aid;
		this.aname=aname;
		this.cid = cid;
		this.cname = cname;	
	}
	public AreaBean(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname=aname;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

}
