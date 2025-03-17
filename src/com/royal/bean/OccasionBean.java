package com.royal.bean;

public class OccasionBean 
{
	 int occasionID;
	 String occasiontitle, occasion_description;
	public int getOccasionID() {
		return occasionID;
	}
	public void setOccasionID(int occasionID) {
		this.occasionID = occasionID;
	}
	public String getOccasiontitle() {
		return occasiontitle;
	}
	public void setOccasiontitle(String occasiontitle) {
		this.occasiontitle = occasiontitle;
	}
	public String getOccasion_description() {
		return occasion_description;
	}
	public void setOccasion_description(String occasion_description) {
		this.occasion_description = occasion_description;
	}
	public OccasionBean(int occasionID, String occasiontitle, String occasion_description) {
		super();
		this.occasionID = occasionID;
		this.occasiontitle = occasiontitle;
		this.occasion_description = occasion_description;
	}
	public OccasionBean(String occasiontitle, String occasion_description) {
		super();
		this.occasiontitle = occasiontitle;
		this.occasion_description = occasion_description;
	}
	public OccasionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	 
}
