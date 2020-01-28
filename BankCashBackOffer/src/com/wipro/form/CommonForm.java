package com.wipro.form;

import org.springframework.stereotype.Component;

@Component
public class CommonForm {
	
	private String customerid;
	private String Password;
	private String couponcode;
	private float offerpercentage;
	private boolean flag;
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	private int balance; 

	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCouponcode() {
		return couponcode;
	}
	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}
	public float getOfferpercentage() {
		return offerpercentage;
	}
	public void setOfferpercentage(float offerpercentage) {
		this.offerpercentage = offerpercentage;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	

}
