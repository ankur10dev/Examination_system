package com.exam.bean;

import java.io.Serializable;

public class RegisterBean implements Serializable{
	private static final long serialVersionUID = 1L;
	Integer id;
	String fullname;
	int rollno;
	String email;
	String phoneno;
	String password;
	String cpassword;
	String usertype;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = Integer.parseInt(rollno);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
