package com.cg.kyc.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="printtransactions")
public class PrintTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tranid;
	private String mobileno;
	private String trantype;
	private double amount;
	private Date trandate;
	
	public PrintTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrintTransactions(String mobNo, String tranType,
			double amount) {
		super();
		this.trandate = new Date();
		this.mobileno = mobNo;
		this.trantype = tranType;
		this.amount = amount;
	}

	public Integer getTranid() {
		return tranid;
	}

	public void setTranid(Integer tranid) {
		this.tranid = tranid;
	}
	

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getTrantype() {
		return trantype;
	}

	public void setTrantype(String trantype) {
		this.trantype = trantype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getTrandate() {
		return trandate;
	}

	public void setTrandate(Date trandate) {
		this.trandate = trandate;
	}

	@Override
	public String toString() {
		return "PrintTransactions [tranId=" + tranid + ", mobNo=" + mobileno
				+ ", tranType=" + trantype + ", amount=" + amount
				+ ", tranDate=" + trandate + "]";
	}
	

}
