package com.cg.kyc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.kyc.dto.PrintTransactions;
import com.cg.kyc.dto.Wallet;

@Repository("walDao")
public class WalletdaoImpl implements Iwalletdao {
    
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Wallet createAccount(Wallet wallet) {
		// TODO Auto-generated method stub
		em.persist(wallet);
		em.flush();
		

		return wallet;
	}

	@Override
	public List<Wallet> showAccount() {
		// TODO Auto-generated method stub
		Query queryOne = em.createQuery("FROM Wallet");
		List<Wallet> myList= queryOne.getResultList();
		return myList;
	
	}

	@Override
	public Wallet getAccountDetails(String mobno) {
		// TODO Auto-generated method stub
		//em.getTransaction().begin();
		Wallet wal = em.find(Wallet.class, mobno);
		//em.getTransaction().commit();
		return wal;
	}

	@Override
	public Wallet setAccountDetails(String mobno,double amt) {
		// TODO Auto-generated method stub

		//em.getTransaction().begin();
		Wallet wal  = em.find(Wallet.class, mobno);
		wal.setBalance(amt);
		em.merge(wal);
		//em.getTransaction().commit();
		return wal;
		
	}

	@Override
	public List<PrintTransactions> getTransactions(String mobileNo) {
		// TODO Auto-generated method stub
		List<PrintTransactions> transactionList = null;
		//em.getTransaction().begin();
		Query query = em.createQuery("from PrintTransactions where mobileno = :mobno");
		query.setParameter("mobno", mobileNo);
		transactionList = query.getResultList();
//		for(PrintTransactions p : transactionList)
//			System.out.println(p+"ajhbcjsd");
	//	em.getTransaction().commit();
		return transactionList;
		
		
	}

	@Override
	public boolean checkMobno(String mobno) {
		// TODO Auto-generated method stub
		Wallet wallet = em.find(Wallet.class, mobno);
		if(wallet==null){
		return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void loadTransactioninDB(PrintTransactions prt) {
		// TODO Auto-generated method stub
		em.persist(prt);
		
	}

/*	@Override
	public boolean numberExists(String mobno) {
	  Query qry=em.createQuery("FROM Wallet");
	  List<Wallet> li= qry.getResultList();
	  for(Wallet wal:li)
	  {
		  if(wal.getMobNo()==mobno)
		  {
			  return true;
		  }
	  }
		return false;
	}*/

	

	

	
	
}
