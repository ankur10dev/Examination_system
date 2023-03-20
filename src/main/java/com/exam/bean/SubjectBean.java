package com.exam.bean;

import java.io.Serializable;

public class SubjectBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int sid;
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = Integer.parseInt(sid);
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
