package com.cg.kyc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.kyc.dao.Iwalletdao;
import com.cg.kyc.dto.PrintTransactions;
import com.cg.kyc.dto.Wallet;
import com.cg.kyc.exception.MyException;

@Service("walSer")
@Transactional
public class WalletserviceImpl implements Iwalletservice {
	@Autowired
	Iwalletdao walDao;

	@Override
	public Wallet createAccount(Wallet wallet)  {
		// TODO Auto-generated method stub
		Wallet wal = walDao.createAccount(wallet);
		
		return wal;
	}

	@Override
	public List<Wallet> showAccount() {
		// TODO Auto-generated method stub
		
		List<Wallet> wal = walDao.showAccount();
		
		return wal;
	}

	@Override
	public double withdrawAmount(String mobno, double amount) {
		// TODO Auto-generated method stub
		String transactionType="withdraw";
		
		Wallet walWithDraw = walDao.getAccountDetails(mobno);
		double balance=walWithDraw.getBalance()-amount;
		walDao.setAccountDetails(mobno, balance);
		walDao.loadTransactioninDB(new PrintTransactions(mobno,transactionType,amount));
		return balance;

	}

	@Override
	public double depositAmt(String mobno, double amount)  {
		// TODO Auto-generated method stub
		String transactionType="deposit";
		Wallet walDeposit = walDao.getAccountDetails(mobno);
		
		double balance=walDeposit.getBalance()+amount;
		walDao.setAccountDetails(mobno, balance);
		walDao.loadTransactioninDB(new PrintTransactions(mobno,transactionType,amount));
		return balance;
	}

	@Override
	public Wallet fundTransfer(String smobNo, String tmobNo, double amount) {
		// TODO Auto-generated method stub
		String transactionType="transfer";
		 Wallet sourceMob = walDao.getAccountDetails(smobNo);
  	     Wallet destMob = walDao.getAccountDetails(tmobNo);
  	   
  	  /* if(sourceMob==null)
  	   {
  		   throw new MyException("enter valid source mobile number");
  	   }
  	   if(destMob==null){
  		   throw new MyException("enter valid destination mobile number");
  	   }*/
  	   
  	   
			if(sourceMob.getBalance()>amount){
			   walDao.setAccountDetails(tmobNo, destMob.getBalance() + amount);
				walDao.setAccountDetails(smobNo, sourceMob.getBalance() - amount);
//	return cliDao.getAccountDetails(sourceMobNo);
			   }
			  /* else{
				   throw new MyException("source mobile number balance should be greater than entered amount");
			   }*/
			walDao.loadTransactioninDB(new PrintTransactions(smobNo, transactionType, -amount));
			walDao.loadTransactioninDB(new PrintTransactions(tmobNo, transactionType, amount));
	
  	   return walDao.getAccountDetails(smobNo);
	
		
	}

	@Override
	public List<PrintTransactions> getTransactionList(String mobileNo) {
		// TODO Auto-generated method stub
List<PrintTransactions> list = null;
		
		list = walDao.getTransactions(mobileNo);
		
		return list;
		
	}

	@Override
	public boolean checkMobno(String mobno) {
		// TODO Auto-generated method stub
		//walDao.checkMobno(mobno);
		return 	walDao.checkMobno(mobno);
	}

/*	@Override
	public boolean numberExists(String mobno) {
		// TODO Auto-generated method stub
		return walDao.numberExists(mobno);
	}*/
   
	
	

	
  
}
