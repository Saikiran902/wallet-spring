package com.cg.kyc.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer_wallet")
public class Wallet {
	
	@Column(name="cust_name")
	@NotEmpty(message="name should not be empty")
   private String custName;
	@Id
	@Column(name="cust_mobno")
	@NotEmpty(message="mobile number should not be empty")
   private String mobNo;
	
	@Column(name="cust_bal")
   private Double balance;

	public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getMobNo() {
	return mobNo;
}
public void setMobNo(String mobNo) {
	this.mobNo = mobNo;
}
public Double getBalance() {
	return balance;
}
public void setBalance(Double balance) {
	this.balance = balance;
}
public Wallet() {
	super();
	// TODO Auto-generated constructor stub
}
public Wallet(String custName, String mobNo, Double balance) {
	super();
	this.custName = custName;
	this.mobNo = mobNo;
	this.balance = balance;
}
   
}
