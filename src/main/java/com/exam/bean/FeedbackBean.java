package com.exam.bean;

import java.io.Serializable;

public class FeedbackBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sid;
	private String name;
	private String feedback;
	public int getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = Integer.parseInt(sid);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
