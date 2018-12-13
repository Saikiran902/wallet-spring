package com.cg.kyc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.kyc.dto.PrintTransactions;
import com.cg.kyc.dto.Wallet;
import com.cg.kyc.exception.MyException;
import com.cg.kyc.service.Iwalletservice;

@Controller
public class MyController {
	@Autowired
	Iwalletservice walSer;
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String all()
	{
		return "home";
	}
	
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String addCustomer(@ModelAttribute("my") Wallet wallet){
		return "addCustomer";
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertCustomer(@Valid@ModelAttribute("my") Wallet wallet,BindingResult res){
	
		if(res.hasErrors()){
			return new ModelAndView("addCustomer");
		}
	/*	if(walSer.numberExists(wallet.getMobNo()))
		{
			return new ModelAndView("error");
		}*/
			walSer.createAccount(wallet);
			
		return new ModelAndView("added");
	}
	
	@RequestMapping(value="show",method=RequestMethod.GET)
	public ModelAndView showCustDetails(){
		List<Wallet> custDetails=null;
		
			custDetails= walSer.showAccount();
		
		return new ModelAndView("showall","temp",custDetails);
			}
	
	@RequestMapping(value="deposit")
	public String depositAmt(@ModelAttribute("my") Wallet wallet){
		
		//wallet.setMobNo(wallet.getMobNo());
		
	return "depAmt";
			
	}
	
	@RequestMapping(value="depositmoney",method=RequestMethod.POST)
	public ModelAndView deposit(@RequestParam("mobNo") String mobNo,@RequestParam("balance") double amount,@ModelAttribute("my") Wallet wallet){
		
		boolean b = walSer.checkMobno(mobNo);
		if(b==true){
		
			double balance = walSer.depositAmt(mobNo,amount);
			
		return new ModelAndView("deposited","bal",balance);
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="withdraw")
	public String withdrawAmt(@ModelAttribute("my") Wallet wallet){
		return "wdrawAmt";
	}
	
	@RequestMapping(value="withdrawmoney",method=RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam("mobNo") String mobNo,@RequestParam("balance") double amount,@ModelAttribute("my") Wallet wallet){
		boolean b = walSer.checkMobno(mobNo);
		if(b==true){
		double balance = walSer.withdrawAmount(mobNo, amount);
		return new ModelAndView("withdrawn","bal",balance);
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value="transfer")
	public String doTransfer(@ModelAttribute("my") Wallet wallet){
		return "transfer";
	}
	
	@RequestMapping(value="dotransfer",method=RequestMethod.POST)
	public ModelAndView transfer(@RequestParam("smob") String mobNo,@RequestParam("tmob") String mobno,@RequestParam("bal") double amount,@ModelAttribute("my") Wallet wallet){
		if(walSer.checkMobno(mobNo) && walSer.checkMobno(mobno)){ 
		walSer.fundTransfer(mobNo,mobno, amount);
		return new ModelAndView("transferred","amt",amount);
		}
		else
		{
			return new ModelAndView("transfer");
		}
		
	}
	
	@RequestMapping(value="printtransactions")
	public String doPrint(@ModelAttribute("my") PrintTransactions wallet){
		return "print";
	}
	
	@RequestMapping(value="print",method=RequestMethod.POST)
	public ModelAndView printTransactions(@ModelAttribute("my") PrintTransactions wallet){
		boolean b = walSer.checkMobno(wallet.getMobileno());
		if(b==true){
		List<PrintTransactions> custDetails = null;
		System.out.println(wallet.getMobileno());
		custDetails = walSer.getTransactionList(wallet.getMobileno());
		return new ModelAndView("transactionsuccess","temp",custDetails);
		}
		else{
			return new ModelAndView("error");
	}
	
		}
}
