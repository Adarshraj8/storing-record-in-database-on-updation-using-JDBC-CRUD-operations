package com.edu.bean;

public class UserDTO {
	private String rid;
	private String uid;
	 private String name;
	 private String phone;
	 private String countryName;
	 private String uflag;
	 private String dateTime;
	 
	public String getUflag() {
		return uflag;
	}
	public void setUflag(String uflag) {
		this.uflag = uflag;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
}
