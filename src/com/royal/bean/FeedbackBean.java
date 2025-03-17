package com.royal.bean;

public class FeedbackBean
{
	int feedbackID;
	String feedback_message, First_Name, Last_Name,email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}
	public String getFeedback_message() {
		return feedback_message;
	}
	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	
	public FeedbackBean(int feedbackID, String feedback_message, String first_Name, String last_Name) {
		super();
		this.feedbackID = feedbackID;
		this.feedback_message = feedback_message;
		First_Name = first_Name;
		Last_Name = last_Name;
	}
	
	public FeedbackBean(int feedbackID, String feedback_message,String email, String first_Name, String last_Name) {
		super();
		this.feedbackID = feedbackID;
		this.feedback_message = feedback_message;
		this.email=email;
		this.First_Name = first_Name;
		this.Last_Name = last_Name;
	}
	
	public FeedbackBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
