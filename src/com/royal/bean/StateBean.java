package com.royal.bean;

public class StateBean 
{

	private int sid;
	private String sname;
	
	public StateBean() {
		// TODO Auto-generated constructor stub
	}
	
	public StateBean(String sname)
	{
		super();
		this.sname = sname;
	}

	public StateBean(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


}
