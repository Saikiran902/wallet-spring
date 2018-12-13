package com.cg.kyc.service;

import java.util.List;

import com.cg.kyc.dto.PrintTransactions;
import com.cg.kyc.dto.Wallet;
import com.cg.kyc.exception.MyException;

public interface Iwalletservice {
	public Wallet createAccount(Wallet wallet);
    public double withdrawAmount(String mobno,double amount);
	public List<Wallet> showAccount();
	public double depositAmt(String mobno,double amount);
	public Wallet fundTransfer(String smobNo,String tmobNo,double amount);
	public List<PrintTransactions> getTransactionList(String mobileNo);
	//public boolean numberExists(String mobno);
	public boolean checkMobno(String mobno);
}
